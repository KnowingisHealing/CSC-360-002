package program2;

/*
File Name: BSTNode.java 
Author: Corey Shrader
Course: CSC 364-001
Date: 9/22/15
 */

public class BSTNode {

	protected  int   val;    //  contains the integer value of the node
	protected BSTNode  left;   // holds the reference to the left child of the node or null if none
	protected BSTNode right;  // holds the reference to the right child of the node or null if none
	protected int  level;            //  holds the level in the BST that this node is inserted into

	public BSTNode( int v , int lev ) {
		val = v;
		level = lev;
		left = null;
		right = null;
	}

	public BSTNode getLeft() {
		return left;
	}

	public BSTNode getRight() {
		return right;
	}

	public int getVal() {
		return val;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public int getLev() {
		return level;
	}

	public void setLev(int lev) {
		level = lev;
	}

	public void  add(  int val,  int lev ) {
		// this method adds a BSTnode to its correct position in the BST.
		
		if ( this.getVal( ) > val )   //  need to go left val is less then current node’s value
		{
			if ( this.getLeft( ) == null ) {
				// create new bstNode with val and lev and assign into left child member
				this.setLeft(new BSTNode(val, lev));
			}
			else  {
				// make recursive call on LEFT child with val and (lev + 1)
				this.getLeft().add(val, lev+1);
			}
		}
		else  {     //  val must be great then current node’s value
			if ( this.getRight( ) == null ) {
				// create new bstNode with val and lev and assign into right child member
				this.setRight(new BSTNode(val,lev));
			}
			else  {
				// make recursive call on RIGHT child with val and (lev + 1)
				this.getRight().add(val, lev+1);
			}
		}

	}

	public void inorder( ) {
		// a recursive method in which a node visits its left child first, then itself, then its right child.
		
		if (left != null)
			left.inorder();

		System.out.println(val);

		if (right != null)
			right.inorder();

		return;

	}

}
