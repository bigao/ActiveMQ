package com.cramc.amq.common;

/**
 * Jms规范里的两种message传输方式:Topic和Queue
 * @author chenwj
 *
 */
public class MessageType {

	/**
	 * topic类型用于发布订阅模式
	 */
	public static final String Topic = "Topic";
	/**
	 * queue类型用于点对点模式
	 */
	public static final String Queue = "Queue";
	
}
