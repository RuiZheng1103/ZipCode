package com.rui.zipcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZipCodeMerge {
	
	public static List<ZipCode> mergeZipCode(List<ZipCode> zipcodelist) throws Exception{
		/*
		 * Merge ZipCodes if there is an overlapping
		 */
		if (zipcodelist == null || zipcodelist.size() == 0) 
			throw new IllegalArgumentException("Empty Input");
		
		// Sort by lower bound
		zipcodelist.sort((ZipCode z1, ZipCode z2) -> z1.getLower_bound() - z2.getLower_bound());

		Stack<ZipCode> stack = new Stack<>();
		
		for (ZipCode zipcode : zipcodelist) {	
			// compare last upper bound with current lower bound
			if (stack.isEmpty() || stack.peek().getUpper_bound() < zipcode.getLower_bound()) {
				stack.push(zipcode);
			} 
			// compare last upper bound with current upper bound
			else {
				ZipCode last_zipcode = stack.pop();
				if (last_zipcode.getUpper_bound() < zipcode.getUpper_bound()) {
					last_zipcode.setUpper_bound(zipcode.getUpper_bound());
				}
				stack.push(last_zipcode);
			}
		}
		return new ArrayList<>(stack);
	}
}
