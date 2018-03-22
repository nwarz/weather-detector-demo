package com.nwarz.weather.cache;

import java.time.Instant;

import com.nwarz.weather.json.out.SnowData;

public class CachedSnowData {

	private Instant time;
	private SnowData snowData;
	
	public CachedSnowData(Instant time, SnowData snowData) {
		this.time = time;
		this.snowData = snowData;
	}
	
	public Instant getTime() {
		return time;
	}
	
	public SnowData getSnowData() {
		return snowData;
	}
}
