package com.cramc.amq;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
/**
 * 消息转换处理监听类
 * 目前只支持处理Map消息和Text消息，如果需要其他类型的消息可在此基础上进行扩展
 * @author chenwj
 */
public abstract class AbsListener implements MessageListener
{
	private Logger log = Logger.getLogger(AbsListener.class);
	public abstract void dealWithMsgMapValue(Map<String, Object> dicMap);  //Map消息处理方法
    public abstract void dealWithMsgTextValue(String text);                //Text消息处理方法
    @Override
    @SuppressWarnings("unchecked")
	public void onMessage(Message message){
    	 try {
 	        if (message instanceof MapMessage){
 	        	 MapMessage mapMsg = (MapMessage) message;
 	            Map<String, Object> dicMap = new HashMap<String, Object>();
 	            
 					for (Enumeration<String> em = mapMsg.getMapNames();em.hasMoreElements();)
 					{
 						String key = em.nextElement();
 					    dicMap.put(key, mapMsg.getObject(key));
 					}
 	            //Map消息监听接口
 	            this.dealWithMsgMapValue(dicMap);
 	            return;
 	        }else if (message instanceof TextMessage){
 	        	TextMessage textMsg = (TextMessage) message;
 	            String text;
 					text = textMsg.getText();
 	            //Text消息监听接口
 	            this.dealWithMsgTextValue(text);
 	            return;
 	        }
         }catch (JMSException e) {
        	 log.error("解析消息出错", e.getCause());
 		}
	}
}