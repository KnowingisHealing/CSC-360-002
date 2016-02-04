/*
File Name: HeapBuilder.java 
Author: Corey Shrader
Course: CSC 364-001
Date: 10/5/15
 */

// This program, given a valid input file, will build a MinHeap of values and print the heap in sorted order.

package program3;

import java.util.Scanner;
import java.io.File;

public class HeapBuilder {

	public static void main(String[] args) {

		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter a file path: ");
			Scanner fileReader = new Scanner(new File(input.nextLine()));
			
			Heap minHeap = new Heap(); 
			while (fileReader.hasNextInt()) // insert values into heap from user's file
				minHeap.insert(fileReader.nextInt());

			minHeap.printSorted(); // print the heap in sorted order
			
			fileReader.close();
			input.close();
		}

		catch (Exception e) {
			System.out.println("Sorry, invalid input. Printing stack trace...");
			e.printStackTrace();
		}
	}

}