package com.epm.jdbc.learning.jdbc_learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

	
	private ConnectionSingleton() {
		
	}
	private static Connection connection;
	
	public static Connection createConnection() throws SQLException {
		if(connection==null || connection.isClosed()) {
			return getConnection();
		}
		return connection;
	}
	
	private static Connection getConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/world","root","Aa8885999913!!");
		return connection;
	}
}