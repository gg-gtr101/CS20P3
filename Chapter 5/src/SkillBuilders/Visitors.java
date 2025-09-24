package SkillBuilders;

import java.util.Scanner;

public class Visitors 
{

	public static void main(String[] args) 
	{
		int numVisitors = 0;
		int totalVisitors = 0;
		int avgVisitor = 0;
		
		Scanner input = new Scanner(System.in);
		
		for (int day = 1; day <= 5; day++) 
		{
			System.out.println("Enter the number of visitors on day " + day + ":");
			
			 numVisitors = input.nextInt();
			 totalVisitors = totalVisitors + numVisitors;
		}
		
		avgVisitor = (totalVisitors / 5);
		
		System.out.println("The average number of visitors is: " + avgVisitor);

	}

}
