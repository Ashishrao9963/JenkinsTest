package test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class CoopFeedTheChickens {
	
	@Test
	public void postFeedTheChicken() {
		given()
			.auth()
			.oauth2("6d33ef0ddeb81c817ae79e60a7b70389dd4fd9e3")
			.post("http://coop.apps.symfonycasts.com/api/4841/chickens-feed")
			.then()
			.statusCode(200);
	}
	
	@Test
	public void putToiletSeatDown() {
		given()
			.auth()
			.oauth2("c359a9de7b133e8bfbaba556fef061dc84cf67ae")
			.post("http://coop.apps.symfonycasts.com/api/4841/toiletseat-down")
			.then()
			.statusCode(200);
	}
	
	
	//Feed and count eggs
	@Test
	public void countNoOfEggs() {
		given()
			.auth()
			.oauth2("4a1c21bfde86336197f50ff3321b116285197a90")
			.post("http://coop.apps.symfonycasts.com/api/4841/eggs-count")
			.then()
			.statusCode(200);
	}
	
	
	
}
