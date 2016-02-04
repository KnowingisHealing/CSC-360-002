package program1;

/*
File Name: DequeDriver.java 
Author: Corey Shrader
Course: CSC 364-001
Date: 9/7/15
 */

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class DequeDriver {

	public static void main(String[] args) {
		// Will read a .txt file of valid commands and perform them on a deque.

		Deque deque = new Deque();

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter a file path: " );

		try {
			Scanner fileReader = new Scanner(new File(input.nextLine()));

			ArrayList<String> commands = new ArrayList<>();

			while (fileReader.hasNextLine()) {
				commands.add(fileReader.nextLine());
			}

			for (int i = 0; i < commands.size(); i++) {

				if (commands.get(i).equals("PR")) {
					if (deque.isempty()) {
						System.out.println("EMPTY DEQUE");
					}
					else {
						System.out.println("-----Front-----");
						deque.printDeque();
						System.out.println("-----Rear-----");
					}
				}
				if (commands.get(i).substring(0, 2).equals("IR")) {
					deque.insertRear(Integer.parseInt(commands.get(i).substring(3,commands.get(i).length())));
				}
				if (commands.get(i).substring(0, 2).equals("IF")) {
					deque.insertFront(Integer.parseInt(commands.get(i).substring(3,commands.get(i).length())));
				}
				if (commands.get(i).equals("DF")) {
					deque.deleteFront();
				}
				if (commands.get(i).equals("DR")) {
					deque.deleteRear();
				}
			}
			fileReader.close();
		}
		catch (Exception e) { // Deque methods are secure, so any exception thrown will be from input.
			System.out.println("Sorry, your input was invalid. Try running again with different input.");
			e.printStackTrace();
			input.close();
			return;
		}
		input.close();
	}
}

// /Users/EntheoMac/Documents/School:NKU/Fall 2015/CSC 364-001 Data Structures and Algorithms/Program1/inf1.txt
