package com.epm.jdbc.learning.jdbc_learning;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WorldTask {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
//		 4. Write a query that displays last 10 rows from table country in ascending order.
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection = ConnectionSingleton.createConnection()){
			Statement statement = connection.createStatement();
//			last10Rows(statement);
//			highestPopulation(statement);
//			lifeExpectancy(statement);
//			noOfCountries(statement);
//			independentAfter1971(statement);
//			nameInnerJoin(statement);
//			cityInnerJoin(statement);
//			createView(statement);
			modifyView(statement);
			
		}
	}
	
	public static void last10Rows(Statement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery(Constants.LAST_10_ROWS);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6)+" "+resultSet.getString(7)+" "+resultSet.getString(8)+" "+resultSet.getString(9)+" "+resultSet.getString(10)+" "+resultSet.getString(11)+" "+resultSet.getString(12)+" "+resultSet.getString(13)+" "+resultSet.getString(14)+" "+resultSet.getString(15));
		}
		System.out.println();
	}
	
//	5. Write a query that displays highest population (with city name) from city table.
	public static void highestPopulation(Statement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery(Constants.HIGHEST_POPULATION);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
			System.out.println();
		}
	}
	
//	6. Write a query to display all the rows from country table where name contains 
//	"Island" and LifeExpectancy is greater than 70.
	
	public static void lifeExpectancy(Statement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery(Constants.LIFE_EXPECTANCY);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6)+" "+resultSet.getString(7)+" "+resultSet.getString(8)+" "+resultSet.getString(9)+" "+resultSet.getString(10)+" "+resultSet.getString(11)+" "+resultSet.getString(12)+" "+resultSet.getString(13)+" "+resultSet.getString(14)+" "+resultSet.getString(15));
		}
		
		System.out.println();
	}
	
//	7. Write a query to display No of Countries speaking each of the languages from countrylanguage table.
	public static void noOfCountries(Statement statement) throws SQLException{
		ResultSet resultSet = statement.executeQuery(Constants.NO_OF_COUNTRIES);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
		}
		System.out.println();
	}
	
//	8. Display total number of countries which got independence after year 1971.
	public static void independentAfter1971(Statement statement) throws SQLException{
		ResultSet resultSet = statement.executeQuery(Constants.INDEPENDENCE_AFTER_1971);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}
		System.out.println();
	}
	
//	9. Write a query to display City Name, Population, Country Name and Head of State 
//	from Country and City tables - apply Inner Join.
	public static void nameInnerJoin(Statement statement) throws SQLException{
		ResultSet resultSet = statement.executeQuery(Constants.NAME_POP_COUNTRY);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+"\t "+resultSet.getString(2)+"\t "+resultSet.getString(3)+"\t "+resultSet.getString(4));
		}
		System.out.println();
	}
	
//	10. Write a query to display total number of cities and their corresponding head 
//	of states from Country and City Tables - apply Inner Join.
	public static void cityInnerJoin(Statement statement) throws SQLException{
		ResultSet resultSet = statement.executeQuery(Constants.CITY_HEAD_OF_STATES);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+"\t "+resultSet.getString(2));
		}
		System.out.println();
	}
	
//	11. Create a view to display City Name, Country Name, Continent, HeadOfState and Language
//	from City, Country and Country Language tables.
	public static void createView(Statement statement) throws SQLException{
		statement.execute(Constants.CREATE_VIEW);
//		statement.execute("select * from City_Country_Language");
		System.out.println();
	}
	
//	12. Modify previously created view and add GovernmentForm as well
//	from Country Table to the view.
	public static void modifyView(Statement statement) throws SQLException{
		statement.execute(Constants.MODIFY_VIEW);
		System.out.println();
	}
	
	
	
	
}