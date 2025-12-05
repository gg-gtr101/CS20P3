package Mastery;

//Represents a hand of playing cards held by a player or the computer.
//It manages adding cards, displaying the hand, and calculating the score.

public class Hand
{
	// Array to store the Card objects. Size 5 is used to safely accommodate the maximum of 3 cards required by the game rules.
	private Card[] cards;
	
	// Tracks the current number of cards in the hand.
	private int cardCount;

	// Constructor initializes the array and sets the card count to zero.
	public Hand()
	{
		cards = new Card[6];
		cardCount = 0;
	}
	
	//Adds a single card to the hand, provided the hand is not full.
	public void addCard(Card c)
	{
		// Check to prevent an Array Index Out Of Bounds exception.
		if (cardCount < cards.length)
		{
			cards[cardCount] = c;
			cardCount++;
		}
	}
	
	// Generates a formatted string showing all cards in the hand (e.g., "[5, Queen, Ace]").
	public String getHandString()
	{
		String display = "[";
		// Loop through only the cards that have been added (up to cardCount).
		for (int i = 0; i < cardCount; i++)
		{
			display += cards[i].getDisplayName();
			// Add a comma and space only between cards, not after the last card.
			if (i < cardCount - 1)
			{
				display += ", ";
			}
		}
		display += "]";
		return display;
	}
	
	// Calculates the total score of the hand, applying the special Ace rule.
	public int calculateScore()
	{
		int sum = 0;
		int aceCount = 0;
		
		// First pass: sum up the values, counting Aces (which are initially counted as 11).
		for (int i = 0; i < cardCount; i++)
		{
			Card c = cards[i];
			int val = c.getValue();
			sum += val;
			// Check for an Ace (rank 1) to track how many we have.
			if (c.getRank() == 1)
			{
				aceCount++;
			}
		}
		
		// Second pass (Ace Adjustment): Reduce 11-point Aces to 1-point Aces as long as the total sum is over 21 and there are still Aces left to reduce.

		while (sum > 21 && aceCount > 0)
		{
			sum -= 10; // Change 11 value to 1 (a reduction of 10).
			aceCount--; // Decrement the count of Aces used for adjustment.
		}
		
		return sum;
	}
}
