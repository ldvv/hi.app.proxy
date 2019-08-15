package com.hi.app.proxy;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

public class SecondProxy {

    public static void setProxy(){
        //设置二级代理
        Properties prop = System.getProperties();
        // 设置http访问要使用的代理服务器的地址
        prop.setProperty("http.proxyHost", "45.34.39.218");
        prop.setProperty("http.proxyPort", "12306");
        // 设置不需要通过代理服务器访问的主机，可以使用*通配符，多个地址用|分隔
//            prop.setProperty("http.nonProxyHosts", "localhost|192.168.0.*");

        // 设置安全访问使用的代理服务器地址与端口
        prop.setProperty("https.proxyHost", "45.34.39.218");
        prop.setProperty("https.proxyPort", "12306");
        // 它没有https.nonProxyHosts属性，它按照http.nonProxyHosts 中设置的规则访问

        // 使用ftp代理服务器的主机、端口以及不需要使用ftp代理服务器的主机
        prop.setProperty("ftp.proxyHost", "45.34.39.218");
        prop.setProperty("ftp.proxyPort", "12306");
        prop.setProperty("ftp.nonProxyHosts", "localhost|192.168.0.*");

        prop.setProperty("socksProxyHost", "45.34.39.218");
        prop.setProperty("socksProxyPort", "12306");

        System.setProperty("java.net.useSystemProxies", "true");
        // 设置登陆到代理服务器的用户名和密码
        Authenticator.setDefault(new MyAuthenticator("usa_user61", "tomtop666"));
    }

    static class MyAuthenticator extends Authenticator {
        private String user;
        private String password;

        public MyAuthenticator(String user, String password) {
            this.user = user;
            this.password = password;
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password.toCharArray());
        }
    }
}
