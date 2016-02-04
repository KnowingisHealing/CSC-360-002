package assignment2;

/*
File Name: PrisonerAlwaysRats.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 2/5/15
 */

public class PrisonerAlwaysRats extends Prisoner {
	
	public boolean getDecision() {
		// This prisoner always rats, so its decision will always be "true"
		return true;
	}

	public int notifyOutcome(int score) {
		// Returns the number of years this prisoner gets in jail
		return score;
	}

}
