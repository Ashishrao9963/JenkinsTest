package com.epam.data;

import org.testng.annotations.DataProvider;

import com.epam.pojos.CommentRecord;

public class CommentDataProvider {
	
	@DataProvider(name = "verifyGetCommentBodyData")
	public Object[][] commentsById(){
		return new Object[][] {
			{"1",new CommentRecord("1","1","id labore ex et quam laborum","Eliseo@gardner.biz","laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium")}
		};
	}
	
	@DataProvider(name = "verifyGetCommentStatusCode")
	public Object[][] verifyGetStatusCodeData(){
		return new Object[][] {
			{"1"},
			{"2"},
			{"3"}
		};
	}
	
	
	
	@DataProvider(name = "deleteCommentDataProvider")
	public Object[][] verifyDeleteCommentData(){
		return new Object[][] {
			{"1"},
			{"2"},
			{"3"}
		};
	}
	
	
	
	@DataProvider(name="verifyModifyBody")
	public Object[][] verifiesModifyBody(){
		return new Object[][] {
			
			{"4",new CommentRecord("1","4","eum et est occaecati", "Eliseo@gardner.biz","ullam et saepe voluptatem rerum illo velit"),new CommentRecord("1","4","eum et est occaecati", "Eliseo@gardner.biz","ullam et saepe voluptatem rerum illo velit")}
		};
	}
	
	@DataProvider(name="verifyModifyStatusCode")
	public Object[][] verifiesModifyStatusCode(){
		return new Object[][] {
			{"4",new CommentRecord("1","4","eum et est occaecati", "Eliseo@gardner.biz","ullam et saepe voluptatem rerum illo velit")}
		};
	}
	
	
	
	
	
	@DataProvider(name="verifyCreateStatusCode")
	public Object[][] verifyCreateStatusCode(){
		return new Object[][] {
			{new CommentRecord("1","4","Shivanath", "Eliseo@gardner.biz","New body")}
		};
	}
	
	@DataProvider(name="verifyCreationBody")
	public Object[][] verifyCreationBody(){
		return new Object[][] {
			{new CommentRecord("1","104","Shivanath", "Eliseo@gardner.biz","New body"),new CommentRecord("1","501","Shivanath", "Eliseo@gardner.biz","New body")}
		};
	}
	
	
	
}