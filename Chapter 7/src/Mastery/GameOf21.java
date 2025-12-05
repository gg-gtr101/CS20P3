/*
Program: GameOf21.java          Last Date of this Revision: December 2, 2025

Purpose: In the Game of 21, a player is dealt two cards from a deck of playing cards and then optionally given a third card. The player closest to 21 points without going over is the winner.

Author: Gurshan Gaur, 
School: CHHS
Course: Computer Programming 20
*/

package Mastery;

import java.util.Random;
import java.util.Scanner;

// Constructor initializes the Scanner and Random objects.
public class GameOf21 
{
	private Scanner input;
	private Random rdm;
	
	public GameOf21()
	{
		input = new Scanner(System.in);
		rdm = new Random();
	}

	// The standard main method, which creates a new game instance and starts it.
	public static void main(String[] args) 
	{
		GameOf21 game = new GameOf21();
		game.start();
	}
	
	// Contains the main loop that allows the user to play multiple rounds.
	public void start() 
	{
		 System.out.println("--- Welcome to the Game of 21 ---");
		 boolean keepPlaying = true;
		 
		 // Loop continues until the user enters 'n' or 'no'.
		 while (keepPlaying) 
		 {
			 playRound(); // Execute one full round of the game.
			 
			 System.out.print("\nPlay another round? (y/n): ");
			 
			 // Read the user's response to continue the game.
			 String userResponse = input.next();
			 
			 // Update loop condition based on user input.
			 if (userResponse.equalsIgnoreCase("n") || userResponse.equalsIgnoreCase("no"))
			 {
				 keepPlaying = false;

			 }
	            
	     }
	        System.out.println("Thanks for playing!");
	 }
	 
	 // Executes a single round of the game, including dealing, player/computer turns, and scoring.
	 private void playRound() 
	 {
		 Hand playerHand = new Hand();
		 Hand computerHand = new Hand();
		 
		 // 1. Initial Deal: Deal two cards to the player and two to the computer.
		 playerHand.addCard(generateCard());
		 playerHand.addCard(generateCard());
		 computerHand.addCard(generateCard());
		 computerHand.addCard(generateCard()); 
		 
		 System.out.println("\n--- New Round ---");
		 System.out.println("Your cards: " + playerHand.getHandString());
		 System.out.println("Your score: " + playerHand.calculateScore());
		 
		 // 2. Player's Turn: Hit or Stay (Only allowed to hit once for a max of 3 cards)
		 int playerScore = playerHand.calculateScore();
		 
		 // Player can only hit if they haven't busted yet.
		 if (playerScore < 21) 
		 {
			 System.out.print("Do you want a third card? (y/n): ");
			 String choice = input.next();
			 
			 if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) 
			 {
				 Card newCard = generateCard();
				 playerHand.addCard(newCard); // Card added and will be reflected in score/hand
				 System.out.println("Dealt: " + newCard.getDisplayName());
			 }
	     }
		 // 3. Computer's Turn: Hit or Stay
		 // The computer plays based on its score.
		 int computerScore = computerHand.calculateScore();
		 
		 // Computer logic: Hit if score is less than 17.
		 if (computerScore < 17) 
		 {
			 Card newCard = generateCard();
			 computerHand.addCard(newCard);
			 System.out.println("Computer takes a card.");
	     }
		 
		 // 4. Final Scores and Winner Announcement
		 // Recalculate scores after all moves (especially important if the player hit).
		 playerScore = playerHand.calculateScore();
		 computerScore = computerHand.calculateScore();

		 System.out.println("\n--- Results ---");
		 System.out.println("Your final hand: " + playerHand.getHandString());
		 System.out.println("Your final score: " + playerScore);
		 
		 // Now that the game is over, the computer reveals its full hand
		 System.out.println("Computer's final hand: " + computerHand.getHandString());
		 System.out.println("Computer's final score: " + computerScore);

		 determineWinner(playerScore, computerScore);
	 }

	 
	 // Compares the final scores and prints the winner of the round.
	 private void determineWinner(int pScore, int cScore) 
	 {
		 // Check for player bust first.
		 if (pScore > 21) 
		 {
			 System.out.println("Result: You busted! Computer wins.");
			 return;
		 }
	   
		 // Check for computer bust second.
		 if (cScore > 21) 
		 {
			 System.out.println("Result: Computer busted! You win!");
			 return;
	     }

		 // If no one busted, compare who is closer to 21.
		 if (pScore > cScore) 
		 {
			 System.out.println("Result: You win!");
	     } else if (cScore > pScore) 
	        {
	    	 System.out.println("Result: Computer wins.");
	        } else 
	        {
	        	System.out.println("Result: It's a tie!");
	        }
	    }
	 
	 // Generates a random card rank and creates a new Card object.
	 private Card generateCard() 
	 {
		 // rdm.nextInt(13) generates 0-12, so adding 1 yields 1-13.
		 int r = rdm.nextInt(13) + 1;
		 return new Card(r);
	 }
}

/*
--- Welcome to the Game of 21 ---

--- New Round ---
Your cards: [7, Ace]
Your score: 8
Do you want a third card? (y/n): y
Dealt: 7

--- Results ---
Your final hand: [7, Ace, 7]
Your final score: 15
Computer's final hand: [10, 10]
Computer's final score: 20
Result: Computer wins.

Play another round? (y/n): y

--- New Round ---
Your cards: [Queen, 5]
Your score: 15
Do you want a third card? (y/n): y
Dealt: 2

--- Results ---
Your final hand: [Queen, 5, 2]
Your final score: 17
Computer's final hand: [10, King]
Computer's final score: 20
Result: Computer wins.

Play another round? (y/n): y

--- New Round ---
Your cards: [7, 8]
Your score: 15
Do you want a third card? (y/n): y
Dealt: 2
Computer takes a card.

--- Results ---
Your final hand: [7, 8, 2]
Your final score: 17
Computer's final hand: [5, 6, Jack]
Computer's final score: 22
Result: Computer busted! You win!

Play another round? (y/n): n
Thanks for playing!
*/