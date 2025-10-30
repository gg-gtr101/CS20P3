package Mastery;

import java.util.Scanner;


public class NecklaceV2 
{

	    public static void main(String[] args) {
	        // Create a Scanner object for user input
	        Scanner scanner = new Scanner(System.in);

	        // --- Get User Input ---
	        System.out.print("Enter the first starting number (0-9): ");
	        int startNum1 = getSingleDigitInput(scanner);

	        System.out.print("Enter the second starting number (0-9): ");
	        int startNum2 = getSingleDigitInput(scanner);

	        int currentNum1 = startNum1;
	        int currentNum2 = startNum2;
	        int nextNum;
	        int steps = 0;

	        StringBuilder sequence = new StringBuilder();
	        sequence.append(startNum1).append(" ").append(startNum2);

	        System.out.println("\nGenerating the necklace sequence...");

	        do {
	            nextNum = (currentNum1 + currentNum2) % 10;
	            
	            sequence.append(" ").append(nextNum);
	            
	            currentNum1 = currentNum2;
	            currentNum2 = nextNum;

	            steps++;

	            // 5. Check if the necklace has closed (returned to the starting pair)
	        } while (currentNum1 != startNum1 || currentNum2 != startNum2);

	        // --- Display Results ---
	        System.out.println("---");
	        System.out.println("Sequence: " + sequence.toString());
	        System.out.println("Steps taken to close the necklace: " + steps);
	        System.out.println("---");
	        
	        scanner.close();
	    }
	    
	    /**
	     * Helper function to ensure the user enters a single-digit integer (0-9).
	     */
	    private static int getSingleDigitInput(Scanner scanner) {
	        while (true) {
	            if (scanner.hasNextInt()) {
	                int num = scanner.nextInt();
	                if (num >= 0 && num <= 9) {
	                    return num; // Valid single-digit number
	                } else {
	                    System.out.print("Invalid input. Please enter a single-digit number (0-9): ");
	                }
	            } else {
	                // Consume the invalid token (non-integer) and prompt again
	                String badInput = scanner.next(); 
	                System.out.print("Invalid input '" + badInput + "'. Please enter an integer (0-9): ");
	            }
	        }
	    }
	}


