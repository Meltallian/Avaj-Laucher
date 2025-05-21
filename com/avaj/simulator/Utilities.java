package com.avaj.simulator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public static void	pl(String str) {
		if (!str.isEmpty()) {
			System.out.println(str);
		}
		else {
			System.out.println("Error pl call with empty string");
		}
	}

	public static boolean	scenarioParse(List<String> lines){
		if (lines.isEmpty()) {
			pl("Parsing error: empty scenario file.");
			return false;
		}
		if (!isInt(lines.get(0))) {
			pl("Parsing error: first line must be an simple Integer. ");
			return false;
		}
		Pattern pattern = Pattern.compile(
			"^(Baloon|JetPlane|Helicopter)\\s" +  // Vehicle type
			"\\w+\\s" +                           // Word characters
			"(360|3[0-5][0-9]|[1-2][0-9][0-9]|[1-9][0-9]|[0-9])\\s" +  // 0-360
			"(180|1[0-7][0-9]|[1-9][0-9]|[0-9])\\s" +                 // 0-180
			"(100|[1-9][0-9]|[0-9])$",                               // 0-100
			Pattern.COMMENTS);		//ignores whitespace in the pattern except \\s
		for (int i = 1; i < lines.size(); i++) {
			String line = lines.get(i);
			Matcher matcher = pattern.matcher(line);
			if (!matcher.find()) {
				pl("Error: scenario.txt not valid");
				return false;
			}
		}
		return true;
	}
}