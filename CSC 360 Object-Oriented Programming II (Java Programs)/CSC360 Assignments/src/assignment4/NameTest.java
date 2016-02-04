package assignment4;

/*
File Name: NameTest.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 3/12/15
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class NameTest {

	@Test
	public void test() {
		Name bob = new Name("Robert", "M" );
		Name robert = new Name("Robert", "M");
		System.out.println(bob);
		System.out.println(robert);
		
		assertEquals( "Are these names the same?", true, bob.equals(robert));
		assertEquals( "What's his name?", "Robert", bob.getName());
		assertEquals( "What's his sex?", "M", bob.getSex());
	}

}
