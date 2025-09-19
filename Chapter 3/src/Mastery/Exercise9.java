package Mastery;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercise9 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#,###");

        System.out.println("Enter your birthdate:");
        System.out.print("Year: ");
        int birthYear = input.nextInt();
        System.out.print("Month: ");
        int birthMonth = input.nextInt();
        System.out.print("Day: ");
        int birthDay = input.nextInt();

        System.out.println("\nEnter today's date:");
        System.out.print("Year: ");
        int currentYear = input.nextInt();
        System.out.print("Month: ");
        int currentMonth = input.nextInt();
        System.out.print("Day: ");
        int currentDay = input.nextInt();

        int years = currentYear - birthYear;
        int months = currentMonth - birthMonth;
        int days = currentDay - birthDay;

        if (days < 0) {
            days += 30;
            months--;
        }
        if (months < 0) {
            months += 12;
            years--;
        }

        int daysAlive = years * 365 + months * 30 + days;

        int hoursSlept = daysAlive * 8;

        System.out.println("\nYou have been alive for " + formatter.format(daysAlive) + " days.");
        System.out.println("You have slept " + formatter.format(hoursSlept) + " hours.");
	     
	}

}

/* 
Enter your birthdate:
Year: 2010
Month: 2
Day: 25

Enter today's date:
Year: 2025
Month: 9
Day: 18

You have been alive for 5,678 days.
You have slept 45,424 hours.
*/
