package assignment3;

/*
File Name: AlgorithmAnalyzer.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 2/12/15
 */

public class AlgorithmAnalyzer {

	private static final int REPEATS = 10000;
	private static final int MAX_CHANGE = 1000;
	
	public static void main(String[] args) {
		
		// Calculate the average run time for the loop solution
		long totalRunTime = 0;
		LoopSolution loopTest = new LoopSolution();
		for (int i = 1; i <= REPEATS; i++) {
			loopTest.setStartTime(System.nanoTime());
			for (int j = 1; j <= MAX_CHANGE; j++) {
				loopTest.computeCoins(j);
				loopTest.resetCount();
			}
			loopTest.setStopTime(System.nanoTime());
			totalRunTime += loopTest.getRunTime();
			loopTest.resetCount();
		}
		
		System.out.println( "Average run time for loop solution: " + totalRunTime / REPEATS + " nanoseconds.");
		
		// Calculate the average run time for the mod solution
		totalRunTime = 0;
		ModSolution modTest = new ModSolution();
		for (int i = 1; i <= REPEATS; i++) {
			modTest.setStartTime(System.nanoTime());
			for (int j = 1; j <= MAX_CHANGE; j++) {
				modTest.computeCoins(j);
				modTest.resetCount();
			}
			modTest.setStopTime(System.nanoTime());
			totalRunTime += modTest.getRunTime();
			modTest.resetCount();
		}
		System.out.println( "Average run time for mod solution: " + totalRunTime / REPEATS + " nanoseconds.");
		
		// Calculate the average run time for the no tail recursion solution
		totalRunTime = 0;
		NoTailRecursionSolution noTailTest = new NoTailRecursionSolution();
		for (int i = 1; i <= REPEATS; i++) {
			noTailTest.setStartTime(System.nanoTime());
			for (int j = 1; j <= MAX_CHANGE; j++) {
				noTailTest.computeCoins(j);
				noTailTest.resetCount();
			}
			noTailTest.setStopTime(System.nanoTime());
			totalRunTime += noTailTest.getRunTime();
			noTailTest.resetCount();
		}
		System.out.println( "Average run time for no tail recursion solution: " + totalRunTime / REPEATS + " nanoseconds.");
		
		// Calculate the average run time for the tail recursion solution
		totalRunTime = 0;
		TailRecursionSolution tailTest = new TailRecursionSolution();
		for (int i = 1; i <= REPEATS; i++) {
			tailTest.setStartTime(System.nanoTime());
			for (int j = 1; j <= MAX_CHANGE; j++) {
				tailTest.computeCoins(j);
				tailTest.resetCount();
			}
			tailTest.setStopTime(System.nanoTime());
			totalRunTime += tailTest.getRunTime();
			tailTest.resetCount();
		}
		System.out.println( "Average run time for tail recursion solution: " + totalRunTime / REPEATS + " nanoseconds.");
		
	}

}
