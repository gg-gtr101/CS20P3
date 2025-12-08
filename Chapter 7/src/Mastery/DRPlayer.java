package Mastery;

// Represents the Dice Roll game player.
// Manages the player's total points and handles the core game logic, including rolling the two dice and updating the score based on the outcome.
public class DRPlayer 
{
	// Player's current total score.
	private int pts;
	// The first Die object.
	private Die die1;
	// The second Die object.
	private Die die2;
	
	// Constructor: Initializes the player with the starting score and two dice.
	public DRPlayer() 
	{
		pts = 1000; // Start with 1000 points as per game rules
		die1 = new Die();
		die2 = new Die();
	}
	
	// Executes one round of the game: rolls the dice, determines win/loss, and updates the player's points.
	// risk   The number of points the player is risking on the round.
	// choice The player's call (0 for low, 1 for high).
	// The total value of the two dice rolled.
	public int playRound(int risk, int choice)
	{
		// 1. Roll both dice and calculate the combined total.
		die1.roll();
		die2.roll();
		int total = die1.getValue() + die2.getValue();
		
		// 2. Determine the outcome category of the roll.
		// 'Low' is 2 through 6 inclusive.
		boolean isLow = (total >= 2 && total <= 6);
		// 'High' is 8 through 12 inclusive.
		boolean isHigh = (total >= 8 && total <= 12);
		
		// 3. Apply game rules to update points.
		if (total == 7)
		{
			// Rule: Total of 7 always results in a loss of points at risk.
			pts -= risk;
		}
	    // Check if player called Low (0) and the roll was Low.
		else if (choice == 0 && isLow)
		{
			// Win: points at risk are doubled and added to the total.
			pts += (risk * 2);
		}
	    // Check if player called High (1) and the roll was High.
		else if (choice == 1 && isHigh)
		{
			// Win: points at risk are doubled and added to the total.
			pts += (risk * 2);
		} 
        // This 'else' covers all wrong calls (e.g., called Low but rolled High, or vice versa).
		else 
		{
			// Loss: player loses the points at risk.
			pts -= risk;
		}
		
		return total;
	}
	
	//Returns the player's current total score.
	public int getPts()
	{
		return pts;
	}
}
