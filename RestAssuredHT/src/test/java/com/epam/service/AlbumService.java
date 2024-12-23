package com.epam.service;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import com.epam.pojos.AlbumRecord;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AlbumService {
	
	 public Response getAlbumResponseById(String basePath,String id){
	    	baseURI = "https://jsonplaceholder.typicode.com";
			RequestSpecification albumRequest = given();
	        return albumRequest.request(Method.GET,basePath.concat(id));
	    }
	    
	    public AlbumRecord getAlbumAsPOJO(String basePath,String id) {
	    	Response albumResponse = getAlbumResponseById(basePath, id);
	    	return albumResponse.as(AlbumRecord.class);
	    }
	    
	    public int getStatusCode(String basePath,String id){
	        Response albumResponse = getAlbumResponseById(basePath, id);
	        int statusCode = albumResponse.getStatusCode();
	        return statusCode;
	    }
	
	    
	    
	    
	    public Response deleteAlbumById(String basePath, String id) {
	    	baseURI = "https://jsonplaceholder.typicode.com";
			RequestSpecification albumRequest = given();
			return albumRequest.request(Method.DELETE,basePath.concat(id));
	    }
	    
	    public int getDeleteResponseCode(String basePath, String id) {
	    	Response deleteResponse = deleteAlbumById(basePath,id);
	    	return deleteResponse.getStatusCode();
	    }
	    
	    public String getDeleteBody(String basePath, String id) {
	    	Response deleteResponse = deleteAlbumById(basePath,id);
	    	return deleteResponse.asString();
	    }
	    
	    
	    
	    
	    public Response modifyAlbumById(String basePath, AlbumRecord modifiedAlbum) {
	    	baseURI = "https://jsonplaceholder.typicode.com";
			RequestSpecification albumRequest =	given();
			return albumRequest.contentType(ContentType.JSON).body(modifiedAlbum).request(Method.PUT,basePath);
	    }
	    
	    public int getModifyStatusCode(String basePath, AlbumRecord modifiedAlbum) {
	    	Response modifyResponse = modifyAlbumById(basePath, modifiedAlbum);
	    	return modifyResponse.getStatusCode();
	    }
	    
	    public AlbumRecord getModifyBodyAsPOJO(String basePath, AlbumRecord modifiedAlbum) {
	    	Response modifyResponse = modifyAlbumById(basePath,modifiedAlbum);
	    	return modifyResponse.as(AlbumRecord.class);
	    }
	    
	    
	    
	    
	    public Response createAlbum(String basePath,AlbumRecord newBody) {
	    	baseURI = "https://jsonplaceholder.typicode.com";
	    	RequestSpecification albumRequest = given();
	    	return albumRequest.contentType(ContentType.JSON).body(newBody).request(Method.POST,basePath);
	    }
	    
	    public int getCreateStatusCode(String basePath, AlbumRecord newBody) {
	    	Response createResponse = createAlbum(basePath,newBody);
	    	return createResponse.getStatusCode();
	    }
	    
	    public AlbumRecord getCreateResponseBody(String basePath, AlbumRecord newBody) {
	    	Response createResponse = createAlbum(basePath,newBody);
	    	return createResponse.as(AlbumRecord.class);
	    }
	    
	    
	    
	    
	    
	    
	    
	    
}