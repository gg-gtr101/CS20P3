package SkillBuilders;

import java.util.Scanner;

public class TimeConverter 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
        int choice = 0; 

        while (choice != 5) 
        {
            
            displayMenu();

            choice = input.nextInt();

            if (choice == 1) 
            {
                System.out.print("Enter hours: ");
                double hours = input.nextDouble();
                double minutes = hoursToMinutes(hours);
                System.out.println(hours + " hours is " + minutes + " minutes.");

            } else if (choice == 2) 
            {
                System.out.print("Enter days: ");
                double days = input.nextDouble();
                double resultHours = daysToHours(days);
                System.out.println(days + " days is " + resultHours + " hours.");

            } else if (choice == 3) 
            {
                System.out.print("Enter minutes: ");
                double minutesToH = input.nextDouble();
                double resultInHours = minutesToHours(minutesToH);
                System.out.println(minutesToH + " minutes is " + resultInHours + " hours.");

            } else if (choice == 4) 
            {
                System.out.print("Enter hours: ");
                double hoursToD = input.nextDouble();
                double resultInDays = hoursToDays(hoursToD);
                System.out.println(hoursToD + " hours is " + resultInDays + " days.");

            } else if (choice == 5) 
            {
                System.out.println("Goodbye!");

            } else 
            {
                System.out.println("Invalid choice. Please pick 1-5.");
            }
        }
        
    }

    public static void displayMenu() 
    {
        System.out.println("\n--- Time Converter Menu ---");
        System.out.println("1. Convert Hours to Minutes");
        System.out.println("2. Convert Days to Hours");
        System.out.println("3. Convert Minutes to Hours");
        System.out.println("4. Convert Hours to Days");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }


    public static double hoursToMinutes(double hours) 
    {
        return hours * 60;
    }

    public static double daysToHours(double days) 
    {
        return days * 24;
    }

    public static double minutesToHours(double minutes) 
    {
        return minutes / 60.0;
    }

    public static double hoursToDays(double hours) 
    {
        return hours / 24.0;
    }
    }


