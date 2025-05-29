package com.avaj.simulator.tower;

import com.avaj.simulator.Utilities;
import com.avaj.simulator.tower.Tower;
import com.avaj.simulator.tower.WeatherProvider;
import com.avaj.simulator.aircraft.Coordinates;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates p_coordinates) {
		return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
	}
	public void	changeWeather() {
		WeatherProvider.getInstance().changeWeathermap();
		conditionChanged();
	}
}