package com.lquan.mq.send.config;

//import com.lquan.common.QueueUtils;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

/**
 * ClassName SenderConf
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
//@Configuration
public class SenderConf {

    private String mqRabbitHost="192.168.1.112";
    private Integer mqRabbitPort=5672;
    private String mqRabbitUserName="lquan";
    private String mqRabbitPassword="lquan";
    private String mqRabbitVirtualHost="/test";




//    // 创建连接
//    @Bean
//    public ConnectionFactory connectionFactory(){
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(this.mqRabbitHost,this.mqRabbitPort);
//        connectionFactory.setUsername(this.mqRabbitUserName);
//        connectionFactory.setPassword(this.mqRabbitPassword);
//        connectionFactory.setVirtualHost(this.mqRabbitVirtualHost);
//        // 是否自动确认
//        connectionFactory.setPublisherConfirms(false);
//
//        return connectionFactory;
//    }
//
//    /**
//     * RabbitTemplate ,用来发送消息
//     * @return
//     */
//    @Bean
//    public RabbitTemplate rabbitTemplate(){
//        RabbitTemplate template = new RabbitTemplate(connectionFactory());
//        return template;
//
//    }
//
//
//
//    @Bean
//    public Queue queue(){
//        return new Queue(QueueUtils.queue_a);
//    }
}
