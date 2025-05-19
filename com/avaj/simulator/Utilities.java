package com.avaj.simulator;

import java.util.List;

public class Utilities {

	private Utilities() {
		//prevents instantiation
	}

	public static boolean	isInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean	scenarioParse(List<String> lines){
		if (lines.isEmpty()) {
			System.out.println("Parsing error: empty scenario file.");
			return false;
		}
		if (!isInt(lines.get(0))) {
			System.out.println("Parsing error: first line must be an simple Integer. ");
			return false;
		}	
		return true;
	}
}