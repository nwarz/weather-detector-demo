package com.nwarz.weather.json.in;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
	
	private List<WeatherData> list;

	public Forecast() {
	}
	
	public void setList(List<WeatherData> list) {
		this.list = list;
	}
	
	public List<WeatherData> getList() {
		return list;
	}
}
