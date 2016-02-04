/*
File Name: DAG.java 
Author: Corey Shrader
Course: CSC 364-001
Date: 12/1/15
Description: This class is an implementation of a directed, acyclic, graph (DAG).
 */

package program6;

public class DAG {

	private boolean[][]  g;   // the adjacency matrix itself
	private int[] inDegree;  // an array which stores the in-degree for each vertex
	private boolean[] scheduled;  // indicates if vertex was scheduled
	private int numVertices;   // count of the number of vertices in the graph.

	public DAG( int n ) { // initializes the data fields with the given size
		g = new boolean[n][n];
		numVertices = n;
		scheduled = new boolean[n];
		inDegree = new int[n];
	}
	public void  setXY( int x, int y ) { // a method that creates an edge from x to y
		g[x][y] = true;
	}
	public void setInDegree() { // sets the in-degree for all N vertices in the DAG
		for (int x = 0; x < numVertices; x++) {
			inDegree[x] = 0;
			for (int y = 0; y < numVertices; y++) {
				if (g[y][x])
					inDegree[x]++;
			}
		}
	}
	public void topologicalSort(){ // carries out a topological sort
		int numScheduled = 0;
		while ( numScheduled < numVertices ) {
			//find a vertex V that has NOT been scheduled yet AND has in-degree of 0
			int v = 0;
			while (scheduled[v] || inDegree[v] != 0)
				v++;
			//schedule the vertex (print out the vertex)
			scheduled[v] = true;
			System.out.println(v);
			numScheduled++;
			//walk through row V of the adjacency matrix
			for (int x = 0; x < numVertices; x++) {
				if (g[v][x])
					inDegree[x] = inDegree[x] - 1; // one less incoming edge for X
			}
		}
	}
}