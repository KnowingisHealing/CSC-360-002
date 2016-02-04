package assignment2;

import org.junit.Test;

/*
File Name: IteratedPrisonerTest.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 2/5/15
 */


public class IteratedPrisonerTest {

	@Test
	public void test() {
	
		double total = 0;
		final int SIMULATIONS = 50; 
		final int ITERATIONS = 100;
		
		System.out.println("I always rat, vary how often my pal rats");
	    for (int i = 0; i < SIMULATIONS; i++){
			IteratedPrisoner foo = new IteratedPrisoner(ITERATIONS,new PrisonerAlwaysRats(), new PrisonerRandomlyRats(i/(double) SIMULATIONS));
			foo.play();
			total += foo.averageJailTime();
		}
		System.out.println("Average jail time: " + total/SIMULATIONS + " years.");
		total = 0;
		
		System.out.println("I never rat, vary how often my pal rats");
		for (int i = 0; i < SIMULATIONS; i++){
			IteratedPrisoner foo = new IteratedPrisoner(ITERATIONS,new PrisonerNeverRats(), new PrisonerRandomlyRats(i/ (double) SIMULATIONS));
			foo.play();
			total += foo.averageJailTime();
			
		}
		System.out.println("Average jail time: " + total/SIMULATIONS + " years.");
		total = 0;
		
		// TODO Auto-generated constructor stub
		System.out.println("I rat half the time");
		final double RAT_HALF = 0.50;
		for (int i = 0; i < SIMULATIONS; i++){
			IteratedPrisoner foo = new IteratedPrisoner(ITERATIONS,new PrisonerRandomlyRats(RAT_HALF), 
					new PrisonerRandomlyRats(i/(double) SIMULATIONS));
	
			foo.play();
			total += foo.averageJailTime();
		}
		System.out.println("Average jail time: " + total/SIMULATIONS);
		total = 0;
		
		System.out.println("I change my decision based on my partner's last decision");
	    int score = 0;
		for (int i = 0; i < SIMULATIONS; i++){
			PrisonerChangeDecision changeling = new PrisonerChangeDecision(score);
			IteratedPrisoner foo = new IteratedPrisoner(ITERATIONS, changeling, new PrisonerRandomlyRats(i/(double) SIMULATIONS));
			foo.play();
			total += foo.averageJailTime();
			score = changeling.getScore();
		}
		System.out.println("Average jail time: " + total/SIMULATIONS + " years.");
		total = 0;
		
		
	}

}