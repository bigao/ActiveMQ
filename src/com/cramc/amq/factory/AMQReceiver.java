package com.cramc.amq.factory;

import java.util.concurrent.locks.ReentrantLock;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;

import com.cramc.amq.AbsListener;
import com.cramc.amq.exception.AMQFactoryException;
import com.cramc.amq.exception.AMQReceiverException;
/**
 * AMQ接收消息管理类
 * @author chenwj
 * 
 */
public class AMQReceiver{
	 private ReentrantLock lock = new ReentrantLock();//互斥锁
	 
     //关联用户订阅消息与用户自定义业务监听类
     public boolean setListener(String topicName, AMQFactory factory, Class<?> className,String messageType) throws AMQReceiverException, AMQFactoryException
     {
         if (null == factory) {
             throw new AMQReceiverException("AMQFactory is null");
         }
         if (null == className) {
             throw new AMQReceiverException("user Listener must be not null");
         }
         if (null == topicName || "".equals(topicName)) {
             throw new AMQReceiverException("parameter topicName must be not null");
         }
         //进入写模式锁定状态，防止误监听
        lock.lock();
         //利用反射机制实例化用户自定义监听类
		try {
			MessageListener rece = (MessageListener) className.newInstance();
			MessageConsumer consumer = factory.getConsumer(topicName,messageType);
			consumer.setMessageListener(rece);
			 return true;
		} catch (InstantiationException e) {
			throw new AMQReceiverException("newInstance listener error!",e);
		} catch (IllegalAccessException e) {
			throw new AMQReceiverException("newInstance listener error!",e);
		} catch (JMSException e) {
			throw new AMQReceiverException("set listener error!",e);
		}finally{
			lock.unlock();
		}
     }   
     
   //关联用户订阅消息与用户自定义业务监听类
     public boolean setReceive(String topicName, AMQFactory factory, Class<?> className,String messageType) throws AMQReceiverException, AMQFactoryException
     {
         if (null == factory) {
             throw new AMQReceiverException("AMQFactory is null");
         }
         if (null == className) {
             throw new AMQReceiverException("user Listener must be not null");
         }
         if (null == topicName || "".equals(topicName)) {
             throw new AMQReceiverException("parameter topicName must be not null");
         }
         //进入写模式锁定状态，防止误监听
        lock.lock();
         //利用反射机制实例化用户自定义监听类
		try {
			AbsListener rece = (AbsListener)className.newInstance();
			MessageConsumer consumer = factory.getConsumer(topicName,messageType);
			consumer.setMessageListener(rece);
			return true;
		} catch (InstantiationException e) {
			throw new AMQReceiverException("newInstance listener error!",e);
		} catch (IllegalAccessException e) {
			throw new AMQReceiverException("newInstance listener error!",e);
		} catch (JMSException e) {
			throw new AMQReceiverException("set listener error!",e);
		}finally{
			lock.unlock();
		}
     }
}
