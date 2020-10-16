package com.rui.zipcode;

import org.junit.*;
import static com.rui.zipcode.ZipCodeMerge.*;

import java.util.Arrays;
public class ZipCodeMergeTest {

	@Test(expected = IllegalArgumentException.class)
	public void illegalInput() {
		merge(null);
	}
	
	@Test
	public void mergePassCase() {
		String[][] nums1 = {{"10000", "60000"}};		
		String[][] res1 = merge(new String[][]{{"10000","20000"},{"10000","40000"},{"30000","60000"}});	
		assert(Arrays.deepEquals(res1, nums1));
		
		String[][] nums2 = {{"01230", "12300"},{"66666","99999"}};		
		String[][] res2 = merge(new String[][]{{"01230","12300"},{"66666","99999"},{"66666","77777"}});	
		assert(Arrays.deepEquals(res2, nums2));

	}
}
