package service;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import pojo.USPojo;

public class PlacesService {
	
	public Response getPlaceResponse(String postCode) {
		baseURI = "https://api.zippopotam.us/us/";
		return given().request(Method.GET,postCode);
	}
	
	public int getPlaceStatusCode(String postCode) {
		return getPlaceResponse(postCode).getStatusCode();
	}
	
	public USPojo getPlaceResponseBody(String postCode) {
		return getPlaceResponse(postCode).as(USPojo.class);
	}
	
	
	
	public ResponseBody<?> getPlaceBody(String postCode) {
		return getPlaceResponse(postCode).body();
	}
	
	public String getPlaceResponsePostCode(String postCode) {
		return getPlaceBody(postCode).path("'post code'");
	}
	
	
	
	public Object getPlaceResponseBodyPostCode(String postCode) {
		return getPlaceResponse(postCode).body().path("'post code'");
	}
	
	public Object getPlaceResponseBodyCountry(String postCode) {
		return getPlaceResponse(postCode).body().path("'country'");
	}
	
	public Object getPlaceResponseBodyCountryAbbr(String postCode) {
		return getPlaceResponse(postCode).body().path("'country abbreviation'");
	}
	
	public Object getPlaceResponseBodyPlaces(String postCode) {
		return getPlaceResponse(postCode).body().path("'places'");
	}
	
	public Object getPlaceResponseBodyAsJsonPathTRIAL(String postCode) {
		JsonPath jsonPath = getPlaceResponse(postCode).jsonPath();
		return jsonPath.get();
	}
	
	
}