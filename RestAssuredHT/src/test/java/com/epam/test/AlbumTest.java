package com.epam.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.data.AlbumDataProvider;
import com.epam.pojos.AlbumRecord;
import com.epam.service.AlbumService;

public class AlbumTest {
	
	AlbumService albumService;
    
    @BeforeTest
    public void setPost() {
    	albumService = new AlbumService();
    }
    
    
    
    @Test(dataProviderClass=AlbumDataProvider.class,dataProvider="verifyGetAlbumBodyData")
    public void verifyGetAlbumBody(String id, AlbumRecord albumObject) {
    	Assert.assertEquals(albumService.getAlbumAsPOJO("/albums/",id), albumObject);
    }
    
    @Test(dataProviderClass = AlbumDataProvider.class, dataProvider = "verifyGetStatusCode")
    public void verifyGetStatusCode(String id) {
    	Assert.assertEquals(albumService.getStatusCode("/albums/", id), 200);
    }
    
    
    
    @Test
    public void verifyDeleteBody() {
    	Assert.assertEquals(albumService.getDeleteBody("/albums/","1"),"{}");
    }
    
    @Test
    public void verifyDeleteStatusCode() {
    	Assert.assertEquals(albumService.getDeleteResponseCode("/albums/","1"), 200);
    }
    
    
    
    @Test(dataProviderClass = AlbumDataProvider.class,dataProvider = "verifyModifyBody")
    public void verifyModifyBody(String id,AlbumRecord modifiedBody, AlbumRecord expectedBody) {
    	System.out.println(modifiedBody);
    	Assert.assertEquals(albumService.getModifyBodyAsPOJO("/albums/".concat(id), modifiedBody), expectedBody);
    }
    
    @Test(dataProviderClass=AlbumDataProvider.class,dataProvider="verifyModifyStatusCode")
    public void verifyModifyStatusCode(String id,AlbumRecord modifiedBody) {
    	Assert.assertEquals(albumService.getModifyStatusCode("/albums/".concat(id),modifiedBody), 200);
    }
    
    
    
    @Test(dataProviderClass=AlbumDataProvider.class,dataProvider="verifyCreateStatusCode")
    public void verifyCreationStatusCode(AlbumRecord newBody) {
    	Assert.assertEquals(albumService.getCreateStatusCode("/albums",newBody),201);
    }
    
    @Test(dataProviderClass=AlbumDataProvider.class,dataProvider="verifyCreationBody")
    public void verifyCreationBody(AlbumRecord newBody,AlbumRecord expectedBody) {
    	Assert.assertEquals(albumService.getCreateResponseBody("/albums",newBody), expectedBody);
    }
    
    @AfterTest
    public void destroyPostService() {
        albumService = null;
    }
    
}