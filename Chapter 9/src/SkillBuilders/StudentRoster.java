package SkillBuilders;

import java.util.Scanner;

public class StudentRoster 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int NoOfStu;
		
		System.out.println("Welcome to the Student Roster Application!");
		System.out.print("Please enter the number of students in the class: ");
		
		NoOfStu = input.nextInt();
		input.nextLine();
		
		String[] StuNames = new String[NoOfStu];
		
		System.out.println("\n--- Collecting Student Names ---");
		for (int i = 0; i < NoOfStu; i++)
		{
			System.out.print("Enter name for student #" + (i + 1) + ": ");
			StuNames[i] = input.nextLine();
		}

		
		System.out.println("Student Roster");
		
		if(NoOfStu > 0 )
		{
			for(int i = 0; i < StuNames.length; i++)
			{
				System.out.println((i + 1) + ". " + StuNames[i]);
			}
			{
				System.out.println("The class roster is empty.");
			}
			
			System.out.println("End of Roster");
		}
	}

}
