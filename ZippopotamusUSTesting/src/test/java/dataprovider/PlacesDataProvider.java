package dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import io.restassured.path.json.JsonPath;
import pojo.Places;
import pojo.USPojo;

public class PlacesDataProvider {
	
	
	@DataProvider(name = "placePostCodes")
	public Object[][] getPostCodes(){
		return new Object[][] {
			{"33162"},
			{"00213"}
		};
	}
	
	@DataProvider (name = "placesResponseBody")
	public Object[][] verifyPlacesResponseBody(){
		return new Object[][] {
			{"33162",new USPojo("33162","United States","US", new ArrayList<>(List.of(new Places("Miami","-80.183","Florida","FL","25.9286"))))},
			{"00213",new USPojo("00213","United States","US", new ArrayList<>(List.of(new Places("Portsmouth","-71.0132","New Hampshire","NH","43.0059"))))}
		};
	}
	
	
	@DataProvider(name = "placesResponseBodyAsJson")
	public Object[][] verifyUsingJsonPath(){
		return new Object[][] {
			{"33162",new JsonPath("{\"post code\": \"33162\", \"country\": \"United States\", \"country abbreviation\": \"US\", \"places\": [{\"place name\": \"Miami\", \"longitude\": \"-80.183\", \"state\": \"Florida\", \"state abbreviation\": \"FL\", \"latitude\": \"25.9286\"}]}")}
		};
	}
	
	
	
}