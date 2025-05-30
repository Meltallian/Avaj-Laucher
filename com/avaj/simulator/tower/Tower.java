package com.avaj.simulator.tower;

import com.avaj.simulator.aircraft.Flyable;
import java.util.List;
import java.util.ArrayList;

public class Tower {
	private List<Flyable> observers;

	public Tower() {
		this.observers = new ArrayList<Flyable>();
	}

	public void	register(Flyable p_flyable) {
		observers.add(p_flyable);
	}

	public void	unregister(Flyable p_flyable) {
		observers.remove(p_flyable);
	}

	protected void	conditionChanged() {
		for (Flyable observer : observers) {
			// uncomment once done in Flyable
			// observer.updateConditions();
		}
	}
}