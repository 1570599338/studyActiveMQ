package com.lquan.jmstest.queue;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息队列的接受
 * @author lquan
 *
 */
public class QueueReceiverMapMessage {

	public static void main(String[] args) throws Exception {

		// 拿到连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://112.125.90.15:61616");
		// 通过连接工厂创建一个连接
		Connection connection =connectionFactory.createConnection();
		// 开启连接
		connection.start();
		
		Enumeration names=connection.getMetaData().getJMSXPropertyNames();
		while(names.hasMoreElements()) {
			String name=(String) names.nextElement();
			System.out.println("jms name==="+name);
		}
		
		
		// 创建一个session会话
		Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		// 创建一个发送消息的目的地
		Destination destination = session.createQueue("my-queue");
		// 创建一个消息发送者
		MessageConsumer consumer =session.createConsumer(destination);
		for(int i=0;i<3;i++) {
			MapMessage message =  (MapMessage) consumer.receive();
			session.commit();
			System.out.println("收到消息:"+message.getString("key"+i)+"|*****|"+message.getStringProperty("name"));
		}
		
		// 关闭会话
		session.close();
		// 关闭连接
		connection.close();
		
	


	}

}
