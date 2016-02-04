package assignment2;

/*
File Name: PrisonerNeverRats.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 2/5/15
 */

public class PrisonerNeverRats extends Prisoner {
	
	public boolean getDecision() {
		// This prisoner never rats, so its decision will always be "false"
		return false;
	}

	public int notifyOutcome(int score) {
		// Returns the number of years this prisoner gets in jail
		return score;
	}

}
