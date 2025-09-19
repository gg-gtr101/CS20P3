package SkillBuilders;

import java.util.Scanner;

public class Digits 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a two-digit number: ");
		int number = input.nextInt();
		
		int ones = number % 10;
		int tens = number / 10;
		
		System.out.println("Ten place: " + tens);
		System.out.println("Ones place: " + ones);

	}

}
