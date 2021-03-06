package com.cramc.amq.poolFactory.pool;


import javax.jms.Connection;
import javax.jms.Session;
/**
 * session池对象
 * @author chenwj
 * 
 */
public class SessionPool {
	private Connection connection;
	private Session session;
	private int availableProducer;
	private int availableConsumer;
	
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
	public int getAvailableProducer() {
		return availableProducer;
	}
	public void setAvailableProducer(int availableProducer) {
		this.availableProducer = availableProducer;
	}
	public int getAvailableConsumer() {
		return availableConsumer;
	}
	public void setAvailableConsumer(int availableConsumer) {
		this.availableConsumer = availableConsumer;
	}
	
}
