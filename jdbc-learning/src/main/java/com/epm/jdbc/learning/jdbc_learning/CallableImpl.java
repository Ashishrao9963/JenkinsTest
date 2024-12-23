package com.epm.jdbc.learning.jdbc_learning;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableImpl {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila","root","Aa8885999913!!");
		CallableStatement callableStatement = connection.prepareCall("{CALL film_in_stock(?,?,?)}");
		callableStatement.setInt(1, 1);
		callableStatement.setInt(2, 1);
		callableStatement.setInt(3, 1);
		callableStatement.execute();
		System.out.println(callableStatement.getInt(3));
		
	}
	
}