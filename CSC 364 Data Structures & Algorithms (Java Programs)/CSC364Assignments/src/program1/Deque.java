package program1;

/*
File Name: Deque.java 
Author: Corey Shrader
Course: CSC 364-001
Date: 9/7/15
 */

public class Deque {

	private DequeNode elts;   // The pointer to the first element in the deque

	public void deque( ) {	// Set elts member to null for empty deque

		elts = null;
	}

	public void insertFront(  int  item ) {
		// Insert the given item (as a node) into the first position of the Deque.

		DequeNode node = new DequeNode(item);

		if (this.isempty()) // Test for empty deque
			elts = node;

		else {
			DequeNode temp = elts;
			elts = node;
			elts.setNext(temp);

			if (temp.getPrev() == null) { // Test for deque with one item
				elts.setPrev(temp);
				temp.setNext(elts);
			}
			else {
				elts.setPrev(temp.getPrev());
				temp.getPrev().setNext(elts);
			}

			temp.setPrev(elts);

		}
	}

	public void insertRear( int item ) {
		// Insert the given item (as a node) into the last position of the Deque.

		DequeNode node = new DequeNode(item);

		if (this.isempty()) // Test for empty deque
			elts = node;

		else {
			node.setNext(elts);

			if (elts.getPrev() == null) { // Test for deque with one item
				node.setPrev(elts);
				elts.setNext(node);
			}

			else {
				DequeNode temp = elts.getPrev();
				node.setPrev(temp);
				temp.setNext(node);
			}
			elts.setPrev(node);
		}
	}

	public int deleteFront( )  {
		// Delete and return the element stored in the first node of the Deque.

		if (!this.isempty()) {
			int val = elts.getVal();

			if (elts.getPrev() == null) // If there's only 1 item, just delete it.
				elts = null;

			else {
				elts.getPrev().setNext(elts.getNext());
				elts.getNext().setPrev(elts.getPrev());
				elts = elts.getNext();
			}

			return val;
		}

		else { 
			System.out.println("Deque is empty! Returning 0...");
			return 0;
		}
	}

	public int deleteRear( ) {
		// Delete and return the element stored in the last node of the Deque.

		if (!this.isempty()) {
			int val;


			if (elts.getPrev() == null) { // If there's only 1 item, just delete it.
				val = elts.getVal();
				elts = null;
				return val;
			}

			else {
				val = elts.getPrev().getVal();
				DequeNode oldRear = elts.getPrev();
				oldRear.getPrev().setNext(elts);
				elts.setPrev(oldRear.getPrev());
				return val;
			}
		}

		else {
			System.out.println("Deque is empty! Returning 0...");
			return 0;
		}
	}

	public boolean isempty( )  {
		// Returns true if the Deque is currently empty or false if it is not.

		return (elts == null);
	}

	public void printDeque( ) {
		// Print the integers from the list, one per line, from the first element through to the last in order.

		if (this.isempty())
			System.out.println("EMPTY DEQUE");
		else {
			DequeNode index = elts;
			System.out.println(elts.getVal());
			if (index.getNext() != null) {
				index = index.getNext();
				while (index != elts) {
					System.out.println(index.getVal());
					index = index.getNext();
				}
			}
		}
	}
}