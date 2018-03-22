package com.nwarz.weather.json.out;

public class SnowData {

	private final boolean snowing;

	private final boolean willSnowSoon;
	
	
	public SnowData(boolean snowing, boolean willSnowSoon) {
		this.snowing = snowing;
		this.willSnowSoon = willSnowSoon;
	}
	
	public boolean getSnowing() {
		return snowing;
	}
	
	public boolean getWillSnowSoon() {
		return willSnowSoon;
	}
}
