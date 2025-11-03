package SkillBuilders;

import java.util.Scanner;

public class Exponentiation 
{
	public static double powerOf(int base, int exponent) 
	{
        return Math.pow(base, exponent);
	}

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);

        System.out.println("--- Exponent Calculator ---");

        System.out.print("Enter the base number (e.g., 2): ");
        int base = input.nextInt();

        System.out.print("Enter the exponent (e.g., 3): ");
        int exponent = input.nextInt();

        input.close();

        double result = powerOf(base, exponent);

        System.out.println("\nCalculation: " + base + " raised to the power of " + exponent);
        System.out.println("Result: " + (int)result);
        System.out.println("------------------------------------------");

	}

}
