package com.nwarz.weather.json.in;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {
	
	private List<Weather> weather;
	
	public WeatherData() {
	}
	
	public List<Weather> getWeather() {
		return weather;
	}
	
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
}
