package service;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import io.restassured.http.Method;
import io.restassured.response.Response;

public class PetService {
	
	public Response getPet() {
		baseURI = "https://petstore.swagger.io/v2/pet/12";
		return given().request(Method.GET);
	}
	
	public String getPetBody() {
		return getPet().asString();
	}
	
	public String checkData() {
		String json = "{\"id\":12,\"category\":{\"id\":1,\"name\":\"string\"},"+
	            "\"name\":\"doggie\",\"photoUrls\":[\"string\"],\"tags\":["+
	            "{\"id\":1,\"name\":\"string\"}],\"status\":\"available\"}";
		return json;
	}
	
	public int getStatusCode() {
		return getPet().getStatusCode();
	}
	
	
	
}