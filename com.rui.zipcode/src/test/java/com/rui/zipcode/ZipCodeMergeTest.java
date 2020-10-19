package com.rui.zipcode;

import org.junit.*;
import static com.rui.zipcode.ZipCodeMerge.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
public class ZipCodeMergeTest {

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalInput_mergeZipCode() throws Exception {
		mergeZipCode(null);
	}
	
	@Test
	public void testLlegalInput_mergeZipCode() throws Exception {
		List<ZipCode> input = new ArrayList<>();
		input.add(new ZipCode(00000, 10000));
		input.add(new ZipCode(10000, 20000));
		input.add(new ZipCode(30000, 40000));	
		
		List<ZipCode> expected = new ArrayList<>();
		expected.add(new ZipCode(00000, 20000));
		expected.add(new ZipCode(30000, 40000));

		assertEquals(expected, mergeZipCode(input));

	}
	
	@Test
	public void testLlegalInput2_mergeZipCode() throws Exception {
		List<ZipCode> input = new ArrayList<>();
		input.add(new ZipCode(80000, 90000));
		input.add(new ZipCode(10000, 99999));
		input.add(new ZipCode(30000, 40000));	
		
		List<ZipCode> expected = new ArrayList<>();
		expected.add(new ZipCode(10000, 99999));

		assertEquals(expected, mergeZipCode(input));

	}
}
