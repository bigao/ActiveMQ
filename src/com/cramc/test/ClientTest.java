package com.cramc.test;

import com.cramc.amq.AMQManager;
import com.cramc.amq.AbsListenerImpl;
import com.cramc.amq.common.MessageType;
import com.cramc.amq.common.QueueName;
import com.cramc.amq.exception.AMQFactoryException;
import com.cramc.amq.exception.AMQReceiverException;
import com.cramc.amq.exception.AMQSendException;

/**
 * 测试类（模拟消息生产者）
 * @author chenwj
 *
 */
public class ClientTest{

	public static void main(String[] args) {
		
		try {
			AMQManager manager =  AMQManager.getInstance();
			manager.init(false);
			//向消息消费者发送消息
			manager.sendTextMsg("Hello World!", QueueName.PUSH_QUEUE_NAME, MessageType.Queue);
			//监听消息消费者返回的确认信息
			manager.setListener(QueueName.REPORT_QUEUE_NAME, new AbsListenerImpl().getClass(), MessageType.Queue);
			
		} catch (AMQFactoryException | AMQSendException | AMQReceiverException e) {
			e.printStackTrace();
		}
		
		
		
	}
	

}
