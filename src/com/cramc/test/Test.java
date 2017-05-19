package com.cramc.test;

import com.cramc.amq.AMQManager;
import com.cramc.amq.AbsListenerImpl;
import com.cramc.amq.common.MessageType;
import com.cramc.amq.exception.AMQFactoryException;
import com.cramc.amq.exception.AMQReceiverException;
import com.cramc.amq.exception.AMQSendException;
import com.cramc.util.DESUtil;

/**
 * 测试类
 * @author chenwj
 *
 */
public class Test{

	public static void main(String[] args) {
		
//		try {
//			AMQManager manager =  AMQManager.getInstance();
//			manager.init(false);
//			//发送消息
//			manager.sendTextMsg("Hello World!", "FirstQueue", MessageType.Queue);
//			AbsListenerImpl absListenerImpl = new AbsListenerImpl();
//			//监听消息
//			manager.setListener("FirstQueue", absListenerImpl.getClass(), MessageType.Queue);
//		} catch (AMQFactoryException | AMQSendException | AMQReceiverException e) {
//			e.printStackTrace();
//		}
		
		
		
	}
	

}
