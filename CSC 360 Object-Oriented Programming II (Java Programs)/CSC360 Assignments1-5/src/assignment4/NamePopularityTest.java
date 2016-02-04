package assignment4;

/*
File Name: NamePopularityTest.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 3/12/15
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class NamePopularityTest {

	@Test
	public void test() {

		String filePath = "/Users/EntheoMac/Documents/School:NKU/Spring 2015/CSC 360-002 Object-Oriented Programming II/Assignment4/names/";

		try {
			assertEquals("Valid path?", false, NamePopularity.storeNameFiles("hello"));
		}
		catch (Exception e) {
			System.out.println("Invalid path or file type");
		}

		try {
			assertEquals("Valid path?", true, NamePopularity.storeNameFiles(filePath));
		}
		catch (Exception e) {
			System.out.println("Invalid path or file type");
			return;
		}
		
		System.out.println(NamePopularity.years.get(0).get(0));
		
		Name tim = new Name("Timothy", "M");
		NamePopularity.printPopularity(tim, 20);
		
		Name casey = new Name("casey");
		NamePopularity.printPopularity(casey, 20);

	}

}
