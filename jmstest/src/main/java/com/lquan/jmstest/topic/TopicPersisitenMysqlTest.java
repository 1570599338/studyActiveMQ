package com.lquan.jmstest.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 持久化mq的消息
 * @author lquan
 *
 */
public class TopicPersisitenMysqlTest {

	public static void main(String[] args) throws Exception {
		// 创建工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://112.125.90.15:61616");
		// 创建连接
		Connection connection=connectionFactory.createConnection();
		// 开启连接
		connection.start();
		// 创建会话session
		/**
		 * createSession 
		 * 参数1:是否开启事务
		 * 参数2:签收模式,一般我们使用自动签收模式
		 */
		Session session=connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		// 创建主题
		Topic topic=session.createTopic("lquanTic");
		// 创建一个发布者
		MessageProducer producer = session.createProducer(topic);
		// 持久化消息
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		// 创建一条消息
		TextMessage message = session.createTextMessage("订阅消息");
		// 发送消息
		//producer.send(message,DeliveryMode.PERSISTENT,1,1000*60*60*24);
		producer.send(message);
		
		producer.close();
		session.close();
		connection.close();
	}

}
