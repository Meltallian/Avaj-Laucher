package com.avaj.simulator.aircraft;

import com.avaj.simulator.aircraft.Helicopter;
import com.avaj.simulator.aircraft.JetPlane;
import com.avaj.simulator.aircraft.Baloon;
import com.avaj.simulator.Utilities;

public class AircraftFactory {
	private static long	id;
	private static AircraftFactory	instance = null;
	private AircraftFactory() {
		this.id = 0;
	}
	public static AircraftFactory	getInstance() {
		if (instance == null) {
			instance = new AircraftFactory();
		}
		return instance;
	}

	public Flyable	newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		switch (p_type) {
			case "Helicopter":
				return new Helicopter(this.id++, p_name, p_coordinates);
			case "JetPlane":
				return new JetPlane(this.id++, p_name, p_coordinates);
			case "Baloon":
				return new Baloon(this.id++, p_name, p_coordinates);
			default:
				throw new IllegalArgumentException("unknown aircraft type: " + p_type);
		}
	}
}