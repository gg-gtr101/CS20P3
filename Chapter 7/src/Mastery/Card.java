package Mastery;

//Represents a single playing card used in the Game of 21.
//This class stores the card's rank and provides methods to determine its display name and its score value.

public class Card 
{
	// Private attribute to store the card's rank (1 for Ace, 2-10, 11-13 for faces).
	private int rank;
	
	// Constructor for Card Class
	public Card(int r)
	{
		// Initialize the card's rank.
		rank = r;
	}
	
	// Returns the integer rank of the card
	public int getRank() 
	{
		return rank;
	}

	// Returns the common display name for the card's rank.
	// Converts ranks 1, 11, 12, and 13 to "Ace", "Jack", "Queen", and "King", respectively.
	public String getDisplayName()
	{
		if (rank == 1) return "Ace";
		if (rank == 11) return "Jack";
		if (rank == 12) return "Queen";
		if (rank == 13) return "King";
		// For ranks 2 through 10, the display name is just the number as a String.
		return String.valueOf(rank);
	}
	
	// Returns the score value of the card in the Game of 21.
	// Face cards (Jack, Queen, King) are worth 10. Ace is initially 11.
	// Note: The Hand class handles the logic to change Ace from 11 to 1 if needed.
	public int getValue()
	{
		// Ace is typically 11 by default, and adjusted later.
		if (rank == 11) return 11;
		
		// Ranks 11 (Jack), 12 (Queen), and 13 (King) are worth 10.
		if (rank >= 11) return 10;
		
		// Numerical cards 2-10 are worth their rank value.
		return rank;
	}
}
