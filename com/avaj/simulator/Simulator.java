package com.avaj.simulator;

import com.avaj.simulator.Utilities;
import com.avaj.simulator.tower.WeatherProvider;
import com.avaj.simulator.tower.WeatherTower;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Simulator {
	public static void main(String[] av) {
		if (av.length != 1) {
			// System.out.println("Error: No scenario file specified");
			System.out.println("Usage: java Simulator <scenario_file>");
			return;
		}
		try {
			List<String> lines = Files.readAllLines(Paths.get(av[0]));

			if (!Utilities.scenarioParse(lines)) {
				return;
			}
		} catch (IOException e) {
			Utilities.pf("Error reading file: " + e.getMessage());
		}
		try {
			WeatherProvider seg = WeatherProvider.getInstance();
			WeatherTower wt = new WeatherTower();
			// wt.register();	
		} catch (Exception e) {
			Utilities.pf("Error: " + e.getMessage());
		}
	}
}
