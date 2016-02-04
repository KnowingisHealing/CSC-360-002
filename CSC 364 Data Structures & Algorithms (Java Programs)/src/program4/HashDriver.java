/*
File Name: HashDriver.java 
Author: Corey Shrader
Course: CSC 364-001
Date: 10/27/15
 */

// This program, given two valid input files, uses a hash table to compare and print common words in the files

package program4;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class HashDriver {

	public static void main(String[] args) {

		HashTable hash = new HashTable(143); // our new hash table has a size of 143
		ArrayList<String> common = new ArrayList<String>(); // a list used to store common words
		char nextChar; // used while reading a line from a file
		String line, word; // used while reading files and pulling out words

		try {
			
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the first file path: "); // prompt user for first file path
			Scanner fileReader = new Scanner(new File(input.nextLine()));

			while (fileReader.hasNextLine()) {
				line = fileReader.nextLine(); // read file line by line
				word = "";

				for (int i = 0; i < line.length(); i++) { // read line character by character
					nextChar = line.charAt(i);

					if (Character.isLetter(nextChar)) // if a character is a letter, add it to our current word
						word += nextChar;

					// if we've reached a non-letter or end of the line and the current word is longer than 3 letters, use it
					if ((word.length() >= 3 && !Character.isLetter(nextChar)) || (word.length() >= 3 && i == line.length() - 1)) {
						word = word.toLowerCase(); // all words should be lowercase
						hash.insert(word); // add word to hash table
						word = ""; // reset the current word
					}

					// otherwise, reset the word when we reach a non-letter
					else if (!Character.isLetter(nextChar))
						word = "";
				}
			}

			System.out.println("Enter the second file path:"); // prompt user for second file
			fileReader= new Scanner(new File(input.nextLine()));

			while (fileReader.hasNextLine()) {
				line = fileReader.nextLine();
				word = "";

				for (int i = 0; i < line.length(); i++) { // logic is similar to first file
					nextChar = line.charAt(i);

					if (Character.isLetter(nextChar))
						word += nextChar;

					if ((word.length() >= 3 && !Character.isLetter(nextChar)) || (word.length() >= 3 && i == line.length() - 1)) {
						word = word.toLowerCase();

						int foundpos = hash.lookup(word); // look up word to see if it's in the hash table
						if (foundpos >= 0) { // if so, add it to list of common words
							common.add(word);
							hash.markNowEmpty(foundpos); // delete word from table
						}
						word = "";
					}

					else if (!Character.isLetter(nextChar))
						word = "";				
				}
			}

			common.sort(null); // sort the list of common words alphabetically

			System.out.println("The following words were found in both files:\n"); // print common words
			for (int i = 0; i < common.size(); i++) 
				System.out.println(common.get(i));

			fileReader.close();
			input.close();
		}

		catch (Exception e) {
			System.out.println("Sorry, invalid input. Printing stack trace...");
			e.printStackTrace();
		}
	}
}