package com.epam.data;

import org.testng.annotations.DataProvider;

import com.epam.pojos.AlbumRecord;

public class AlbumDataProvider {
	
	@DataProvider(name = "verifyGetStatusCode")
	public Object[][] verifyGetStatusCodeData(){
		return new Object[][] {
			{"1"},
			{"2"},
			{"3"}
		};
	}
	
	@DataProvider(name = "verifyGetAlbumBodyData")
	public Object[][] verifiesPostBodyData(){
		return new Object[][] {
			{"1",new AlbumRecord("1","1","quidem molestiae enim")}
		};
	}
	
}