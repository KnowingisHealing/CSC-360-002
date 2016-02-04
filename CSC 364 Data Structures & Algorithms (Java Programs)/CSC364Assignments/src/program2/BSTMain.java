package program2;

import java.io.File;
import java.util.Scanner;

/*
File Name: BSTMain.java 
Author: Corey Shrader
Course: CSC 364-001
Date: 9/22/15
 */

public class BSTMain {

	/*  This program will accept a valid input file of values, store them in a binary search tree,
	 *  and perform in order and level traversals of the tree, printing each value. */

	public static void main(String[] args) {

		BST tree = new BST();

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter a file path: " );

		try {
			Scanner fileReader = new Scanner(new File(input.nextLine()));

			while (fileReader.hasNextLine()) {
				tree.insert(Integer.parseInt(fileReader.nextLine()));
			}

			System.out.println("LEVEL ORDER TRAVERSAL\n");
			tree.levelorder();

			System.out.println("\n\nINORDER TRAVERSAL\n");
			tree.inorder();

			fileReader.close();
			input.close();

		}
		catch (Exception e ) {
			System.out.println("Sorry, your input was invalid. Try running again with different input.");
			e.printStackTrace();
			input.close();
			return;
		}
	}

}

// /Users/EntheoMac/Documents/School:NKU/Fall 2015/CSC 364-001 Data Structures and Algorithms/Program2/input.txt
