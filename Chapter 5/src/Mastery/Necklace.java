package Mastery;

import java.util.Scanner;

public class Necklace 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);

        System.out.print("Enter the first starting number (0-9): ");
        int startNum1 = getSingleDigitInput(input);

        System.out.print("Enter the second starting number (0-9): ");
        int startNum2 = getSingleDigitInput(input);

        int currentNum1 = startNum1;
        int currentNum2 = startNum2;
        int nextNum;
        int steps = 0;

        String sequence = startNum1 + " " + startNum2;

        System.out.println("\nGenerating the necklace sequence...");

        do 
        {
            nextNum = (currentNum1 + currentNum2) % 10;
            
            sequence += " " + nextNum;
            
            currentNum1 = currentNum2;
            currentNum2 = nextNum;

            steps++;

        } while (currentNum1 != startNum1 || currentNum2 != startNum2);

        System.out.println("---");
        System.out.println("Sequence: " + sequence);
        System.out.println("Steps taken to close the necklace: " + steps);
        System.out.println("---");
        
    }
    
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

