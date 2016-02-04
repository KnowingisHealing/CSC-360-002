package assignment3;

/*
File Name: ChangeMachineTest.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 2/12/15
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class ChangeMachineTest {

	@Test
	public void testChangeMachine() {
		
		LoopSolution loop = new LoopSolution();
		ModSolution mod = new ModSolution();
		NoTailRecursionSolution noTail = new NoTailRecursionSolution();
		TailRecursionSolution tail = new TailRecursionSolution();
		
		loop.computeCoins(344);
		mod.computeCoins(344);
		noTail.computeCoins(344);
		tail.computeCoins(344);
		
		assertEquals("Do the machines give the same change?", true, loop.equals(mod));
		assertEquals("Do the machines give the same change?", true, loop.equals(noTail));
		assertEquals("Do the machines give the same change?", true, loop.equals(tail));
		
		loop.setStartTime(1);
		loop.setStopTime(10);
		assertEquals("What is the run time?", 9, loop.getRunTime());

	}
	
	@Test
	public void testLoopSolution() {

		LoopSolution test = new LoopSolution();

		System.out.println(test.toString());
		test.computeCoins(1);
		assertEquals("1 penny", 1, test.getPennies() );
		System.out.println(test.toString());
		test.resetCount();

		System.out.println(test.toString());
		test.computeCoins(7);
		assertEquals("1 nickel", 1, test.getNickels() );
		System.out.println(test.toString());
		test.resetCount();

		System.out.println(test.toString());
		test.computeCoins(11);
		assertEquals("1 dime", 1, test.getDimes() );
		System.out.println(test.toString());
		test.resetCount();

		System.out.println(test.toString());
		test.computeCoins(29);
		assertEquals("1 quarter", 1, test.getQuarters() );
		System.out.println(test.toString());
		test.resetCount();

		System.out.println(test.toString());
		test.computeCoins(93);
		assertEquals("3 quarters", 3, test.getQuarters() );
		assertEquals("1 dime", 1, test.getDimes() );
		assertEquals("1 nickel", 1, test.getNickels() );
		assertEquals("3 pennies", 3, test.getPennies() );
		System.out.println(test.toString());
		test.resetCount();
	}
	
	@Test
	public void testModSolution() {

		ModSolution test = new ModSolution();

		System.out.println(test.toString());
		test.computeCoins(1);
		assertEquals("1 penny", 1, test.getPennies() );
		System.out.println(test.toString());
		test.resetCount();

		System.out.println(test.toString());
		test.computeCoins(7);
		assertEquals("1 nickel", 1, test.getNickels() );
		System.out.println(test.toString());
		test.resetCount();

		System.out.println(test.toString());
		test.computeCoins(11);
		assertEquals("1 dime", 1, test.getDimes() );
		System.out.println(test.toString());
		test.resetCount();

		System.out.println(test.toString());
		test.computeCoins(29);
		assertEquals("1 quarter", 1, test.getQuarters() );
		System.out.println(test.toString());
		test.resetCount();

		System.out.println(test.toString());
		test.computeCoins(93);
		assertEquals("3 quarters", 3, test.getQuarters() );
		assertEquals("1 dime", 1, test.getDimes() );
		assertEquals("1 nickel", 1, test.getNickels() );
		assertEquals("3 pennies", 3, test.getPennies() );
		System.out.println(test.toString());
		test.resetCount();
	}

	@Test
	public void testNoTailRecursionSolution() {

		NoTailRecursionSolution test = new NoTailRecursionSolution();

		System.out.println(test.toString());
		test.computeCoins(1);
		assertEquals("1 penny", 1, test.getPennies() );
		System.out.println(test.toString());
		test.resetCount();

		System.out.println(test.toString());
		test.computeCoins(7);
		assertEquals("1 nickel", 1, test.getNickels() );
		System.out.println(test.toString());
		test.resetCount();

		System.out.println(test.toString());
		test.computeCoins(11);
		assertEquals("1 dime", 1, test.getDimes() );
		System.out.println(test.toString());
		test.resetCount();

		System.out.println(test.toString());
		test.computeCoins(29);
		assertEquals("1 quarter", 1, test.getQuarters() );
		System.out.println(test.toString());
		test.resetCount();

		System.out.println(test.toString());
		test.computeCoins(93);
		assertEquals("3 quarters", 3, test.getQuarters() );
		assertEquals("1 dime", 1, test.getDimes() );
		assertEquals("1 nickel", 1, test.getNickels() );
		assertEquals("3 pennies", 3, test.getPennies() );
		System.out.println(test.toString());
		test.resetCount();

	}
	
	@Test
	public void testTailRecursionSolution() {

		TailRecursionSolution test = new TailRecursionSolution();

		System.out.println(test.toString());
		test.computeCoins(1);
		assertEquals("1 penny", 1, test.getPennies() );
		System.out.println(test.toString());
		test.resetCount();

		System.out.println(test.toString());
		test.computeCoins(7);
		assertEquals("1 nickel", 1, test.getNickels() );
		System.out.println(test.toString());
		test.resetCount();

		System.out.println(test.toString());
		test.computeCoins(11);
		assertEquals("1 dime", 1, test.getDimes() );
		System.out.println(test.toString());
		test.resetCount();

		System.out.println(test.toString());
		test.computeCoins(29);
		assertEquals("1 quarter", 1, test.getQuarters() );
		System.out.println(test.toString());
		test.resetCount();

		System.out.println(test.toString());
		test.computeCoins(93);
		assertEquals("3 quarters", 3, test.getQuarters() );
		assertEquals("1 dime", 1, test.getDimes() );
		assertEquals("1 nickel", 1, test.getNickels() );
		assertEquals("3 pennies", 3, test.getPennies() );
		System.out.println(test.toString());
		test.resetCount();
	}

}
