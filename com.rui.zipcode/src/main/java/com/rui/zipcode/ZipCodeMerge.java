package com.rui.zipcode;

import java.util.Arrays;
import java.util.Stack;

public class ZipCodeMerge {
	
	public static String[][] merge(String[][] intervals) {
		if (intervals == null || intervals.length == 0) 
			throw new IllegalArgumentException("Invalid Input");
		
		Arrays.sort(intervals, (String[] v1, String[] v2) -> Integer.parseInt(v1[0]) - Integer.parseInt(v2[0]));
		
		Stack<String[]> s = new Stack<>();
		for (String[] interval : intervals) {
			if (s.isEmpty() || Integer.parseInt(s.peek()[1]) < Integer.parseInt(interval[0])) {
				s.push(interval);
			} else {
				String[] lastInterval = s.pop();
				if (Integer.parseInt(lastInterval[1]) < Integer.parseInt(interval[1])) {
					lastInterval[1] = interval[1];
				}
				s.push(lastInterval);
			}
		}
		return s.toArray(new String[s.size()][]);
	}
}
