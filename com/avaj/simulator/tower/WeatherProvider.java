package com.avaj.simulator.tower;

import java.util.Random;
import com.avaj.simulator.Utilities;
import com.avaj.simulator.aircraft.Coordinates;

public class WeatherProvider {
	private String[]	weather;
	private int[][][]	weathermap;
	private WeatherProvider() {
		setWeatherTypes();
		generateWeathermap();
	}
	private static WeatherProvider instance = null;

	public static WeatherProvider getInstance() {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		return instance;
	}
	private void	setWeatherTypes() {
		weather = new String[4];
		weather[0] = "RAIN";
		weather[1] = "FOG";
		weather[2] = "SUN";
		weather[3] = "SNOW";		
	}
	private void	generateWeathermap() {
		weathermap = new int[360][180][100];
        Random random = new Random();
        for (int x = 0; x < 360; x++) {
            for (int y = 0; y < 180; y++) {
                for (int z = 0; z < 100; z++) {
                    weathermap[x][y][z] = random.nextInt(4); // 0, 1, 2, or 3
                }
            }
        }		
	}
	public void	changeWeathermap() {
        Random random = new Random();
        for (int x = 0; x < 360; x++) {
            for (int y = 0; y < 180; y++) {
                for (int z = 0; z < 100; z++) {
                    weathermap[x][y][z] = random.nextInt(4); // 0, 1, 2, or 3
                }
            }
        }		
	}
	public String	getCurrentWeather(Coordinates p_coordinates) {
		try {
			return weather[0]; //[placeholder]
			// return weather[weathermap[p_coordinates.getLongitude()][p_coordinates.getLatitude()][p_coordinates.getHeight()]];
		} catch (Exception e) {
			Utilities.pf("Error: " + e.getClass().getSimpleName());
			e.printStackTrace();
			return weather[0];			
		}
	}
}
