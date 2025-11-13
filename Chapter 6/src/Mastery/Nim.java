/*
Program: Nim.java          Last Date of this Revision: November 13, 2025

Purpose: To implement the game of Nim, where two players (User and Computer) alternate taking 1, 2, or 3 stones, and the player forced to take the last stone loses.

Author: Gurshan Gaur, 
School: CHHS
Course: Computer Programming 20
*/

package Mastery;

import java.util.Random;
import java.util.Scanner;

public class Nim 
{
	private static int stones;
	private static int MIN_START_STONES = 15;
	private static int MAX_START_STONES = 30;
	private static int MAX_TAKE = 3; // Maximum stones allowed to be taken

	public static void main(String[] args) 
	{
		// Initialize the game
		Random rand = new Random();
		stones = rand.nextInt(MAX_START_STONES - MIN_START_STONES + 1) + MIN_START_STONES;

		Scanner input = new Scanner(System.in);
		boolean userLost = false;

		// Game loop: Continues as long as the user hasn't lost yet
		while (!userLost) 
		{

			// 1. User's Turn: Returns true if the user leaves 0 stones (i.e., the user loses)
			userLost = handleUserTurn(input);
			if (userLost) 
			{
				System.out.println("The computer beats the player!");
				break;
			}

			// 2. Computer's Turn
			handleComputerTurn();

			// Check if the computer leaves 0 stones (i.e., the computer loses)
			if (stones == 0) 
			{
				System.out.println("The player beats the computer!");
				break;
			}
		}
	}

	// Handles the user's turn and updates the stone count.
	// Input The Scanner object for reading user input.
	// True if the user is forced to take the last stone (loses), false otherwise.
	public static boolean handleUserTurn(Scanner input) 
	{
		int userChoice = 0;
		boolean validInput = false;

		do 
		{
			System.out.print("There are " + stones + " stones. How many would you like? ");

			if (input.hasNextInt()) 
			{
				userChoice = input.nextInt();
				if (isValidEntry(userChoice)) 
				{
					validInput = true;
				} else 
				{
					System.out.println("Invalid input. You must take between 1 and " + Math.min(stones, MAX_TAKE) + " stones.");
				}
			} else 
			{
				// Consume the invalid non-integer token without assigning to a variable
				input.next();                
				System.out.println("Invalid input. Please enter a whole number.");
			}
		} while (!validInput);

		stones -= userChoice;

		// Return true if the user's move resulted in 0 stones left
		return stones == 0;
	}

	// Handles the computer's turn: determines the move and updates the stone count.
	public static void handleComputerTurn() 
	{
		// drawStones handles the "cannot take more than are available" logic internally.
		int computerChoice = drawStones(); 
		stones -= computerChoice;
		System.out.println("There are " + stones + " stones. The computer takes " + computerChoice + " stones.");
	}


	// Checks if the user's attempted move is valid according to the game rules.
	public static boolean isValidEntry(int entry) 
	{
		// Must be between 1 and MAX_TAKE (3), AND must not exceed stones remaining.
		return entry >= 1 && entry <= MAX_TAKE && entry <= stones;
	}


	// Generates a random, legal number of stones for the computer to take.
	public static int drawStones() 
	{
		Random rand = new Random();

		// The computer can only take up to the number of stones remaining.
		int maxLegalTake = Math.min(stones, MAX_TAKE);

		// Generate a random number from 1 up to maxLegalTake (inclusive)
		return rand.nextInt(maxLegalTake) + 1;
	}
}

/*

There are 15 stones. How many would you like? 3
There are 11 stones. The computer takes 1 stones.
There are 11 stones. How many would you like? 2
There are 8 stones. The computer takes 1 stones.
There are 8 stones. How many would you like? 2
There are 4 stones. The computer takes 2 stones.
There are 4 stones. How many would you like? 3
There are 0 stones. The computer takes 1 stones.
The player beats the computer!

 */