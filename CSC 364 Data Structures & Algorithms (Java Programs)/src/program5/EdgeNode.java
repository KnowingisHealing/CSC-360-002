/*
File Name: EdgeNode.java 
Author: Corey Shrader
Course: CSC 364-001
Date: 11/10/15
Description: This class models a node used as an edge in a weighted graph.
 */

package program5;

public class EdgeNode {

	private int startVertex; // starting vertex of edge
	private int  adjacentVertex; // vertex that edge points to from start
	private int  weight;  // the weight/cost associated with the edge
	private EdgeNode next;  // link to the next EdgeNode in the linked list.
	
	public EdgeNode() { // default constructor creates "dummy" node intended for beginning of linked list
		startVertex = 0;
		adjacentVertex = -1;
		weight = 0;
		next = null;
	}
	public EdgeNode(int x, int y, int w)  { // creates an edge from x to y with weight w
		  startVertex = x;
		  adjacentVertex = y;
		  weight = w;
		  next = null;
		}
	public void setNext(EdgeNode next) {
		this.next = next;
	}
	public EdgeNode getNext() {
		return next;
	}
	public void setWeight(int w) {
		weight = w;
	}
	public int getWeight() {
		return weight;
	}
	public void setAdjacentVertex(int y) {
		adjacentVertex = y;
	}
	public int getAdjacentVertex() {
		return adjacentVertex;
	}
	public void setStartVertex(int x) {
		startVertex = x;
	}
	public int getStartVertex() {
		return startVertex;
	}
}