package assignment2;

/*
File Name: PrisonerChangeDecision.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 2/5/15
 */

public class PrisonerChangeDecision extends Prisoner {
	
	// Keeps track of the number of years in jail this prisoner gets after each iteration
	private int score = 0;
	
	public PrisonerChangeDecision(int score) {
		this.score = score;
	}
	
	public boolean getDecision() {
		// Returns true if his partner ratted on him before
		return (score == 4 || score == 6);
	}

	public int notifyOutcome(int score) {
		// Returns the number of years this prisoner gets in jail
		this.score = score;
		return score;
	}
	
	public int getScore() {
		return score;
	}
	
}
