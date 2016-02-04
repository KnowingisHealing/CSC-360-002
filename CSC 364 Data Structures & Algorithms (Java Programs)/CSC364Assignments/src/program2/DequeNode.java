package program2;

/*
File Name: DequeNode.java 
Author: Corey Shrader
Course: CSC 364-001
Date: 9/22/15
 */

public class DequeNode {

	protected DequeNode  next;   // Next pointer to next node
	protected DequeNode prev;   // Previous pointer to previous node
	protected  BSTNode  treeNode;           //  The BSTNode value stored within the dequeNode.


	public DequeNode() {
	}

	public DequeNode(BSTNode treeNode) {
		this.treeNode = treeNode;
	}

	public  DequeNode getNext( ) {	// Return the next field of the current dequeNode.
		return next;
	}
	public DequeNode getPrev( ) {	// Return the prev field of the current dequeNode.
		return prev;
	}
	public void setNext(  DequeNode n ) {	// Set the next field of the current dequeNode to n.
		next = n;
	}
	public void setPrev( DequeNode p ) {	// Set the prev field of the current dequenode to p.
		prev = p;
	}
	public BSTNode getTreeNode( )  {	// Simply returns the BSTNode value stored in the treeNode field.
		return treeNode;
	}
}
