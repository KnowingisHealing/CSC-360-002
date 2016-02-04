package assignment1;

/*
File Name: CardSet.java 
Author: Corey Shrader
Course: INF 360-002
Date: 1/22/15
 */

public class CardSet {

	private Card[] hand;
	private final int USER_ACE = 14;
	public final int NO_MATCH = -1;

	public CardSet(int size) {
		// Creates an array (or "hand") of Cards with a given size

		hand = new Card[size];
	}

	public int count() {
		// Returns number of Cards in hand

		int count = 0;
		for (int i=0; i<hand.length; i++) {
			if (hand[i] != null)
				count++;
		}
		return count;
	}

	public boolean cardInHand(Card card) {
		// Returns true if given card exists in hand

		for (int i=0; i<hand.length; i++)
			if (hand[i] != null) {
				if (hand[i].getRank() == card.getRank() && hand[i].getSuit() == card.getSuit())
					return true;
			}
		return false;
	}

	public void add(Card card) {
		// Adds a card to the first null space in hand, as long as the same card isn't already in the hand

		for (int i=0; i<hand.length; i++) {
			if (cardInHand(card)) {
				System.out.println( "You already have that card!");
				return;
			}
			else if (hand[i] == null) {
				hand[i] = card;
				return;
			}
		}
		System.out.println( "Your hand is full!");
	}

	public Card discard(int whichCard) {
		// Nulls the given index of the hand and returns its card

		Card TempCard = hand[whichCard];
		hand[whichCard] = null;
		return TempCard;
	}

	public void print() {
		// Prints a string description of each card in the hand

		for (int i=0; i<hand.length; i++) {
			if (hand[i] != null) {
				System.out.println( hand[i].toString() );
			}
		}
	}

	public int findHighRank() {
		// Returns the rank of the highest card in the hand

		if (isEmpty())
			return NO_MATCH;

		// Start with the first card for comparison to each following card
		int startIndex = 0;
		while (hand[startIndex] == null)
			startIndex++;
		int highRank = hand[startIndex].getRank();

		// If the first card is an ace, we know already it is the highest rank
		if (highRank == Card.ACE)
			return USER_ACE;

		// If the first card is also the last card, we know it's also the highest.
		if (startIndex == hand.length - 1)
			return highRank;

		// Compare the first card to each following card, storing the highest rank
		for (int i = startIndex + 1; i<hand.length; i++) {
			if (hand[i] != null) {
				if (hand[i].getRank() == Card.ACE)
					return USER_ACE;
				else if (hand[i].getRank() > highRank)
					highRank = hand[i].getRank();
			}
		}
		return highRank;
	}

	public int findLowRank() {
		// Returns the rank of the lowest card in the hand

		// Returns -1 if hand is empty
		if (isEmpty())
			return NO_MATCH;

		// Start with the first card for comparison to each following card
		int startIndex = 0;
		while (hand[startIndex] == null) {
			startIndex++;
		}

		// Create variable to store lowest rank
		int lowRank;

		// If first card is an ace, remember to treat its rank as 14 for this method
		if (hand[startIndex].getRank() == Card.ACE) 
			lowRank = USER_ACE;
		else lowRank = hand[startIndex].getRank();

		// If first card is also last card, this is the lowest rank.
		if (startIndex == hand.length - 1)
			return lowRank;

		// Compare each card in hand against starting card
		for (int i=startIndex + 1; i<hand.length; i++) {
			if (hand[i] != null ) {
				if (hand[i].getRank() < lowRank && hand[i].getRank() != Card.ACE)
					lowRank = hand[i].getRank();
			}
		}
		return lowRank;
	}

	public int findHighPairRank() {
		// Returns rank of highest pair in the hand, if it exists

		if (!containsPair() || isEmpty())
			return NO_MATCH;

		// Create an array to store pair ranks
		int[] pairRanks = new int[hand.length];
		for (int i=0; i<hand.length; i++) {
			for (int j=i+1; j<hand.length; j++) {
				if (hand[i] != null && hand[j] != null ) {
					if (hand[i].getRank() == hand[j].getRank())
						pairRanks[i] = hand[i].getRank();
				}
			}
		}

		// Compare each rank to the first, storing the highest
		int highPairRank = pairRanks[0];
		if (pairRanks[0] == Card.ACE)
			return USER_ACE;
		for (int i=1; i<pairRanks.length; i++) {
			if (pairRanks[i] == Card.ACE)
				return USER_ACE;
			if (pairRanks[i] > highPairRank)
				highPairRank = pairRanks[i];
		}
		return highPairRank;
	}

	public boolean containsPair() {
		// Returns true if the hand contains two of the same card

		for (int i=0; i<hand.length; i++) {
			for (int j=i+1; j<hand.length; j++) {
				if (hand[i] != null && hand[j] != null) {
					if (hand[i].getRank() == hand[j].getRank())
						return true;
				}
			}
		}
		return false;
	}

	public boolean isFlush() {
		// Returns true if every card in hand is of same suit

		if (isEmpty())
			return false;

		for (int i=0; i<hand.length; i++) {
			for (int j=i+1; j<hand.length; j++) {
				if (hand[i] != null && hand[j] != null) {
					if (hand[i].getSuit() != hand[j].getSuit())
						return false;
				}
			}
		}
		return true;
	}

	public boolean isStraight() {
		// Returns true if ranks of hand can be sorted into sequential order

		if (isEmpty())
			return false;

		// Create array to store ranks
		int[] handRanks = new int[this.count()];
		int nullCounter = 0;
		for (int i=0; i<hand.length; i++) {
			if (hand[i] == null) {
				nullCounter++;
			}
			else if (hand[i] != null) {
				handRanks[i - nullCounter] = hand[i].getRank();
			}
		}

		//java.util.ArrayList<Integer> handRanks1 = new java.util.ArrayList<>();
		//for (int i=0; i<hand.length; i++) {
		//if (hand[i] != null) {
		//handRanks1.add(hand[i].getRank());
		//}
		//}

		// Sort ranks
		java.util.Arrays.sort(handRanks);

		// Ace can be 1 or 14. If the last card is a King, the ace's rank should be considered 14 and the array should be re-sorted.
		if (handRanks[0] == Card.ACE && handRanks[handRanks.length - 1] == Card.KING) {
			handRanks[0] = USER_ACE;
			java.util.Arrays.sort(handRanks);
		}

		// Compare each rank to the next to check for sequential order
		for (int i=1; i<handRanks.length; i++) {
			if (handRanks[i] != handRanks[i-1] + 1)
				return false;
		}
		return true;
	}

	public boolean isStraightFlush() {
		// Returns true if hand is both a straight and a flush

		return (isFlush() && isStraight());
	}

	private boolean isEmpty() {
		// Returns true if there are no cards in hand

		for (int i=0; i<hand.length; i++) {
			if (hand[i] != null)
				return false;
		}
		return true;
	}

}
