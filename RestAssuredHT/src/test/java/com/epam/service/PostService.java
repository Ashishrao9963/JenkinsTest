package com.epam.service;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.List;

import com.epam.pojos.PostRecord;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostService{
	
    public Response getPostsResponseById(String basePath,String id){
    	baseURI = "https://jsonplaceholder.typicode.com";
		RequestSpecification postsRequest = given();
        return postsRequest.request(Method.GET,basePath.concat(id));
    }
    
    public PostRecord getPostsAsPOJO(String basePath,String id) {
    	Response postsResponse = getPostsResponseById(basePath, id);
    	return postsResponse.as(PostRecord.class);
    }
    
    public int getStatusCode(String basePath,String id){
        Response postsResponse = getPostsResponseById(basePath, id);
        int statusCode = postsResponse.getStatusCode();
        return statusCode;
    }
    
    
    
    
    public Response deletePostById(String basePath, String id) {
    	baseURI = "https://jsonplaceholder.typicode.com";
		RequestSpecification postsRequest = given();
		return postsRequest.request(Method.DELETE,basePath.concat(id));
    }
    
    public int getDeleteResponseCode(String basePath, String id) {
    	Response deleteResponse = deletePostById(basePath,id);
    	return deleteResponse.getStatusCode();
    }
    
    public String getDeleteBody(String basePath, String id) {
    	Response deleteResponse = deletePostById(basePath,id);
    	return deleteResponse.asString();
    }
    
    
    
    
    
    
//  Modify a specific resource data
    public Response modifyPostById(String basePath, PostRecord modifiedPojo) {
    	baseURI = "https://jsonplaceholder.typicode.com";
		RequestSpecification postsRequest =	given();
		return postsRequest.contentType(ContentType.JSON).body(modifiedPojo).request(Method.PUT,basePath);
    }
    
    public int getModifyStatusCode(String basePath, PostRecord modifiedPojo) {
    	Response modifyResponse = modifyPostById(basePath, modifiedPojo);
    	return modifyResponse.getStatusCode();
    }
    
    public PostRecord getModifyBodyAsPOJO(String basePath, PostRecord modifiedPojo) {
    	Response modifyResponse = modifyPostById(basePath,modifiedPojo);
    	modifyResponse.jsonPath().prettyPrint();
    	return modifyResponse.as(PostRecord.class);
    }
    
    
    
    
    public Response createPost(String basePath,PostRecord newPojo) {
    	baseURI = "https://jsonplaceholder.typicode.com";
    	RequestSpecification postsRequest = given().log().body();
    	return postsRequest.contentType(ContentType.JSON).body(newPojo).request(Method.POST,basePath);
    }
    
    public int getCreateStatusCode(String basePath, PostRecord newPojo) {
    	Response createResponse = createPost(basePath,newPojo);
    	return createResponse.getStatusCode();
    }
    
    public PostRecord getCreateResponseBody(String basePath, PostRecord newPojo) {
    	Response createResponse = createPost(basePath,newPojo);
    	return createResponse.as(PostRecord.class);
    }
    
    
    public void getPostInRange() {
    	baseURI = "https://jsonplaceholder.typicode.com/posts";
    	Response postsRequest = given().request(Method.GET);
    	
    	
    	List<List<String>> employeeDetails = postsRequest.jsonPath().getList("findAll { it.id <= 10 }");
    	System.out.println(employeeDetails);
    }
    
    
    public void getIdOfPostsInRange() {
    	baseURI = "https://jsonplaceholder.typicode.com/posts";
    	Response postsRequest = given().request(Method.GET);
    	
    	
    	List<List<String>> employeeDetails = postsRequest.path("findAll { it.id <= 10 }.id");
    	System.out.println(employeeDetails);
    }
    
    
    public void getIdOfPosts() {
    	baseURI = "https://jsonplaceholder.typicode.com/posts";
    	Response postsRequest = given().request(Method.GET);
    	
    	List<String> employeeDetails = postsRequest.path("id");
//    			.jsonPath().getList("id");
    	
    	System.out.println(employeeDetails);
    }
    
    
    
    
    
    
}