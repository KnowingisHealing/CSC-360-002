/*
File Name: MCSTDriver.java 
Author: Corey Shrader
Course: CSC 364-001
Date: 11/10/15
Description: This program builds an undirected, weighted graph from an input file finds a minimum cost spanning tree for it.
 */

package program5;

import java.io.File;
import java.util.Scanner;

public class MCSTDriver {

	public static void main(String[] args) {
		
		try {
		int nv; // number of vertices from graph in file
		int ne; // number of edges from graph in file
		int x; int y; int w; // values representing two vertexes and their edge's weight

		//  set up input from file graph.txt
		Scanner fileReader = new Scanner(new File("/Users/EntheoMac/Documents/School:NKU/Fall 2015/CSC 364-001 Data Structures and Algorithms/Program5/graph.txt"));
		nv = Integer.parseInt(fileReader.nextLine()); // read the number of vertices from graph.txt
		ne = Integer.parseInt(fileReader.nextLine()); // read the number of edges from graph.txt

		MCSTGraph G = new MCSTGraph( nv ); // create the actual graph object

		for ( int a = 0; a < ne; a++ ) {
			// for each edge, read the x vertex, y vertex, and weight
			x = fileReader.nextInt();
			y = fileReader.nextInt();
			w = fileReader.nextInt();
			
			G.insert(x, y, w); // insert edge into graph
		}

		int totalCost =  G.primsAlg(); // obtain total cost using Prim's algorithm
		System.out.println("Total cost of MCST is " + totalCost ); // print total cost
		fileReader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} 
}