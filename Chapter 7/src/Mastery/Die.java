package Mastery;

import java.util.Random;


// Represents a single standard six-sided die used in the Dice Roll game.
// It manages the current value and provides a method to simulate a roll.
public class Die 
{
	// Stores the current face value of the die (1-6).
	private int amount;
	// Random object used for generating random numbers during the roll.
	private Random rdm;
	
	// Constructor: Initializes the Die object.
	// Sets the initial face value to 1 and creates a new Random number generator.
	public Die()
	{
		amount = 1;
		rdm = new Random();
	}
	
	// Simulates rolling the die.
	// Generates a random integer between 1 and 6 (inclusive) and updates 'amount'.
	// rdm.nextInt(6) returns 0-5, so adding 1 makes it 1-6.
	public void roll()
	{
		amount = rdm.nextInt(6) + 1;
	}
	
	// Returns the current face value of the die.
	public int getValue() 
	{
		return amount;
	}
}