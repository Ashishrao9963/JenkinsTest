package com.epam.service;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import com.epam.pojos.CommentRecord;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommentService {
	
	public Response getCommentsResponseById(String basePath,String id){
    	baseURI = "https://jsonplaceholder.typicode.com";
		RequestSpecification commentRequest = given();
        return commentRequest.request(Method.GET,basePath.concat(id));
    }
    
    public CommentRecord getCommentsAsPOJO(String basePath,String id) {
    	Response commentResponse = getCommentsResponseById(basePath, id);
    	return commentResponse.as(CommentRecord.class);
    }
    
    public int getStatusCode(String basePath,String id){
        Response commentResponse = getCommentsResponseById(basePath, id);
        int statusCode = commentResponse.getStatusCode();
        return statusCode;
    }
	
    
    
    
    public Response deleteCommentById(String basePath, String id) {
    	baseURI = "https://jsonplaceholder.typicode.com";
		RequestSpecification commentRequest = given();
		return commentRequest.request(Method.DELETE,basePath.concat(id));
    }
    
    public int getDeleteResponseCode(String basePath, String id) {
    	Response deleteResponse = deleteCommentById(basePath,id);
    	return deleteResponse.getStatusCode();
    }
    
    public String getDeleteBody(String basePath, String id) {
    	Response deleteResponse = deleteCommentById(basePath,id);
    	return deleteResponse.asString();
    }
    
    
    
    
    
    public Response modifyCommentById(String basePath, CommentRecord modifiedComment) {
    	baseURI = "https://jsonplaceholder.typicode.com";
		RequestSpecification commentRequest =	given();
		return commentRequest.contentType(ContentType.JSON).body(modifiedComment).request(Method.PUT,basePath);
    }
    
    public int getModifyStatusCode(String basePath, CommentRecord modifiedComment) {
    	Response modifyResponse = modifyCommentById(basePath, modifiedComment);
    	return modifyResponse.getStatusCode();
    }
    
    public CommentRecord getModifyBodyAsPOJO(String basePath, CommentRecord modifiedComment) {
    	Response modifyResponse = modifyCommentById(basePath,modifiedComment);
    	return modifyResponse.as(CommentRecord.class);
    }
    
    
    
    
    
    public Response createComment(String basePath,CommentRecord newComment) {
    	baseURI = "https://jsonplaceholder.typicode.com";
    	RequestSpecification postsRequest = given();
    	return postsRequest.contentType(ContentType.JSON).body(newComment).request(Method.POST,basePath);
    }
    
    public int getCreateStatusCode(String basePath, CommentRecord newComment) {
    	Response createResponse = createComment(basePath, newComment);
    	return createResponse.getStatusCode();
    }
    
    public CommentRecord getCreateResponseBody(String basePath, CommentRecord newComment) {
    	Response createResponse = createComment(basePath, newComment);
    	return createResponse.as(CommentRecord.class);
    }
    
    
	
}