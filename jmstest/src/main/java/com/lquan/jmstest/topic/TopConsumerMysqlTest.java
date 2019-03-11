package com.lquan.jmstest.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息的消费者,接收方
 * @author lquan
 *
 */
public class TopConsumerMysqlTest {

	public static void main(String[] args) throws Exception {
		// 创建连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://112.125.90.15:61616");
		//2、创建连接
		Connection connection = connectionFactory.createConnection();
		
		//4、设置客户端的id
		//connection.setClientID("clientlquan-1");
		//3、启动连接
		connection.start();
		// 5、获取session
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		// 6、通过session创建主题
		Topic topic = session.createTopic("lquanTic");
		// 7、同过session对象创建持久化消息的消费者
		//TopicSubscriber consumer = session.createDurableSubscriber(topic, "client1-sub");
		MessageConsumer consumer = session.createConsumer(topic);
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				if(message instanceof TextMessage) {
					
					TextMessage textMessage = (TextMessage)message;
					try {
		                System.out.println("接收到消息："+textMessage.getText());
		            } catch (JMSException e) {
		                e.printStackTrace();
		            }
				}
				
			}
		});
		
		
		while (true){

        }

	}

}
