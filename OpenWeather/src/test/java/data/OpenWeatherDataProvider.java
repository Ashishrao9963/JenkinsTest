package data;

import org.testng.annotations.DataProvider;

public class OpenWeatherDataProvider {
	
	@DataProvider(name="coordinates")
	public Object[][] coordinates(){
		return new Object[][] {
			{"17.3753","78.4744"}
		};
	}
	
	
}