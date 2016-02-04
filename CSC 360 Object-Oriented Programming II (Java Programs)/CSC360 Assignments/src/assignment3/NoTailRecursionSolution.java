package assignment3;

/*
File Name: NoTailRecursionSolution.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 2/12/15
 */

public class NoTailRecursionSolution extends ChangeMachine {

	public NoTailRecursionSolution() {
		
	}
	
	public void computeCoins(int change) {
		// Calculates the number of each coin using recursion
		
		if (change == 0)
			return;
		if (change >= QUARTER) {
			computeCoins(change % QUARTER);
			quarters += change / QUARTER;
			return;
		}
		if (change >= DIME) {
			computeCoins(change % DIME);
			dimes += change / DIME;
			return;
		}
		if (change >= NICKEL) {
			computeCoins(change % NICKEL);
			nickels += change / NICKEL;
			return;
		}
		if (change >= PENNY) {
			computeCoins(change % PENNY);
			pennies += change / PENNY;
			return;
		}

	}
	
	public String toString() {
		// Returns the current count of each coin

		return "Your change is " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, and " + pennies + " pennies.";
	}

}