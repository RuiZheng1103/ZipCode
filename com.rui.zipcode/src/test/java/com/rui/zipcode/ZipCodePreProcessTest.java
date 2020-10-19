package com.rui.zipcode;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static com.rui.zipcode.ZipCodePreProcess.*;
import static org.junit.Assert.assertEquals;

public class ZipCodePreProcessTest {
	
	@Test
	public void testLegal_getZipCodeList() throws Exception {
		String input = "[00000, 10000] [10000, 20000] [30000, 40000]";
		List<ZipCode> real_list = new ArrayList<>(getZipCodeList(input));
		
		List<ZipCode> expected_list = new ArrayList<>();
		expected_list.add(new ZipCode(00000, 10000));
		expected_list.add(new ZipCode(10000, 20000));
		expected_list.add(new ZipCode(30000, 40000));
		
		assert(real_list.equals(expected_list));
	}
	
	@Test
	public void testLegal_checkAndGetZipCode() throws Exception {
		String input = "[00000, 10000]";
		ZipCode real_zipcode = new ZipCode(00000, 10000);
		assert(checkAndGetZipCode(input).equals(real_zipcode) );
	}
	
	@Test
	public void testIllegalNumber_checkAndGetZipCode() throws Exception {
		try {
			checkAndGetZipCode("");
		} catch (Exception e) {
			assertEquals("Invalid ZipCode Bound Number : 1" , e.getMessage());
		}
	}
	
	@Test
	public void testIllegalLowerBound_checkAndGetZipCode()throws Exception {
		try {
			checkAndGetZipCode("[1, 00001]");
		} catch (Exception e) {
			assertEquals("Invalid Lower Boundary Length : 1" , e.getMessage());
		}
	}
	
	@Test
	public void testIllegalUpperBound_checkAndGetZipCode() throws Exception {
		try {
			checkAndGetZipCode("[00000, 100]");
		} catch (Exception e) {
			assertEquals("Invalid Upper Boundary Length : 3" , e.getMessage());
		}
	}
	
	@Test(expected= NumberFormatException.class)
	public void testIllegalNumberLowerBound_checkAndGetZipCode() throws Exception {
		checkAndGetZipCode("[a0000, 10000]");
	}
	
	@Test(expected= NumberFormatException.class)
	public void testIllegalNumberUpperBound_checkAndGetZipCode() throws Exception {
		checkAndGetZipCode("[10000, a0000]");
	}
	
	@Test
	public void testIllegalLowerBoundValueAndUpperBoundValue_checkAndGetZipCode() throws Exception {
		try {
			checkAndGetZipCode("[10000, 00000]");
		} catch (Exception e) {
			assertEquals("Lower Boundary Value : 10000 is larger than Upper Boundary Value : 0", e.getMessage());
		}
	}

}
