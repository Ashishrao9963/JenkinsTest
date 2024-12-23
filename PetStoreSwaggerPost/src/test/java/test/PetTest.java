package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import service.PetService;

public class PetTest {
	
	PetService petService;
	
	@BeforeTest
	public void setPetService() {
		petService = new PetService();
	}
	
	@Test
	public void verifyPetBody() {
		Assert.assertEquals(petService.getPetBody(),petService.checkData());
	}
	
	@Test
	public void verifyStatusCode() {
		Assert.assertEquals(petService.getStatusCode(), 200);
	}
	
	@Test
	public void verifyPetName() {
		petService.getPet().then().body("name", equalTo("doggie"));
	}
	
	@Test
	public void verifyPetStatus() {
		petService.getPet().then().body("status", equalTo("available"));
	}
	
	@Test
	public void verifyContentType() {
		Assert.assertEquals(petService.getPet().contentType(),"application/json");
	}
	
	@Test
	public void verifyPetIsADog() {
		petService.getPet().then().body("category.name",equalTo("string"));
	}
	
}