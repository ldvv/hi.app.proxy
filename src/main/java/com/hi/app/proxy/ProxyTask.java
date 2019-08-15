package com.hi.app.proxy;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 将客户端发送过来的数据转发给请求的服务器端，并将服务器返回的数据转发给客户端
 *
 */
public class ProxyTask implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(ProxyTask.class);

    private Socket socketIn;
    private Socket socketOut;

    private long totalUpload=0l;//总计上行比特数
    private long totalDownload=0l;//总计下行比特数

    public ProxyTask(Socket socket) {
        this.socketIn = socket;
    }

    private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    /** 已连接到请求的服务器 */
    private static final String AUTHORED = "HTTP/1.1 200 Connection established\r\n\r\n";
    /** 本代理登陆失败(此应用暂时不涉及登陆操作) */
    //private static final String UNAUTHORED="HTTP/1.1 407 Unauthorized\r\n\r\n";
    /** 内部错误 */
    private static final String SERVERERROR = "HTTP/1.1 500 Connection FAILED\r\n\r\n";

    public void run() {

        Map<String, Object> logMap = new HashMap<String, Object>();

        try {
            logMap.put("Request Time", sdf.format(new Date()));
            //二级代理设置
            //SecondProxy.setProxy();

            InputStream isIn = socketIn.getInputStream();
            OutputStream osIn = socketIn.getOutputStream();
            //从客户端流数据中读取头部，获得请求主机和端口
            HttpHeader header = HttpHeader.readHeader(isIn);

            //添加请求日志信息
            logMap.put("From    Host", socketIn.getInetAddress());
            logMap.put("From    Port", socketIn.getPort());
            logMap.put("Proxy   Method", header.getMethod());
            logMap.put("Request Host", header.getHost());
            logMap.put("Request Port", header.getPort());

            //如果没解析出请求请求地址和端口，则返回错误信息
            if (header.getHost() == null || header.getPort() == null) {
                osIn.write(SERVERERROR.getBytes());
                osIn.flush();
                return ;
            }

            // 查找主机和端口
            socketOut = new Socket(header.getHost(), Integer.parseInt(header.getPort()));
            socketOut.setKeepAlive(true);
            /*Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("45.34.39.218", 12306));
            socketOut = new Socket(proxy);
            Authenticator.setDefault(new SecondProxy.MyAuthenticator("usa_user61", "tomtop666"));
            socketOut.setKeepAlive(true);
            socketOut.connect(new InetSocketAddress(header.getHost(), Integer.parseInt(header.getPort())));*/

            InputStream isOut = socketOut.getInputStream();
            OutputStream osOut = socketOut.getOutputStream();
            //新开一个线程将返回的数据转发给客户端,串行会出问题，尚没搞明白原因
            Thread ot = new DataSendThread(isOut, osIn);
            ot.start();
            if (header.getMethod().equals(HttpHeader.METHOD_CONNECT)) {
                // 将已联通信号返回给请求页面
                osIn.write(AUTHORED.getBytes());
                osIn.flush();
            }else{
                //http请求需要将请求头部也转发出去
                byte[] headerData=header.toString().getBytes();
                totalUpload+=headerData.length;
                osOut.write(headerData);
                osOut.flush();
            }

            //读取客户端请求过来的数据转发给服务器
            readForwardDate(isIn, osOut);
            //等待向客户端转发的线程结束
            ot.join();
        } catch (Exception e) {
            e.printStackTrace();
            if(!socketIn.isOutputShutdown()){
                //如果还可以返回错误状态的话，返回内部错误
                try {
                    socketIn.getOutputStream().write(SERVERERROR.getBytes());
                } catch (IOException e1) {}
            }
        } finally {
            try {
                if (socketIn != null) {
                    socketIn.close();
                }
            } catch (IOException e) {}
            if (socketOut != null) {
                try {
                    socketOut.close();
                } catch (IOException e) {}
            }
            //纪录上下行数据量和最后结束时间并打印
            logMap.put("Up    Bytes", totalUpload);
            logMap.put("Down  Bytes", totalDownload);
            logMap.put("Closed Time", sdf.format(new Date()));
            logger.info(JSON.toJSONString(logMap));
        }
    }

    /**
     * 读取客户端发送过来的数据，发送给服务器端
     *
     * @param isIn
     * @param osOut
     */
    private void readForwardDate(InputStream isIn, OutputStream osOut) {
        byte[] buffer = new byte[4096];
        try {
            int len;
            while ((len = isIn.read(buffer)) != -1) {
                if (len > 0) {
                    osOut.write(buffer, 0, len);
                    osOut.flush();
                }
                totalUpload+=len;
                if (socketIn.isClosed() || socketOut.isClosed()) {
                    break;
                }
            }
        } catch (Exception e) {
            try {
                socketOut.close();// 尝试关闭远程服务器连接，中断转发线程的读阻塞状态
            } catch (IOException e1) {}
        }
    }

    /**
     * 将服务器端返回的数据转发给客户端
     *
     */
    class DataSendThread extends Thread {
        private InputStream isOut;
        private OutputStream osIn;

        DataSendThread(InputStream isOut, OutputStream osIn) {
            this.isOut = isOut;
            this.osIn = osIn;
        }

        @Override
        public void run() {
            byte[] buffer = new byte[4096];
            try {
                int len;
                while ((len = isOut.read(buffer)) != -1) {
                    if (len > 0) {
                        osIn.write(buffer, 0, len);
                        osIn.flush();
                        totalDownload+=len;
                    }
                    if (socketIn.isOutputShutdown() || socketOut.isClosed()) {
                        break;
                    }
                }
            } catch (Exception e) {
                logger.error("Response Error:", e);
            }
        }
    }

}
