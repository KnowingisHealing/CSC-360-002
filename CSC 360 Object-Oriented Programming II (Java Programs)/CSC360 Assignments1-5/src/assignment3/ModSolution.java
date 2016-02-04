package assignment3;

/*
File Name: ModSolution.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 2/12/15
 */

public class ModSolution extends ChangeMachine {

	public ModSolution() {
		
	}
	
	public void computeCoins(int change) {
		// Calculates the number of each coin using the modulator
		
		quarters = change / QUARTER;
		change = change % QUARTER;
		
		dimes = change / DIME;
		change = change % DIME;
		
		nickels = change / NICKEL;
		change = change % NICKEL;
		
		pennies = change / PENNY;
		change = change % PENNY;

	}

	public String toString() {
		// Returns the current count of each coin

		return "Your change is " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, and " + pennies + " pennies.";
	}
}
