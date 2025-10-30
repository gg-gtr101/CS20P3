package SkillBuilders;

import java.util.Scanner;

public class OddSum 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);

        int maxNumber;

        do {
            System.out.print("Enter a positive integer: ");
            if (input.hasNextInt()) 
            {
                maxNumber = input.nextInt();
                if (maxNumber > 0) {
                    break; 
                } else 
                {
                    System.out.println("Invalid input. Please enter a number greater than 0.");
                }
            } else 
            {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.next();
            }
        } while (true); 

        int oddSum = 0;

        for (int i = 1; i <= maxNumber; i++) 
        {
            if (i % 2 != 0) {
                oddSum += i; 
            }
        }

        System.out.println("---");
        System.out.println("The sum of odd numbers from 1 to " + maxNumber + " is: " + oddSum);

	}

}
