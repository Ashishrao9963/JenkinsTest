package com.epam.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.data.CommentDataProvider;
import com.epam.pojos.CommentRecord;
import com.epam.service.CommentService;

public class CommentsTest {
	
	CommentService commentService;
	
	@BeforeTest
	public void setService() {
		commentService = new CommentService();
	}
	
	
	
	
	@Test(dataProviderClass = CommentDataProvider.class, dataProvider = "verifyGetCommentBodyData")
	public void verifyGetCommentBody(String id, CommentRecord commentRecord) {
		Assert.assertEquals(commentService.getCommentsAsPOJO("/comments/",id),commentRecord);
	}
	
	@Test(dataProviderClass = CommentDataProvider.class, dataProvider = "verifyGetCommentStatusCode")
    public void verifyGetStatusCode(String id) {
    	Assert.assertEquals(commentService.getStatusCode("/comments/", id), 200);
    }
	
	
	
	@Test(dataProviderClass = CommentDataProvider.class,dataProvider = "deleteCommentDataProvider")
	public void verifyDeleteBody(String id) {
		Assert.assertEquals(commentService.getDeleteBody("/comments/", id), "{}");
	}

	@Test(dataProviderClass = CommentDataProvider.class,dataProvider = "deleteCommentDataProvider")
	public void verifyDeleteStatusCode(String id) {
		Assert.assertEquals(commentService.getDeleteResponseCode("/comments/", id), 200);
	}
	
	
	
	@Test(dataProviderClass = CommentDataProvider.class,dataProvider = "verifyModifyBody")
    public void verifyModifyBody(String id,CommentRecord modifiedComment, CommentRecord expectedComment) {
    	Assert.assertEquals(commentService.getModifyBodyAsPOJO("/comments/".concat(id), modifiedComment), expectedComment);
    }
    
    @Test(dataProviderClass=CommentDataProvider.class,dataProvider="verifyModifyStatusCode")
    public void verifyModifyStatusCode(String id,CommentRecord expectedComment) {
    	Assert.assertEquals(commentService.getModifyStatusCode("/comments/".concat(id),expectedComment), 200);
    }
	
	
	
    @Test(dataProviderClass=CommentDataProvider.class,dataProvider="verifyCreateStatusCode")
    public void verifyCreationStatusCode(CommentRecord newComment) {
    	Assert.assertEquals(commentService.getCreateStatusCode("/comments",newComment),201);
    }
    
    @Test(dataProviderClass=CommentDataProvider.class,dataProvider="verifyCreationBody")
    public void verifyCreationBody(CommentRecord newComment,CommentRecord expectedComment) {
    	Assert.assertEquals(commentService.getCreateResponseBody("/comments",newComment), expectedComment);
    }
	
	
	
	@AfterTest
	public void tearDown() {
		commentService = null;
	}
	
}