package com.lquan.jmstest.queue.demo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息队列的接受
 * @author lquan
 *
 */
public class QueueReceiver {

	public static void main(String[] args) throws Exception {

		// 拿到连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://112.125.90.15:61616");
		// 通过连接工厂创建一个连接
		Connection connection =connectionFactory.createConnection();
		// 开启连接
		connection.start();
		// 创建一个session会话 
		Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
		// 创建一个发送消息的目的地
		Destination destination = session.createQueue("my-queue");
		// 创建一个消息发送者
		MessageConsumer consumer =session.createConsumer(destination);
		TextMessage message=null;
		for(int i=0;i<3;i++) {
			 message = (TextMessage) consumer.receive();
			System.out.println(i+"收到消息:"+message.getText()+"|*****|"+message.getStringProperty("name"));
		}
		message.acknowledge();
		// 关闭会话
		session.close();
		// 关闭连接
		connection.close();
		
	


	}

}
