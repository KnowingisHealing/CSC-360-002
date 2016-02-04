package assignment1;

/*
File Name: Card.java 
Author: Corey Shrader
Course: INF 360-002
Date: 1/22/15
 */

class Card {
	// constants to make code more readable
	public static final int CLUBS=0, DIAMONDS=1, SPADES=2, HEARTS=3;
	public static final int ACE=1, JACK=11, QUEEN=12, KING=13;

	// fields: rank & suit
	private int rank, suit;

	// constructor--takes rank & suit
	public Card(int rankIn, int suitIn) {
		rank = rankIn;
		suit = suitIn;
	}

	// make a random card
	public static Card makeRandomCard() {
		int rank, suit;
		rank = (int)(Math.random() * 13) + 1;
		suit = (int)(Math.random() * 4);
		return new Card(rank, suit);
	}

	// return an English String describing this card
	public String toString() {
		String rankString, suitString;

		// rank part
		if (rank == ACE) rankString = "Ace";
		else if (rank <= 10) rankString = rank + "";
		else if (rank == JACK) rankString = "Jack";
		else if (rank == QUEEN) rankString = "Queen";
		else if (rank == KING) rankString = "King";
		else rankString = "Unknown Card";

		// suit part
		if (suit == CLUBS) suitString = "Clubs";
		else if (suit == DIAMONDS) suitString = "Diamonds";
		else if (suit == SPADES) suitString = "Spades";
		else if (suit == HEARTS) suitString = "Hearts";
		else suitString = "Unknown Suit";

		// put them together
		return rankString +" of "+ suitString;
	}

	// accessor for the rank
	public int getRank() {
		return rank;
	}

	// accessor for the suit
	public int getSuit() {
		return suit;
	}

	// takes other Card, returns true if suits & ranks both same
	public boolean equals(Card other) {
		return (rank == other.rank && suit == other.suit);
	}

	// takes other Card, returns true if ranks same
	public boolean hasSameRank(Card other) {
		return (rank == other.rank);
	}

	// takes other Card, returns true if suits same
	public boolean hasSameSuit(Card other) {
		return (suit == other.suit);
	}
}