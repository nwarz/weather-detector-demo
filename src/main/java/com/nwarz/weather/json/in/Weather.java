package com.nwarz.weather.json.in;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

	private String main;
	
	public Weather() {
	}
	
	public String getMain() {
		return main;
	}
	
	public void setMain(String main) {
		this.main = main;
	}
}
