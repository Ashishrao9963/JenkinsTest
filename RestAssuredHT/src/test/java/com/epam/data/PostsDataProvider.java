package com.epam.data;

import org.testng.annotations.DataProvider;

import com.epam.pojos.PostRecord;

public class PostsDataProvider {
	
	@DataProvider(name="postsIdDataProvider")
    public Object[][] postsIdData(){
        return new Object[][]{
                {"1","1"},
                {"2","2"}
        };
    }
	
	@DataProvider(name = "verifyGetStatusCode")
	public Object[][] verifyGetStatusCodeData(){
		return new Object[][] {
			{"1"},
			{"2"},
			{"3"}
		};
	}
	
	@DataProvider(name = "verifyGetPostBodyData")
	public Object[][] verifiesPostBodyData(){
		return new Object[][] {
			{"1",new PostRecord("1","1","sunt aut facere repellat provident occaecati excepturi optio reprehenderit","quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto")}
		};
	}
	
	
	
	@DataProvider(name="verifyModifyBody")
	public Object[][] verifiesModifyBody(){
		return new Object[][] {
			
			{"4",new PostRecord("1","4","eum et est occaecati","ullam et saepe voluptatem rerum illo velit"),new PostRecord("1","4","eum et est occaecati","ullam et saepe voluptatem rerum illo velit")}
		};
	}
	
	@DataProvider(name="verifyModifyStatusCode")
	public Object[][] verifiesModifyStatusCode(){
		return new Object[][] {
			{"4",new PostRecord("1","4","eum et est occaecati","ullam et saepe voluptatem rerum illo velit")}
		};
	}
	
	
	@DataProvider(name="verifyCreateStatusCode")
	public Object[][] verifyCreateStatusCode(){
		return new Object[][] {
			{new PostRecord("1","4","Shivanath","New body")}
		};
	}
	
	@DataProvider(name="verifyCreationBody")
	public Object[][] verifyCreationBody(){
		return new Object[][] {
			{new PostRecord("1","104","Shivanath","New body"),new PostRecord("1","101","Shivanath","New body")}
		};
	}
	
	
	
	
	
	
	
}