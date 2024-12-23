package test;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.OpenWeatherDataProvider;

public class OpenWeatherHydTest {
	
//	OpenWeatherHydService openWeather;
//	
//	@BeforeTest
//	public void setServiceObject() {
//		openWeather = new OpenWeatherHydService();
//	}
	
//	@Test
//	public void getCurrentCoordinates() {
//		openWeather.getResponseFromCoordinates().get("name").equals("Hyderabad");
//	}
	
	
	@Test(dataProviderClass = OpenWeatherDataProvider.class,dataProvider="coordinates")
	public void verifyName(String lat,String lon) {
		given()
		.when()
		.get("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=4c168b5edcc4dcc3c2045bda679a54c9")
		.jsonPath()
		.get("name")
		.equals("Hyderabad");
	}
	

	@Test(dataProviderClass = OpenWeatherDataProvider.class,dataProvider="coordinates")
	public void verifyCountry(String lat,String lon) {
		given()
		.when()
		.get("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=4c168b5edcc4dcc3c2045bda679a54c9")
		.jsonPath()
		.get("sys.country")
		.equals("IN");
	}
	

	@Test(dataProviderClass = OpenWeatherDataProvider.class,dataProvider="coordinates")
	public void verifyMinMainTemp(String lat,String lon) {
		float minMainTemp = given()
		.when()
		.get("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=4c168b5edcc4dcc3c2045bda679a54c9")
		.jsonPath()
		.get("main.temp_min");
		Assert.assertTrue(minMainTemp>0);
	}
	
	@Test(dataProviderClass = OpenWeatherDataProvider.class,dataProvider="coordinates")
	public void verifyMainTemp(String lat,String lon) {
		float mainTemp = given()
		.when()
		.get("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=4c168b5edcc4dcc3c2045bda679a54c9")
		.jsonPath()
		.get("main.temp");
		Assert.assertTrue(mainTemp>0);
	}
	
}