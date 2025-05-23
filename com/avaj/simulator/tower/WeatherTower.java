package com.avaj.simulator.tower;

import com.avaj.simulator.tower.Tower;
import com.avaj.simulator.aircraft.Coordinates;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates p_coordinates) {
		String weather = "RAIN";
		return weather;
	}
}