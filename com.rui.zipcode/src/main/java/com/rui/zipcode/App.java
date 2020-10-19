package com.rui.zipcode;

import java.util.List;
import java.util.Scanner;

import static com.rui.zipcode.ZipCodePreProcess.*;
import static com.rui.zipcode.ZipCodeMerge.*;

public class App {

	
	public static void main(String[] args) {
		
		String rawzipcode;
		Scanner scanner = new Scanner(System.in);
		List<ZipCode> zipcodelist;
		List<ZipCode> mergelist;
		while (true) {
			try {
				rawzipcode = scanner.nextLine();
				zipcodelist = getZipCodeList(rawzipcode);
				mergelist = mergeZipCode(zipcodelist);
				break;
			} catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println("please re-input");
			}			
		}
		
		scanner.close();
		
		// print ZipCode result
		mergelist.stream().forEach(System.out::println);
	}

}
