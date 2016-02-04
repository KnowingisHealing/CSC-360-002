package assignment3;

/*
File Name: ChangeMachine.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 2/12/15
 */

public abstract class ChangeMachine {

	protected int quarters;
	protected int dimes;
	protected int nickels;
	protected int pennies;
	protected long startTime;
	protected long stopTime;
	public final int QUARTER = 25;
	public final int DIME = 10;
	public final int NICKEL = 5;
	public final int PENNY = 1;
	
	public ChangeMachine() {
		
	}
	
	public abstract void computeCoins(int change);
	
	public void setStartTime(long time) {
		startTime = time;
	}
	
	public void setStopTime(long time) {
		stopTime = time;
	}
	
	public long getRunTime() {
		return stopTime - startTime;
	}
	
	public String toString() {
		// Returns the current count of each coin

		return "Your change is " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, and " + pennies + " pennies.";
	}
	
	public boolean equals(Object o) {
		// Checks for equality in the number of coins of each machine
		
		return (((ChangeMachine)o).quarters == this.quarters
				&& ((ChangeMachine)o).dimes == this.dimes
				&& ((ChangeMachine)o).nickels == this.nickels
				&& ((ChangeMachine)o).pennies == this.pennies);
	}
	
	public int getQuarters() {
		return quarters;
	}
	
	public int getDimes() {
		return dimes;
	}
	
	public int getNickels() {
		return nickels;
	}
	
	public int getPennies() {
		return pennies;
	}
	
	protected void resetCount() {
		pennies = 0;
		nickels = 0;
		dimes = 0;
		quarters = 0;
	}
}
