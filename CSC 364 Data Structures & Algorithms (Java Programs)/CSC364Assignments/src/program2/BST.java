package program2;

/*
File Name: BST.java 
Author: Corey Shrader
Course: CSC 364-001
Date: 9/22/15
 */

public class BST {

	protected BSTNode root;

	public  BST( ) {
		// takes no parameters and initializes the root member to null.  

		root = null;

	}


	public void insert(  int  val )  {
		// inserts the value into the tree, calling root's recursive "add" method if not empty
		
		if (root == null) 
			root = new BSTNode(val, 1);
		else 
			root.add(val, 2);
	}


	public void levelorder( )  {
		// traverses the tree in level order, which prints each level of values on one line.
		
		if ( root == null )
			System.out.println("EMPTY BST");
		else {
			Deque d = new Deque();
			d.insertRear(root);
			int lev = 1;
			while (!d.isempty()) {
				BSTNode temp = d.deleteFront();
				if (temp.getLeft() != null)
					d.insertRear(temp.getLeft());
				if (temp.getRight() != null)
					d.insertRear(temp.getRight());
				if (temp.getLev() == lev)
					System.out.print(temp.getVal() + "  ");
				if (temp.getLev() > lev) {
					lev = temp.getLev();
					System.out.print("\n" + temp.getVal() + "  ");
				}
			}

		}

	}

	public void inorder ( )  {
		// calls the inorder method if the tree is not empty
		
		if ( root == null )
			System.out.println("EMPTY BST");
		else
			root.inorder( );

	}

}
