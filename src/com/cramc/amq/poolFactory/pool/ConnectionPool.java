package com.cramc.amq.poolFactory.pool;


import javax.jms.Connection;
/**
 * Connection池对象
 * @author chenwj
 */
public class ConnectionPool {

	private Connection connection;
	private int activeSessions;

	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public int getActiveSessions() {
		return activeSessions;
	}
	public void setActiveSessions(int activeSessions) {
		this.activeSessions = activeSessions;
	}
	
	
	
}
