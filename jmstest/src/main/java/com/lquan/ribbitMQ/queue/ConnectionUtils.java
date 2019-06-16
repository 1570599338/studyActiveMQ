package com.lquan.ribbitMQ.queue;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/**
 * ClassName ConnectionUtils
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public  class ConnectionUtils {
    static String host="101.201.76.141";
    static int port=5672;
    static String virhost="/";
    static String username="coreservice_rw";
    static String password="9fbank";


    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        // 设置服务地址，协议，端口等
        factory.setHost(host);
        factory.setPort(port);
        factory.setVirtualHost(virhost);
        factory.setUsername(username);
        factory.setPassword(password);


        return factory.newConnection();

    }








}
