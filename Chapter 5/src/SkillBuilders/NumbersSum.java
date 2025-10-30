package SkillBuilders;

import java.util.Scanner;

public class NumbersSum 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        int number = input.nextInt();
        int sum = 0;

        System.out.println("--------------------");

        for (int i = 1; i <= number; i++) 
        {
            System.out.println(i);
            sum += i;
        }

        System.out.println("--------------------");
        System.out.println("Sum: " + sum);

    }
}

	


