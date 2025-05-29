package com.avaj.simulator.aircraft;

import com.avaj.simulator.Utilities;
import com.avaj.simulator.aircraft.Flyable;
import com.avaj.simulator.aircraft.Coordinates;

public class Aircraft extends Flyable {
	protected long			id;
	protected String		name;	
	protected Coordinates	coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;
	}
	@Override
	public void	updateConditions() {
		// Nothing pretty much
	}
	
}