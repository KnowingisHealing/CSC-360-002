package assignment3;

/*
File Name: LoopSolution.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 2/12/15
 */

public class LoopSolution extends ChangeMachine {

	public LoopSolution() {
		
	}
	
	public void computeCoins(int change) {
		// Calculates the number of each coin using while loops
 
		while (change >= QUARTER) {
			quarters++;
			change -= QUARTER;
		}
		while (change >= DIME) {
			dimes++;
			change -= DIME;
		}
		while (change >= NICKEL) {
			nickels++;
			change -= NICKEL;
		}
		while (change >= PENNY) {
			pennies++;
			change -= PENNY;
		}
	}
	
	public String toString() {
		// Returns the current count of each coin
		
		return "Your change is " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, and " + pennies + " pennies.";

	}
}
