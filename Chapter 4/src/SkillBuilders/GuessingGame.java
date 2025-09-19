package SkillBuilders;
import java.util.Random;
import java.util.Scanner;


public class GuessingGame {

    public static void main(String[] args) {
        // Create a new Scanner object to read user input.
        Scanner input = new Scanner(System.in);
        
        // Create a new Random object to generate a random number.
        Random random = new Random();

        // The number to be guessed is between 1 and 30.
        int numberToGuess = random.nextInt(30) + 1;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 30. Try to guess it!");
        System.out.print("Enter your guess: ");
            
        // Check if the input is a valid integer.
        if (input.hasNextInt()) 
        {
            int guess = input.nextInt();

            if (guess < 1 || guess > 30) 
            {
                System.out.println("Your guess is out of range. The number was " + numberToGuess + ".");
            } else if (guess < numberToGuess) 
            {
                System.out.println("Too low! The correct number was " + numberToGuess + ".");
            } else if (guess > numberToGuess) 
            {
                System.out.println("Too high! The correct number was " + numberToGuess + ".");
            } else 
            {
                System.out.println("Congratulations! You've guessed the correct number: " + numberToGuess);
            }
        } else 
        {
            System.out.println("Invalid input. Please enter a valid number. The number was " + numberToGuess + ".");
        }
    }
}
