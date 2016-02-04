/*
File Name: MCSTGraph.java 
Author: Corey Shrader
Course: CSC 364-001
Date: 11/10/15
Description: This file implements a class for a weighted, undirected graph.
 */

package program5;

import java.util.Set;
import java.util.HashSet;

public class MCSTGraph {

	private EdgeNode[] edgeList;  // array of linked lists of EdgeNodes
	private int numVertices; //  total vertex count

	public MCSTGraph(int n) { // creates an MCSTGraph with n vertices 

		numVertices = n;
		edgeList = new EdgeNode[n];
		for (int i = 0; i < numVertices; i++) // each node in the linked list begins as a "dummy" node pointer
			edgeList[i] = new EdgeNode();

	}

	public int primsAlg() { // uses Sets to implement Prim's algorithm to find and print a minimum cost spanning tree
		int totalCost = 0;

		Set<Integer> unvisited = new HashSet<Integer>(numVertices); // create a set for unvisited vertices
		for (int x = 1; x < numVertices; x++) // 1 will be the first "unvisited" vertex
			unvisited.add(x);

		Set<Integer> visited = new HashSet<Integer>(numVertices); // create a set for visited vertices, starting with 0
		visited.add(0);

		Set<EdgeNode> currentEdges = new HashSet<EdgeNode>(numVertices * numVertices); // holds current EdgeNodes we're traversing

		while (!unvisited.isEmpty()) { // loop until we've visited all verteces

			for (int v : visited) { // for each vertex in our visited list
				for (EdgeNode a = edgeList[v]; a != null; a = a.getNext()) { // for each node in the vertex's linked list
					if  (unvisited.contains(a.getAdjacentVertex()))  // check adjacent vertex to see if we've visited it
						currentEdges.add(a);     //  add edge to possible next edges
				}   // end linked list traversal
			}  //  end for iterator on visited

			int  lowestEdgeCost = Integer.MAX_VALUE;  // set up for search of edges
			EdgeNode lowestEdge = null;

			for ( EdgeNode e : currentEdges ) {
				if ( e.getWeight()  <  lowestEdgeCost ) {  // found lower cost edge
					lowestEdge = e;
					lowestEdgeCost = e.getWeight();
				}
			}

			System.out.println(lowestEdge.getStartVertex() + "  ----  " + lowestEdge.getAdjacentVertex( ) + "   == "   +  lowestEdge.getWeight());

			totalCost = totalCost + lowestEdge.getWeight();   // add cost of edge to total

			currentEdges.clear();     // empty the currentEdges Set for next time through

			visited.add(lowestEdge.getAdjacentVertex());   // new visited node added to visited set

			unvisited.remove(lowestEdge.getAdjacentVertex());   // remove new node from unvisited

		}  // end unvisited loop

		return  totalCost;   // return cost of MCST

	} // end Prims Algorithm


	public void insert(int x, int y, int w) {  // insert an edge from x to y with weight w
		
		EdgeNode edge = new EdgeNode(x, y, w); // create EdgeNode to add linked list

		if (edgeList[x].getNext()!=null) // insert edge at front of start vertex's linked list
			edge.setNext(edgeList[x].getNext());
		edgeList[x].setNext(edge);

		EdgeNode mirror = new EdgeNode(y, x, w); // since it's an undirected graph, do the same from y to x

		if (edgeList[y].getNext()!=null)
			mirror.setNext(edgeList[y].getNext());
		edgeList[y].setNext(mirror);
	}

	public int  getNumVertices() { //  returns the number of vertices in the graph

		return numVertices;

	}

}
