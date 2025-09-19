package SkillBuilders;

import java.util.Scanner;

public class GradeAvgPt2 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		int total = 0;
		
		for (int i = 1; i <= 5; i++) 
		{	System.out.print("Enter grade: " + i + ": ");
			int grade = input.nextInt();
			total += grade;
		}
			double average = total / 5.0;
			
			System.out.format("Average grade: %.2f%%%n", average);
			
	}

}
