package com.cramc.amq.exception;
/**
 * AMQ消息接受自定义异常类
 * @author chenwj
 * 
 */
public class AMQReceiverException extends Exception{
	private static final long serialVersionUID = 1L;
	public AMQReceiverException(String message){
		super(message);
	}
	public AMQReceiverException(String message,Exception e){
		super(message,e);
	}
}
