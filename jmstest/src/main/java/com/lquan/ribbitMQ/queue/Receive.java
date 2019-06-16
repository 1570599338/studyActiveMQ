package com.lquan.ribbitMQ.queue;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * ClassName Receive
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class Receive {
    private static final String QUEUE_NAME = "test_simple_queque";

    public static void main(String[] args)  throws IOException, TimeoutException {
        // 获取连接
        Connection connection = ConnectionUtils.getConnection();
        // 创建通道
        Channel channel = connection.createChannel();
        // 队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        // 定义消费者
        Consumer consumer = new DefaultConsumer(channel){
            /**
             * No-op implementation of {@link Consumer#handleDelivery}.
             *
             * @param consumerTag
             * @param envelope
             * @param properties
             * @param body
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //super.handleDelivery(consumerTag, envelope, properties, body);
                String msg = new String(body,"UTF-8");
                System.out.print(msg);
            }
        };

        channel.basicConsume(QUEUE_NAME,true,consumer);


    }

}
