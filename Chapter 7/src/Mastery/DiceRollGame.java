/*
Program: DiceRollGame.java          Last Date of this Revision: December 5, 2025

Purpose: Dice Roll is a betting game starting with 1000 points. The player risks points and guesses if the roll of two dice will be
         "High" (8-12) or "Low" (2-6). If correct, the risked points are doubled and added to the score. If incorrect, or if the
         total is 7 (neither High nor Low), the risked points are lost.

Author: Gurshan Gaur, 
School: CHHS
Course: Computer Programming 20
*/

package Mastery;

import java.util.Scanner;

public class DiceRollGame 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner (System.in);
		DRPlayer player = new DRPlayer();
		
		System.out.println("You have " + player.getPts() + " points.");
		
		while (true)
		{
			System.out.print("How many points do you want to risk? (-1 to quit): ");
			int risk = input.nextInt();
			
			if (risk == -1)
			{
				break;
			}
			
			if (risk > player.getPts())
			{
				System.out.println("You cannot risk more points than you have!");
				continue;
			}
			
			if (risk < 0)
			{
				System.out.println("Risk cannot be negative.");
				continue;
			}
			
			System.out.print("Make a call (0 for low, 1 for high): ");
			int choice = input.nextInt();
			
			if (choice != 0 && choice != 1)
			{
				System.out.println("Invalid choice. Please enter 0 or 1.");
				continue;
			}
			
			int rollTotal = player.playRound(risk, choice);
			
			System.out.println("You have rolled: " + rollTotal);
			System.out.println("You now have: " + player.getPts() + " points.");

			if (player.getPts() < 0)
			{
				System.out.println("You have run out of points! Game Over.");
				break;
			}
		}
		
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