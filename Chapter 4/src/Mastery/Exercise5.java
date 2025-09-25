package Mastery;

import java.util.Scanner;

public class Exercise5 
{

	public static void main(String[] args) 
	{
		 Scanner input = new Scanner(System.in);

	        System.out.print("Enter the percentage: ");

	        double percentage = input.nextDouble();

	        String letterGrade;

	        if (percentage >= 90) 
	        {
	            letterGrade = "A";
	        } else if (percentage >= 80) 
	        {
	            letterGrade = "B";
	        } else if (percentage >= 70) 
	        {
	            letterGrade = "C";
	        } else if (percentage >= 60) 
	        {
	            letterGrade = "D";
	        } else 
	        {
	            letterGrade = "F";
	        }

	        System.out.println("The corresponding letter grade is: " + letterGrade);
	}
}
