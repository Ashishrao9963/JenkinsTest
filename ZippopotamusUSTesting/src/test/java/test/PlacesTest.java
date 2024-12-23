package test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import dataprovider.PlacesDataProvider;
import io.restassured.path.json.JsonPath;
import pojo.Places;
import pojo.USPojo;
import service.PlacesService;

public class PlacesTest {
	
	PlacesService placesService;
	
	@BeforeTest
	public void setServiceObj() {
		placesService = new PlacesService();
	}
	
	@Test(dataProviderClass = PlacesDataProvider.class, dataProvider = "placePostCodes")
	public void verifyGetPlaceStatusCode(String postCode) {
		Assert.assertEquals(placesService.getPlaceStatusCode(postCode),200);
	}
	
	@Test(dataProviderClass = PlacesDataProvider.class, dataProvider = "placePostCodes")
	public void verifyNonNullResponse(String postCode) {
		assertThat(placesService.getPlaceBody(postCode),notNullValue());
	}
	
	@Test(dataProviderClass = PlacesDataProvider.class, dataProvider = "placePostCodes")
	public void verifyNonNegativePostCode(String postCode) {
		assertThat(Integer.parseInt(placesService.getPlaceResponsePostCode(postCode)),greaterThan(0));
	}
	
	
	
	
	
	
	
	@Test(dataProviderClass = PlacesDataProvider.class, dataProvider = "placePostCodes")
	public void verifyPostCode(String postCode) {
		assertThat(placesService.getPlaceResponsePostCode(postCode),equalTo(postCode));
	}
	
	
	
	
	
	
	@Test
	public void verifyResponseBody() {
		var expectedPlace = new USPojo("33162","United States","US", new ArrayList<>(List.of(new Places("Miami","-80.183","Florida","FL","25.9286"))));
		Assert.assertEquals(placesService.getPlaceResponseBody("33162"),expectedPlace);
	}
	
	
	
	
	@Test(dataProviderClass = PlacesDataProvider.class, dataProvider = "placesResponseBody")
	public void verifyGetPlaceResponseBody(String postCode, USPojo expectedPlace) {
		Assert.assertEquals(placesService.getPlaceResponseBody(postCode),expectedPlace);
	}
	
	@Test(dataProviderClass = PlacesDataProvider.class,dataProvider = "placesResponseBodyAsJson")
	public void verifyGetPlaceAsJsonPath(String postCode,JsonPath expectedJson) {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(placesService.getPlaceResponseBodyPostCode(postCode),expectedJson.get("'post code'"),"Post code assertion failed");
		softAssert.assertEquals(placesService.getPlaceResponseBodyCountry(postCode),expectedJson.get("'country'"),"Country assertion failed");
		softAssert.assertEquals(placesService.getPlaceResponseBodyCountryAbbr(postCode), expectedJson.get("'country abbreviation'"),"Country abbreviation assertion failed");
		softAssert.assertEquals(placesService.getPlaceResponseBodyPlaces(postCode),expectedJson.get("'places'"),"Places assertion failed");
		softAssert.assertAll();
	}	
}