package com.rui.zipcode;

import java.util.Arrays;

import java.util.Scanner;

import static com.rui.zipcode.ZipCodePreProcess.*;
import static com.rui.zipcode.ZipCodeMerge.*;

public class App {

	private static Scanner scanner;
	
	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		String rawzipcode = scanner.nextLine();
		

		String[][] zipcodeArray = generateZipCodeArray(rawzipcode);
		
		String[][] zipcodeMergeArray = merge(zipcodeArray);
		
		for (String[] arr: zipcodeMergeArray) {
			System.out.println(Arrays.toString(arr));
		}
	}

}