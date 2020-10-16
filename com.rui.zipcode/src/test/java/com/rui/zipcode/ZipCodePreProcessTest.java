package com.rui.zipcode;

import org.junit.*;
import java.util.Arrays;
import static com.rui.zipcode.ZipCodePreProcess.*;

public class ZipCodePreProcessTest {
	

	@Test
	public void generateZipCodeArrayTest() {
		String[][] nums = {{"10000", "20000"},{"30000", "40000"},{"50000", "60000"}};		
		String[][] res = generateZipCodeArray("[10000,20000] [30000,40000] [50000,60000]");	
		assert(Arrays.deepEquals(res, nums));

	}
	
	@Test
	public void validation() {
		assert(Arrays.equals(validateZipCode("[10000,20000]"), new String[] {"10000","20000"}));
		assert(Arrays.equals(validateZipCode("[00000,00100]"), new String[] {"00000","00100"}));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void validationCatchMissingValue() {
		validateZipCode("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void validationCatchInvalidLength() {
		validateZipCode("[1,10000]");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void validationOutOfRange() {
		validateZipCode("[1,1000000]");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void validationCatchInvalidPair() {
		validateZipCode("[99999,10000]");
	}

}
