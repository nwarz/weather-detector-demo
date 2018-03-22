package com.nwarz.weather.controller;

import java.time.Instant;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nwarz.weather.Application;
import com.nwarz.weather.Config;
import com.nwarz.weather.cache.CachedSnowData;
import com.nwarz.weather.json.in.WeatherData;
import com.nwarz.weather.json.in.Forecast;
import com.nwarz.weather.json.in.Weather;
import com.nwarz.weather.json.out.SnowData;

@RestController
public class SnowDataController {
	
	private CachedSnowData cachedSnowData;

	@RequestMapping("/snowdata")
	public SnowData snowData() {
		// make sure cache is older than 10 minutes to limit api calls
		if((cachedSnowData == null)
				|| cachedSnowData.getTime().plusSeconds(10*60).isBefore(Instant.now())) {
			
			SnowData snowData = new SnowData(isCurrentlySnowing(), willSnowSoon());
			cachedSnowData = new CachedSnowData(Instant.now(), snowData);
			Application.log.info("retrieved new data");
			
		} else {
			Application.log.info("used cached data");
		}
		
		return cachedSnowData.getSnowData();
	}
	
	private boolean isCurrentlySnowing() {
		WeatherData currentWeatherData = new RestTemplate().getForObject(
				"http://api.openweathermap.org/data/2.5/weather?"
				+ "lat=" + Config.LAT + "&lon=" + Config.LON 
				+ "&appid=" + Config.APP_ID,
				WeatherData.class);
		
		List<Weather> weathers = currentWeatherData.getWeather();
		for(Weather weather : weathers) {
			if("snow".equalsIgnoreCase(weather.getMain())) {
				return true;
			}
		}
		return false;
	}
	
	private boolean willSnowSoon() {
		Forecast forecast = new RestTemplate().getForObject(
				"http://api.openweathermap.org/data/2.5/forecast?"
				+ "lat=" + Config.LAT + "&lon=" + Config.LON 
				+ "&appid=" + Config.APP_ID,
				Forecast.class);
		
		List<WeatherData> weatherDatas = forecast.getList();
		for(WeatherData weatherData : weatherDatas) {
			for(Weather weather : weatherData.getWeather()) {
				if("snow".equalsIgnoreCase(weather.getMain())) {
					return true;
				}
			}
		}
		return false;
	}
}
