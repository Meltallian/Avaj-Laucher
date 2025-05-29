package com.avaj.simulator.aircraft;

import com.avaj.simulator.Utilities;
import com.avaj.simulator.tower.WeatherTower;

public abstract class Flyable {
	protected WeatherTower	weatherTower;
	protected  Flyable() {};

	public abstract void	updateConditions();
	public void	registerTower(WeatherTower p_tower) {
		this.weatherTower = p_tower;
		p_tower.register(this);
	}
}