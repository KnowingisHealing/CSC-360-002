/*
File Name: Heap.java 
Author: Corey Shrader
Course: CSC 364-001
Date: 10/5/15
 */

// This class implements a MinHeap, a binary tree with complete levels and each child's value greater than its parent's.

package program3;

public class Heap {

	protected int[] elts;
	protected int count;

	public Heap() { // this heap can have no more than 100 values
		elts = new int[100];
		count = 0;
	}

	public boolean isEmpty() { // returns true if the heap is empty
		return (count==0);
	}
	
	public boolean isFull() {// if count == 100 then there is no more room in the array
		return (count==100);
	}
	
	public int deleteMin()  { // delete and return the element at position 0 of the array

		if (isEmpty()) { // check for an empty heap
			System.out.println("Heap is empty! Returning 0...");
			return 0;
		}

		int min = elts[0]; // to rebuild the heap, begin by inserting the last value into the root position.
		count--;
		elts[0]=0;
		if (!isEmpty()) {
			elts[0] = elts[count];
			elts[count]=0;

		}
		if (count!=1) { // then, move down the heap, swapping the current position with its smallest child if necessary
			int pos = 0;
			while (pos<count/2) { // loop runs until we've reached a leaf node
				int leftChild = pos*2 + 1;
				int rightChild = pos*2 + 2;
				int smallest = leftChild; // first, assume left child is smallest
				if (rightChild < count && elts[rightChild]<elts[leftChild]) // ensure right child exists before comparing
					smallest = rightChild;
				if (elts[pos]>elts[smallest]) { // if smallest child is smaller than parent, swap values and continue
					int temp = elts[pos];
					elts[pos] = elts[smallest];
					elts[smallest] = temp;
					pos = smallest;
				}
				else // if no child is smaller than parent, loop is finished
					break;
			}
		}
		return min;
	}

	public void insert( int val ) { // insert the given integer into the array at the next available position

		// if the Heap is empty, insert the given value at the root
		if (isEmpty()) {
			elts[0] = val;
		}
		else { // if not, we'll need to move the value up the heap until it's in the correct position
			elts[count] = val;
			int pos = count;
			int parent = (pos-1)/2;

			while (pos!=0 && elts[parent]>elts[pos]) { // swap node with parent if parent's value is greater
				int temp = elts[parent];
				elts[parent] = elts[pos];
				elts[pos] = temp;
				pos = parent;
				parent = (pos-1)/2;
			}
		}
		count++;
	}

	public void print() { // print the heap level by level, from left to right

		if (isEmpty())
			System.out.println("EMPTY HEAP");

		for (int i=0;i<count;i++)
			System.out.println(elts[i]);
	}

	public void printSorted() { // print the heap in sorted order using deleteMin

		if (isEmpty())
			System.out.println("EMPTY HEAP");

		while (!isEmpty()) {
			System.out.println(deleteMin());
		}
	}
}
