package com.epm.jdbc.learning.jdbc_learning;

public class Constants {
	
//	4. Write a query that displays last 10 rows from table country in ascending order.
	public static final String LAST_10_ROWS = "select * from (select * from country order by Code Desc Limit 10)Var1 order by Code ASC";
	
//	5. Write a query that displays highest population (with city name) from city table.
	public static final String HIGHEST_POPULATION = "select city.Name as CityName,city.Population as highestPopulation from world.city order by city.Population desc limit 1;";
	
//	6. Write a query to display all the rows from country table where name contains "Island"
//	and LifeExpectancy is greater than 70.
	public static final String LIFE_EXPECTANCY = "Select * from world.country where Name LIKE '%Island%' AND LifeExpectancy>70;";
	
//	7. Write a query to display No of Countries speaking each of the languages from countrylanguage table.
	public static final String NO_OF_COUNTRIES = "select Language, COUNT(*) as NumberOfCountries from countrylanguage group by Language;";
	
//	8. Display total number of countries which got independence after year 1971.
	public static final String INDEPENDENCE_AFTER_1971 = "Select count(*) as NoOfCountries from country where IndepYear>1971;";
	
//	9. Write a query to display City Name, Population, Country Name and Head of State 
//	from Country and City tables - apply Inner Join.
	public static final String NAME_POP_COUNTRY = "select city.Name as CityName,city.Population,country.Name as CountryName,country.HeadOfState from city inner join country on city.CountryCode=country.Code;";
	
//	10. Write a query to display total number of cities and their corresponding head 
//	of states from Country and City Tables - apply Inner Join.
	public static final String CITY_HEAD_OF_STATES = "Select count(*) as NoOfCities,country.HeadOfState from city Inner join country on city.CountryCode=country.Code group by country.HeadOfState;";
	
	
	public static final String CREATE_VIEW = "CREATE VIEW City_Country_Language AS"
			+ "	SELECT city.Name as CityName,country.Name as CountryName,country.Continent,country.HeadOfState,countrylanguage.Language"
			+ "	FROM"
			+ "	city INNER JOIN country ON city.CountryCode = country.Code"
			+ " INNER JOIN countrylanguage ON city.CountryCode = countrylanguage.CountryCode;";
	
//	12. Modify previously created view and add GovernmentForm as well from Country Table to the view.
	public static final String MODIFY_VIEW = "CREATE OR REPLACE VIEW City_Country_Language AS"
			+ "	SELECT city.Name as CityName,country.Name as CountryName,country.Continent,country.HeadOfState,countrylanguage.Language,country.GovernmentForm"
			+ "	FROM"
			+ "	city INNER JOIN country ON city.CountryCode = country.Code"
			+ " INNER JOIN countrylanguage ON city.CountryCode = countrylanguage.CountryCode;"; 
	
	
}