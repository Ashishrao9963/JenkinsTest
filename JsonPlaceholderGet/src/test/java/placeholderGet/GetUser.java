package placeholderGet;

import static org.hamcrest.Matchers.hasItem;

import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import service.UserService;

public class GetUser {

	UserService userService;

	@BeforeClass
	public void setUserService() {
		userService = new UserService();
	}

	@Test
	public void verifyStatusCode() {
		Assert.assertEquals(userService.getStatusCode(),200);
	}

	@Test
	public void verifyNoOfUsersGreaterThanThree() {
		Assert.assertTrue(userService.noOfUsers()>3);
	}

	@Test
	public void verifyErvinHowellIsAUser() {
		MatcherAssert.assertThat(userService.verifyErvinHowellIsAUser(),hasItem("Ervin Howell"));
	}


}