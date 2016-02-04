package assignment3;

/*
File Name: TailRecursionSolution.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 2/12/15
 */

public class TailRecursionSolution extends ChangeMachine {

	public TailRecursionSolution() {
		
	}
	
	public void computeCoins(int change) {
		// Calculates the number of each coin using tail recursion
		
		if (change == 0)
			return;
		if (change >= PENNY)
			if (change >= NICKEL)
				if (change >= DIME)
					if (change >= QUARTER) {
						quarters += change / QUARTER;
						change -= QUARTER * quarters;
					}
					else {
						dimes += change / DIME;
						change -= DIME * dimes;
					}
				else {
					nickels += change / NICKEL;
					change -= NICKEL * nickels;
				}
			else {
				pennies += change / PENNY;
				change -= PENNY * pennies;
			}
		computeCoins(change);
	}
	
	public String toString() {
		// Returns the current count of each coin

		return "Your change is " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, and " + pennies + " pennies.";
	}

}
