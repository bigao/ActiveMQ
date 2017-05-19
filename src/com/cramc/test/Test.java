package com.cramc.test;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

import com.cramc.amq.common.MessageType;
import com.cramc.amq.exception.AMQFactoryException;
import com.cramc.amq.factory.AMQFactory;


public class Test{

	public static void main(String[] args) {
		
		try {
			AMQFactory amqFactory = new AMQFactory();
			MessageProducer producer =  amqFactory.getProducer("FirstQueue", MessageType.Queue);
			TextMessage testMessage = amqFactory.getTextMessage("999");
					System.out.println("消息生成者发送消息：" + testMessage.getText());
			producer.send(testMessage);
			
			MessageConsumer consumer = amqFactory.getConsumer("FirstQueue", MessageType.Queue) ;
			consumer.setMessageListener(new MessageListener() {
				
				@Override
				public void onMessage(Message message) {
					
					String messageText = null; 
					if (message instanceof TextMessage) {  
		                TextMessage textMessage = (TextMessage) message;  
		                try {
		                	//打印收到的信息
							messageText = textMessage.getText();
							System.out.println("从客户端收到的消息 " + messageText);  
							
		                } catch (JMSException e) {
							e.printStackTrace();
						}  
		            }  
					
				}
			});
			
		} catch (AMQFactoryException e) {
			e.printStackTrace();
		} catch(JMSException e){
			e.printStackTrace();
		}
		
	}
	

}
