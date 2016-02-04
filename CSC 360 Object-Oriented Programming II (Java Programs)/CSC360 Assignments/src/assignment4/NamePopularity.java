package assignment4;

/*
File Name: NamePopularity.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 3/12/15
 */

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class NamePopularity {

	protected static final int MOST_RECENT_YEAR = 2013;
	protected static final int FIRST_YEAR = 1880;
	protected static ArrayList<ArrayList<String>> years = new ArrayList<>();

	public static void main(String[] args) {
		// This program will allow a user to see a name's popularity over the years, given a file path with valid .txt 
		// files from the Social Security Agency.

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter a file path: ");

		// Allow the user 3 attempts to provide a valid file path with valid file names.
		boolean validFiles = false;
		int count = 1;
		while (!validFiles) {
			try {storeNameFiles(input.nextLine());}
			catch (Exception e) {
				if (count == 3) {
					System.out.println("Sorry, too many invalid attempts.");
					return;
				}
				System.out.println("Valid files not found. Please enter a valid path containing valid file names.");
				count++;
				continue;
			}
			validFiles = true;

		}

		// Allow the user 3 attempts to provide a valid alpha-numeric name to query.
		count = 1;
		String name = null;
		boolean validName = false;
		while (!validName) {
			System.out.println( "Name?" );
			name = input.nextLine();
			if (name.matches("^[a-zA-Z0-9]*$"))
				validName = true;
			else if (count == 3) {
				System.out.println("Sorry, too many invalid attempts.");
				return;
			}
			else {
				System.out.println("Invalid name. Please enter only alphanumeric characters.");
				count++;
			}
		}

		// Allow the user 3 attempts to provide a valid range of years.
		count = 1;
		int yearsBack = 1;
		boolean validYear = false;
		while (!validYear) {
			System.out.println( "Years back?" );
			yearsBack = input.nextInt();
			if (yearsBack > 134) {
				yearsBack = 134;
				validYear = true;
			}
			else if (yearsBack > 0) {
				validYear = true;
			}
			else if (count == 3) {
				System.out.println("Sorry, too many invalid attempts.");
				return;
			}
			else if (yearsBack <= 0 ) {
				System.out.println("Must be a positive integer. Please try again.");
				count++;
			}
		}

		// Allow the user to enter a sex, printing a separate list for each sex if none is selected
		System.out.println( "M/F?" );
		String sex = input.next();
		if (!sex.equalsIgnoreCase("M") && !sex.equalsIgnoreCase("F")) {
			Name nM = new Name(name, "M");
			Name nF = new Name(name, "F");
			printPopularity(nM, yearsBack);
			printPopularity(nF, yearsBack);
		}
		else {
			Name n = new Name(name, sex);
			printPopularity(n, yearsBack);
		}

		// Until the user quits, allow he/she to query a different name with the same sex and year range.
		boolean quit = false;
		while (!quit) {
			System.out.println("\nAnother name? Any non-alphanumeric character will quit.");
			name = input.next();
			if (name.matches("^[a-zA-Z0-9]*$")) {
				if (!sex.equalsIgnoreCase("M") && !sex.equalsIgnoreCase("F")) {
					Name nM = new Name(name, "M");
					Name nF = new Name(name, "F");
					printPopularity(nM, yearsBack);
					printPopularity(nF, yearsBack);
				}
				else {
					Name n = new Name(name, sex);
					printPopularity(n, yearsBack);
				}
			}
			else {
				quit = true;
			}
		}
		input.close();
	}

	public static void printPopularity(Name n, int yearsBack) {
		// Print a formatted list of the year and rank for a given name over a given range.

		System.out.printf("%-15s %15s %n", "\n\t" + n.getName() + " (" + n.getSex() + ")", "Years: " + yearsBack);
		System.out.println( "---------------------------------------------\n" );
		System.out.printf("%-15s %15s %n", "\t" + "Year", "Rank"); 
		for (int year = MOST_RECENT_YEAR; year > MOST_RECENT_YEAR - yearsBack; year--) {
			System.out.printf( "%-15s %15s %n", "\t" + year, n.getRank(year));
		}
	}

	public static boolean storeNameFiles(String filePath) throws Exception {
		// Looks for valid Social Security Agency .txt files in the given directory, and stores them in an ArrayList of
		// String ArrayLists. Throws exceptions for invalid paths or files.

		File directory = new File(filePath);
		if (!directory.exists()) {
			throw new Exception("Path does not exist.");
		}
		else {
			for (int year = FIRST_YEAR; year <= MOST_RECENT_YEAR; year++) {
				try {
					Scanner fileScanner = new Scanner(new File(filePath + "yob" + year + ".txt" ));
					ArrayList<String> yearNames = new ArrayList<>();
					while (fileScanner.hasNextLine()) {
						yearNames.add(fileScanner.nextLine());
					}
					years.add(yearNames);
					fileScanner.close();
				}
				catch (Exception e) {
					System.out.println("Error. Invalid files in directory.");
					throw new Exception("Files do not exist");
				}
			}
			return true;
		}
	}
}

// /Users/EntheoMac/Documents/School:NKU/Spring 2015/CSC 360-002 Object-Oriented Programming II/Assignment4/names/
