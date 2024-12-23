package com.epam.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.data.PostsDataProvider;
import com.epam.pojos.PostRecord;
import com.epam.service.PostService;

public class PostsTest{
	
    PostService postService;
    
    @BeforeTest
    public void setPost() {
        postService = new PostService();
    }
    
    
    
    @Test(dataProviderClass=PostsDataProvider.class,dataProvider="verifyGetPostBodyData")
    public void verifyGetPostsBody(String id, PostRecord postObject) {
    	Assert.assertEquals(postService.getPostsAsPOJO("/posts/",id), postObject);
    }
    
    @Test(dataProviderClass = PostsDataProvider.class, dataProvider = "verifyGetStatusCode")
    public void verifyGetStatusCode(String id) {
    	Assert.assertEquals(postService.getStatusCode("/posts/", id), 200);
    }
    
    
    
    @Test
    public void verifyDeleteBody() {
    	Assert.assertEquals(postService.getDeleteBody("/posts/","1"),"{}");
    }
    
    @Test
    public void verifyDeleteStatusCode() {
    	Assert.assertEquals(postService.getDeleteResponseCode("/posts/","1"), 200);
    }
    
    
    
    @Test(dataProviderClass = PostsDataProvider.class,dataProvider = "verifyModifyBody")
    public void verifyModifyBody(String id,PostRecord modifiedPojo, PostRecord expectedPojo) {
    	System.out.println(modifiedPojo);
    	Assert.assertEquals(postService.getModifyBodyAsPOJO("/posts/".concat(id), modifiedPojo), expectedPojo);
    }
    
    @Test(dataProviderClass=PostsDataProvider.class,dataProvider="verifyModifyStatusCode")
    public void verifyModifyStatusCode(String id,PostRecord modifiedPojo) {
    	Assert.assertEquals(postService.getModifyStatusCode("/posts/".concat(id),modifiedPojo), 200);
    }
    
    
    
    @Test(dataProviderClass=PostsDataProvider.class,dataProvider="verifyCreateStatusCode")
    public void verifyCreationStatusCode(PostRecord newPojo) {
    	Assert.assertEquals(postService.getCreateStatusCode("/posts",newPojo),201);
    }
    
    @Test(dataProviderClass=PostsDataProvider.class,dataProvider="verifyCreationBody")
    public void verifyCreationBody(PostRecord newPojo,PostRecord expectedPojo) {
    	Assert.assertEquals(postService.getCreateResponseBody("/posts",newPojo), expectedPojo);
    }
    
    
    
    
    
    @Test
    public void verifyGetPostsByRange() {
    	postService.getPostInRange();
    }
    
    @Test
    public void verifyGetIdOfPosts() {
    	postService.getIdOfPosts();
    }
    
    @Test
    public void verifyGetIdOfPostsInRange() {
    	postService.getIdOfPostsInRange();
    }
    
    @AfterTest
    public void destroyPostService() {
        postService = null;
    }
    
}
