package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record USPojo(@JsonProperty("post code") String postCode, String country, @JsonProperty("country abbreviation") String countryAbbreviation,List<Places> places){}