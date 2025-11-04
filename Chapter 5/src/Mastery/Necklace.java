/*
Program: Necklace.java          Last Date of this Revision: November 3, 2015

Purpose:  A Necklace application that prompts the user for two single-digit integers and then displays the sequence and the steps taken.

Author: Gurshan Gaur, 
School: CHHS
Course: Computer Programming 20
*/

package Mastery;

import java.util.Scanner;

public class Necklace 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		// Prompt the user for the first starting digit and validate the input
        System.out.print("Enter the first starting number (0-9): ");
        int startNum1 = getSingleDigitInput(input);

        // Prompt the user for the second starting digit and validate the input
        System.out.print("Enter the second starting number (0-9): ");
        int startNum2 = getSingleDigitInput(input);

        // Initialize the first two numbers of the current pair with the starting numbers
        int currentNum1 = startNum1;
        int currentNum2 = startNum2;
        int nextNum; // Variable to hold the next number in the sequence
        int steps = 0; // Counter for the number of steps/elements generated

        // Initialize the sequence string with the starting two numbers
        String sequence = startNum1 + " " + startNum2;
        
        System.out.println("\nGenerating the necklace sequence...");

        // Start the do-while loop to generate the necklace sequence
        do 
        {
        	// Calculate the next number: sum of the current pair, modulo 10
            // This ensures the result is always a single digit (0-9)
            nextNum = (currentNum1 + currentNum2) % 10;
            
            // Append the new number to the sequence string
            sequence += " " + nextNum;
            
            // Shift the current numbers: 
            // The second number becomes the first number for the next pair
            currentNum1 = currentNum2;
            
            // The newly calculated 'nextNum' becomes the second number for the next pair
            currentNum2 = nextNum;

            // Increment the step counter (counting the number of *new* elements added)
            steps++;

        // The loop continues until the current pair (currentNum1, currentNum2)
        // matches the original starting pair (startNum1, startNum2)
        // This is what 'closes' the necklace/sequence loop
        } while (currentNum1 != startNum1 || currentNum2 != startNum2);

        // Output the results
        System.out.println("---");
        System.out.println("Sequence: " + sequence);
        System.out.println("Steps taken to close the necklace: " + steps);
        System.out.println("---");
        
    }
    
	// Private helper method to ensure the user enters a single-digit integer (0-9)
	private static int getSingleDigitInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num >= 0 && num <= 9) {
                    return num; 
                } else {
                    System.out.print("Invalid input. Please enter a single-digit number (0-9): ");
                }
            } else {
                String badInput = scanner.next(); 
                
                System.out.println("Invalid input '" + badInput + "'."); 
                
                System.out.print("Please enter an integer (0-9): ");
            }
        }
    }
}

/*
Enter the first starting number (0-9): 5
Enter the second starting number (0-9): 6

Generating the necklace sequence...
---
Sequence: 5 6 1 7 8 5 3 8 1 9 0 9 9 8 7 5 2 7 9 6 5 1 6 7 3 0 3 3 6 9 5 4 9 3 2 5 7 2 9 1 0 1 1 2 3 5 8 3 1 4 5 9 4 3 7 0 7 7 4 1 5 6
Steps taken to close the necklace: 60
---
 */

