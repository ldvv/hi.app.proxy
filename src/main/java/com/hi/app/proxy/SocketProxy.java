package com.hi.app.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * http 代理程序
 * @author lulaijun
 *
 */
public class SocketProxy {

    private static Logger logger = LoggerFactory.getLogger(SocketProxy.class);

    static final int listenPort=8002;

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        ServerSocket serverSocket = new ServerSocket(listenPort);
        final ExecutorService tpe= Executors.newCachedThreadPool();
        logger.info("Proxy Server Start At "+sdf.format(new Date()));
        logger.info("listening port:"+listenPort+"……");

        while (true) {
            Socket socket;
            try {
                socket = serverSocket.accept();
                socket.setKeepAlive(true);
                //加入任务列表，等待处理
                tpe.execute(new ProxyTask(socket));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}