/*
File Name: HashTable.java 
Author: Corey Shrader
Course: CSC 364-001
Date: 10/27/15
 */

package program4;

public class HashTable {

	private int  tableSize;   // the size of the table
	private String[]  table; // the actual array of Strings
	private final String EMPTY = "####"; // this represents a cell that has been marked empty

	public HashTable(int size) { // creates the open addressing hash table array of strings to the appropriate size
		tableSize = size;
		table = new String[size];
	}

	public int hashFunc(String word) { // adds up the ASCII characters of all characters of the string, mods it by the table size and returns the result
		char ch[] = word.toCharArray();
		int i, sum; 
		for (sum=0, i=0; i < word.length(); i++) 
			sum += ch[i]; 
		return sum % tableSize; 
	}

	public void insert(String word) { // adds the word to its appropriate location in the table
		int location = hashFunc(word);
		if (table[location] == null || table[location] == EMPTY) // if its hash code index is empty, place it there
			table[location] = word;
		else { // otherwise, use quadratic probing to find the next available position in the table
			int i = 1;
			while (table[location] != null && table[location] != EMPTY) {
				location = (location + (i*i)) % tableSize;
				i++;
			}
			table[location] = word;
		}
	}

	public int lookup(String word) {  // this method looks for a given word in the table
		int location = hashFunc(word); // start by looking at its hash code index
		if (table[location] != null && !table[location].equals(word)) { // use quadratic probing if something is there, but is not the word
			int i = 1;
			while (table[location] != null && !table[location].equals(word)) {
				location = (location + (i*i)) % tableSize;
				i++;
			}
		}
		if (table[location] != null && table[location].equals(word)) // if we found the word, return its location
			return location;
		else
			return -1;
	}

	public void markNowEmpty(int position) { // this method will place our empty value “####” into the table at the given position
		table[position] = EMPTY;
	}
}
