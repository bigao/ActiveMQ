package com.cramc.amq.exception;
/**
 * AMQ工厂自定义异常类
 * @author chenwj
 * 
 */
public class AMQFactoryException extends Exception{
	private static final long serialVersionUID = 1L;

	public AMQFactoryException(String message){
		super(message);
	}
	
	public AMQFactoryException(String message,Exception e){
		super(message,e);
	}
	
}
