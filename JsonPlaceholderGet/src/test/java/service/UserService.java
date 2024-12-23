package service;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserService {
	
	public Response getUser() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
		RequestSpecification requestSpecification = RestAssured.given();
		return requestSpecification.request(Method.GET);
	}
	
	public int getStatusCode() {
		return getUser().getStatusCode();
	}
	
	public int noOfUsers() {
		return getUser().as(ArrayList.class).size();
	}
	
	public List<String> verifyErvinHowellIsAUser() {
		return getUser().jsonPath().getList("name");
	}
	
	
}