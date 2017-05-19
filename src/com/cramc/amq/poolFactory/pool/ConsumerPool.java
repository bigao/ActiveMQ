package com.cramc.amq.poolFactory.pool;

import javax.jms.Connection;
import javax.jms.MessageConsumer;
import javax.jms.Session;
/**
 * consumer池对象
 * 
 */
public class ConsumerPool {

	private Connection connection;
	private Session session;
	private MessageConsumer consumer;
	
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public MessageConsumer getConsumer() {
		return consumer;
	}
	public void setConsumer(MessageConsumer consumer) {
		this.consumer = consumer;
	}
	
	
}
