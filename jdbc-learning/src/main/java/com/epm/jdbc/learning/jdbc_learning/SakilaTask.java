package com.epm.jdbc.learning.jdbc_learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SakilaTask {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila","root","Aa8885999913!!");
		
//		String sqlQuery = "alter table employee_details add column Emp_Department VARCHAR(30),add primary key(Emp_Id)";
//		execution(connection,sqlQuery);
//		3. Add multiple rows to employee_details table and check the constraints violations.
		
//		String addRows = "insert into employee_details (Emp_Id,Emp_Name,Emp_Designation,Emp_Location,Emp_Salary,Emp_Department) values (17,\"James\",\"clerk\",\"LA\",12000,\"Maintenance\")";
//		execution(connection,addRows);
		String addRow2 = "insert into employee_details (Emp_Id,Emp_Name,Emp_Designation,Emp_Location,Emp_Salary,Emp_Department) values (19,\"James\",\"clerk\",\"LA\",12000,\"Maintenance\")";
		execution(connection,addRow2);
	}
	
	public static void execution(Connection connection, String sqlQuery) throws SQLException {
//		
		try(Statement statement = connection.createStatement()){
			statement.executeUpdate(sqlQuery);
		}
	}
}