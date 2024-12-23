package com.epm.jdbc.learning.jdbc_learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DbConnection {
	
	private static final Logger LOGGER = LogManager.getLogger(DbConnection.class);
	
	public static void main(String[] args) throws ClassNotFoundException,SQLException{

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila", "root", "Aa8885999913!!");
		
		try (PreparedStatement preparedStatement = connection
		.prepareStatement("Insert into employee_details (Emp_Id,Emp_Name,Emp_Designation,Emp_Location,Emp_Salary) values(?,?,?,?,?)")){
			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2, "ashish");
			preparedStatement.setString(3, "de");
			preparedStatement.setString(4, "fhr");
			preparedStatement.setDouble(5, 39000);
			int result = preparedStatement.executeUpdate();
			LOGGER.info(result);
		}
		try(PreparedStatement ps = connection.prepareStatement("Select * from employee_details")){
			ResultSet resultSet = ps.executeQuery("Select * from employee_details");
			while(resultSet.next()) {
				LOGGER.info(resultSet.getInt("Emp_Id"));
			}
			connection.close();
		}
	}
	
	
	
}