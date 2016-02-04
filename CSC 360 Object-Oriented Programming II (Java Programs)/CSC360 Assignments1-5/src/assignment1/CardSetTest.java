package assignment1;

/*
File Name: CardSetTest.java 
Author: Corey Shrader
Course: INF 360-002
Date: 1/22/15
 */

import static org.junit.Assert.*;
import org.junit.Test;


public class CardSetTest {

	@Test
	public void test() {
		CardSet set = new CardSet(0);
		System.out.println("huh");
		
		// Test empty -- nothing should crash
		set.print(); 
		assertEquals("Get High Rank", -1, set.findHighRank());
		assertEquals("Get Low Rank", -1, set.findLowRank());
		assertEquals("Find High Pair Rank", -1, set.findHighPairRank());
		assertEquals("Flush?", false, set.isFlush());
		
		
		set = new CardSet(5);
		
		// Tests must run
		Card c1 = new Card(Card.ACE, Card.CLUBS);
		Card c2 = new Card(Card.ACE, Card.DIAMONDS);
		Card c3 = new Card(2, Card.CLUBS);
		

		
		set.add(c1);
		set.add(c2);
		set.add(c3);
		
		// Make sure card isn't already in hand! ************ // 
		Card c4, c5;
		do {
			 c4 = Card.makeRandomCard();
		} while (set.cardInHand(c4));
		
		set.add(c4);
		
		do {
			 c5 = Card.makeRandomCard();
		} while (set.cardInHand(c5));
				
		set.add(c5);
		
		assertEquals("Get High Rank", 14, set.findHighRank());
		
		assertEquals("Get Low Rank", 2, set.findLowRank());
		assertEquals("Find High Pair Rank", 14, set.findHighPairRank());
		assertEquals("Has a pair", true, set.containsPair());
		assertEquals("Flush?", false, set.isFlush());
		
		// Test flush
	
		//set.print();
		assertEquals("Count", 5, set.count());
		set.discard(1);
		assertEquals("Count", 4, set.count());
		set.discard(2);
		set.discard(3);
		set.discard(4);
		set.discard(0);
		assertEquals("Count", 0, set.count());
		
		//set.print();
		set.add(new Card(Card.ACE, Card.HEARTS));
		set.add(new Card(Card.KING, Card.HEARTS));
		set.add(new Card(Card.QUEEN, Card.HEARTS));
		set.add(new Card(Card.JACK, Card.HEARTS));
		set.add(new Card(10, Card.HEARTS));
		//set.print();
		assertEquals("Count", 5, set.count());
		assertEquals("Get High Rank", 14, set.findHighRank());
		assertEquals("Get Low Rank", 10, set.findLowRank());
		assertEquals("Find High Pair Rank", -1, set.findHighPairRank());
		assertEquals("Has a pair", false, set.containsPair());
		assertEquals("Flush?", true, set.isFlush());
		//set.print();
	
	    /* Add this tests later 
	     *   This test error conditions and constraints
	     * 
	     */
		
		// test can't add more cards than card slots
		set.add(Card.makeRandomCard()); // should print an error message
		assertEquals("Test count", 5, set.count());
		
		// make sure you can't add duplicates
		set.discard(4);
		assertEquals("Test count", 4, set.count());
		set.add(new Card(Card.KING, Card.HEARTS)); // should print an error
		assertEquals("Test count", 4, set.count());
		assertEquals("Has pair", false, set.containsPair());
		
		
		// Put your own tests here
		
		set.add(new Card(10, Card.HEARTS));
		//set.print();
		assertEquals("Straight?", true, set.isStraight());
		assertEquals("Straight flush?", true, set.isStraightFlush());
		
		set.discard(4);
		//set.print();
		assertEquals("Straight?", true, set.isStraight());
		assertEquals("Flush?", true, set.isFlush());
		assertEquals("Straight flush?", true, set.isStraightFlush());
		
		set.discard(0);
		//set.print();
		assertEquals("Find high rank", 13, set.findHighRank());
		assertEquals("Find low rank", 11, set.findLowRank());
		
		set.discard(1);
		//set.print();
		assertEquals("Straight?", true, set.isStraight());
		assertEquals("Flush?", true, set.isFlush());
		assertEquals("Straight flush?", true, set.isStraightFlush());
		
		set.add(new Card(8, Card.CLUBS));
		//set.print();
		assertEquals("Straight?", false, set.isStraight());
		assertEquals("Flush?", false, set.isFlush());
		assertEquals("Straight flush?", false, set.isStraightFlush());
		
		set.add(new Card(9, Card.CLUBS));
		set.add(new Card(10, Card.CLUBS));
		//set.print();
		assertEquals("Straight?", true, set.isStraight());
		assertEquals("Flush?", false, set.isFlush());
		assertEquals("Straight flush?", false, set.isStraightFlush());
	}

}
