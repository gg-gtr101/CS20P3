/*
Program: DiceRollGame.java          Last Date of this Revision: December 8, 2025

Purpose: Dice Roll is a betting game starting with 1000 points. The player risks points and guesses if the roll of two dice will be
         "High" (8-12) or "Low" (2-6). If correct, the risked points are doubled and added to the score. If incorrect, or if the
         total is 7 (neither High nor Low), the risked points are lost.

Author: Gurshan Gaur, 
School: CHHS
Course: Computer Programming 20
*/

package Mastery;

import java.util.Scanner;

// The main application class for the Dice Roll game.
// Handles user input/output (I/O) and manages the game loop.
public class DiceRollGame 
{
	
	public static void main(String[] args) 
	{
		// Initialize the Scanner to read input from the console.
		Scanner input = new Scanner (System.in);
		// Create a new DRPlayer object to track the game state and score.
		DRPlayer player = new DRPlayer();
		
		// Display the player's initial score.
		System.out.println("You have " + player.getPts() + " points.");
		
		// Start the main game loop, which continues until broken.
		while (true)
		{
			// Prompt the user for the amount they want to wager (risk).
			System.out.print("How many points do you want to risk? (-1 to quit): ");
			int risk = input.nextInt();
			
			// Check for the user's explicit quit command.
			if (risk == -1)
			{
				break; // Exit the game loop.
			}
			
			// Input validation: Cannot risk more points than currently owned.
			if (risk > player.getPts())
			{
				System.out.println("You cannot risk more points than you have!");
				continue; // Skip the rest of the loop and prompt again.
			}
			
			// Input validation: Ensure risk is not a negative value (excluding -1 quit code).
			if (risk < 0)
			{
				System.out.println("Risk cannot be negative.");
				continue; // Skip the rest of the loop and prompt again.
			}
			
			// Prompt the user to make their High (1) or Low (0) call.
			System.out.print("Make a call (0 for low, 1 for high): ");
			int choice = input.nextInt();
			
			// Input validation: Must choose 0 or 1.
			if (choice != 0 && choice != 1)
			{
				System.out.println("Invalid choice. Please enter 0 or 1.");
				continue; // Skip the rest of the loop and prompt again.
			}
			
			// Execute the game round logic and get the dice total.
			int rollTotal = player.playRound(risk, choice);
			
			// Display the result of the roll and the new score.
			System.out.println("You have rolled: " + rollTotal);
			System.out.println("You now have: " + player.getPts() + " points.");

			// Check if the player has run out of points (game over condition).
			if (player.getPts() < 0) // Used <= 0 to be safe, though a loss should only reduce the score to 0 or below.
			{
				System.out.println("You have run out of points! Game Over.");
				break; // Exit the game loop.
			}
		}
		
		// Code executed after the game loop breaks (user quit or ran out of points).
		System.out.println("--------------------------------");
		System.out.println("Thanks for playing!");
		System.out.println("Final Score: " + player.getPts());
	}

}

/*
You have 1000 points.
How many points do you want to risk? (-1 to quit): 1000
Make a call (0 for low, 1 for high): 1
You have rolled: 8
You now have: 3000 points.
How many points do you want to risk? (-1 to quit): 1000
Make a call (0 for low, 1 for high): 1
You have rolled: 8
You now have: 5000 points.
How many points do you want to risk? (-1 to quit): -1
--------------------------------
Thanks for playing!
Final Score: 5000
*/