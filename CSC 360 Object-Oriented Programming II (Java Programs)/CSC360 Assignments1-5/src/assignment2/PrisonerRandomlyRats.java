package assignment2;

/*
File Name: PrisonerRandomlyRats.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 2/5/15
 */

public class PrisonerRandomlyRats extends Prisoner {
	
	private double percentage;
	
	PrisonerRandomlyRats() {
		percentage = 0.50;
	}
	
	PrisonerRandomlyRats(double percentage) {
		this.percentage = percentage;
	}
	
	public boolean getDecision() {
		// Generates a random number and returns true if that number is less than or equal to the prisoner's percentage
		return (Math.random() <= percentage);
	}

	public int notifyOutcome(int score) {
		// Returns the number of years this prisoner gets in jail
		return score;
	}

}
