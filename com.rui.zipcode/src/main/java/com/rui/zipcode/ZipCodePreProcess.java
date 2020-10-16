package com.rui.zipcode;

import java.util.ArrayList;
import java.util.List;

public class ZipCodePreProcess {

	public static String[][] generateZipCodeArray(String zipcodeString) {
		String[] zipcodeIntervals = zipcodeString.replaceAll(",\\s*", ",").split(" ");
		
		List<String[]> zipcodeList = new ArrayList<String[]>();
		for (int i = 0; i < zipcodeIntervals.length; i++) {
			zipcodeList.add(validateZipCode(zipcodeIntervals[i]));
		}
		
		String[][] zipcodeArray = new String[zipcodeList.size()][2];
		for (int i = 0; i < zipcodeList.size(); i++) {
			zipcodeArray[i] = zipcodeList.get(i);
		}
		return zipcodeArray;
	}
	
	public static String[] validateZipCode(String zipcodeInterval) {
		String[] zipcodeComb = zipcodeInterval.replaceAll("\\[|\\]|\\s", "").split(",");
	
		// ZipCode Pair Check
		if (zipcodeComb.length != 2)
			throw new IllegalArgumentException("Missing ZipCode and Current Pair Number is :" + zipcodeComb.length);
		
		int[] zipcodePair = new int[2];
		for (int i = 0; i < zipcodeComb.length; i++) {
			
			// ZipCode length check
			if (zipcodeComb[i].length() != 5)
				throw new IllegalArgumentException("Invalid length of ZipCode and Current is " + zipcodeComb[i].length());
			
			int zipcodeNumber = Integer.parseInt(zipcodeComb[i]);
			
			// ZipCode length check
			if (zipcodeNumber < 0 || zipcodeNumber > 99999)
				throw new IllegalArgumentException("Out of range and ZipCode is " + zipcodeComb[i]);
			
			zipcodePair[i] = zipcodeNumber;
		}
		
		// ZipCode Value Check
		if (zipcodePair[0] > zipcodePair[1])
			throw new IllegalArgumentException("Invalid Boundary of ZipCode ");
		
		return zipcodeComb;
		
	}
}