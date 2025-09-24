package Mastery;

import java.util.Scanner;

public class Exercise13 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the principal owing (P): ");
        double principal = input.nextDouble(); 

        System.out.print("Enter the annual interest rate (r), e.g., 0.06 for 6%: ");
        double annualRate = input.nextDouble(); 

        System.out.print("Enter the number of monthly payments (m): ");
        int months = input.nextInt(); 

        double monthlyInterestRate = annualRate / 12.0;

        double numerator = principal * monthlyInterestRate;

        double denominator = 1 - Math.pow(1 + monthlyInterestRate, -months);

        double monthlyPayment = numerator / denominator;
        
        System.out.println("-------------------------------------------");
        System.out.printf("Principal: %d\n", (int)principal);
        System.out.printf("Interest Rate: %f\n", annualRate);
        System.out.printf("Number of monthly payments: %d\n", months);
        System.out.printf("The monthly payment is: $%.2f\n", monthlyPayment);
        System.out.println("-------------------------------------------");
	}
}
