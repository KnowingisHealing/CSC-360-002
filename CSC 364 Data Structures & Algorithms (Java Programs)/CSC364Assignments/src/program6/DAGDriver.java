/*
File Name: DAGDriver.java 
Author: Corey Shrader
Course: CSC 364-001
Date: 12/1/15
Description: This program performs a topological sort on a directed, acyclic graph constructed from an input file.
 */

package program6;

import java.io.File;
import java.util.Scanner;

public class DAGDriver {

	public static void main(String[] args) {
		try {
			int nv; // number of vertices from graph in file
			int ne; // number of edges from graph in file
			int x; int y; // values representing two vertices of an edge

			//  set up input from file graph.txt
			Scanner fileReader = new Scanner(new File("/Users/EntheoMac/Documents/School:NKU/Fall 2015/CSC 364-001 Data Structures and Algorithms/Program6/input1.txt"));
			nv = Integer.parseInt(fileReader.nextLine()); // read the number of vertices from input
			ne = Integer.parseInt(fileReader.nextLine()); // read the number of edges from input

			DAG g = new DAG(nv); // create the actual graph object

			for ( int a = 0; a < ne; a++ ) {
				// for each edge, read the x vertex and y vertex
				x = fileReader.nextInt();
				y = fileReader.nextInt();

				g.setXY(x, y); // insert edge into graph
			}

			g.setInDegree(); // initialize the in-degrees of all vertices in graph
			g.topologicalSort(); // perform the topological sort, printing each vertex as it's scheduled

			fileReader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}