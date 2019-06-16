package com.lquan.ribbitMQ.queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * ClassName Send
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class Send {
    private static final String QUEUE_NAME = "test_simple_queque_xxx";
    public static void main(String[] args)  throws IOException, TimeoutException {
        // 获得连接
        Connection connection = ConnectionUtils.getConnection();
        // 获取通道
        Channel channel = connection.createChannel();
        // 创建队列生命
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        // 发送消息
        String msg = "Hello simple";
        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());

        System.out.println("send message");
        // 关闭连接
        channel.close();
        connection.clearBlockedListeners();

    }
}
