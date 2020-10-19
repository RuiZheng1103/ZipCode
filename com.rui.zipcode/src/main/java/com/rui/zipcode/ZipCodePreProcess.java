package com.rui.zipcode;

import java.util.ArrayList;
import java.util.List;

public class ZipCodePreProcess {

	public static List<ZipCode> getZipCodeList(String zipcodeString) throws Exception{
		/* 
		 * Split String by Space between each zipcodeInterval
		 */
		String[] zipcodeIntervals = zipcodeString.replaceAll(",\\s*", ",").split(" ");
		
		List<ZipCode> zipcodelist = new ArrayList<ZipCode>();
		for (int i = 0; i < zipcodeIntervals.length; i++) {
			zipcodelist.add(checkAndGetZipCode(zipcodeIntervals[i]));
		}
		
		return zipcodelist;
	}


	static ZipCode checkAndGetZipCode(String zipcodeInterval) throws Exception{
		/*
		 * Transfer ZipCode Interval into ZipCode Entity
		 */
		String[] zipcoderange = zipcodeInterval.replaceAll("\\[|\\]|\\s", "").split(",");
		
		if (zipcoderange.length != 2)
			throw new IllegalArgumentException("Invalid ZipCode Bound Number : " + zipcoderange.length);
		
		if (!checkLength(zipcoderange[0]))
			throw new IllegalArgumentException("Invalid Lower Boundary Length : " + zipcoderange[0].length());
		
		if (!checkLength(zipcoderange[1]))
			throw new IllegalArgumentException("Invalid Upper Boundary Length : " + zipcoderange[1].length());
				
		int lower_bound = parseZipCode(zipcoderange[0]);
		int upper_bound = parseZipCode(zipcoderange[1]);
		
		// lower_bound and upper_bound are both 5-digit so checkValue must be TRUE
		if (!checkValue(lower_bound))
			throw new IllegalArgumentException("Invalid Lower Boundary Value : " + lower_bound);

		if (!checkValue(upper_bound))
			throw new IllegalArgumentException("Invalid Upper Boundary Value : " + upper_bound);

		if (lower_bound > upper_bound)
			throw new IllegalArgumentException("Lower Boundary Value : " + lower_bound + " is larger than Upper Boundary Value : " + upper_bound);
		
		return new ZipCode(lower_bound, upper_bound);
	}

	private static int parseZipCode(String zipcode_bound) {
		/*
		 * parse ZipCode to int value
		 */
		return Integer.parseInt(zipcode_bound);
	}

	private static boolean checkValue(int zipcode_bound_value) {
		/*
		 * check value of bound
		 */
		return zipcode_bound_value >= 0 && zipcode_bound_value <= 99999;		
	}

	private static boolean checkLength(String zipcode_bound) {
		/*
		 * check length of bound
		 */
		return zipcode_bound.length() == 5;			
	}
	
}
