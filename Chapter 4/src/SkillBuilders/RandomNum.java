package SkillBuilders;

import java.util.Random;
import java.util.Scanner;

public class RandomNum 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);

        System.out.print("Enter the minimum value: ");
        int min = input.nextInt();

        System.out.print("Enter the maximum value: ");
        int max = input.nextInt();
        
        if (min > max) 
        {
            System.out.println("The minimum value cannot be greater than the maximum value. Please run the program again.");
        } else 
        {
            Random random = new Random();
            
            int randomNumber = random.nextInt((max - min) + 1) + min;

            System.out.println("Your random number is: " + randomNumber);
        }
    }
}
