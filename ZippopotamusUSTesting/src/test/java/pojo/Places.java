package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Places(@JsonProperty("place name") String placeName, String longitude, String state,@JsonProperty("state abbreviation") String stateAbbreviation, String latitude) {

	@Override
	public String toString() {
		return "{"+"place name:" + placeName + ", longitude:" + longitude + ", state:" + state
				+ ", state abbreviation:" + stateAbbreviation + ", latitude:" + latitude + "}";
	}
	
	
	
	
}

//"place name": "Miami",
//"longitude": "",
//"state": "",
//"state abbreviation": "",
//"latitude": ""