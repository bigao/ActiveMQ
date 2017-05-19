package com.cramc.test;

import com.cramc.amq.AMQManager;
import com.cramc.amq.AbsListenerImpl;
import com.cramc.amq.common.MessageType;
import com.cramc.amq.common.QueueName;
import com.cramc.amq.exception.AMQFactoryException;
import com.cramc.amq.exception.AMQReceiverException;
import com.cramc.amq.exception.AMQSendException;

public class ServerTest {
	
	public static void main(String[] args) {
		
		try {
			AMQManager manager =  AMQManager.getInstance();
			manager.init(false);
			//监听消息生产者发送的消息
			manager.setListener(QueueName.PUSH_QUEUE_NAME, new AbsListenerImpl().getClass(), MessageType.Queue);

			//向消息生产者反馈消息
			manager.sendTextMsg("消息消费者已经收到消息！", QueueName.REPORT_QUEUE_NAME, MessageType.Queue);
			
		} catch (AMQFactoryException | AMQSendException | AMQReceiverException e) {
			e.printStackTrace();
		}
		
	}

}
