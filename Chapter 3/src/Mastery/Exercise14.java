package Mastery;

import java.util.Scanner;

public class Exercise14 
{

	public static void main(String[] args) 
	{
	
		Scanner input = new Scanner(System.in);

        String[] states = {"New York", "New Jersey", "Connecticut"};
        int[] awbreyVotes = new int[states.length];
        int[] martinezVotes = new int[states.length];

        for (int i = 0; i < states.length; i++) 
        {
            System.out.println("Enter election results for " + states[i] + ":");
            System.out.print("Awbrey: ");
            awbreyVotes[i] = input.nextInt();
            System.out.print("Martinez: ");
            martinezVotes[i] = input.nextInt();
            System.out.println();
        }

        int awbreyTotal = 0;
        int martinezTotal = 0;
        for (int i = 0; i < states.length; i++) 
        {
            awbreyTotal += awbreyVotes[i];
            martinezTotal += martinezVotes[i];
        }

        int totalVotes = awbreyTotal + martinezTotal;
        double awbreyPercent = (double) awbreyTotal / totalVotes * 100;
        double martinezPercent = (double) martinezTotal / totalVotes * 100;

        System.out.printf("%-25s %10s  %s\n", "Candidate", "Votes", "Percentage");
        System.out.printf("%-25s %10d  %.2f %%\n", "Awbrey", awbreyTotal, awbreyPercent);
        System.out.printf("%-25s %10d  %.2f %%\n", "Martinez", martinezTotal, martinezPercent);
        System.out.printf("%-25s %10d\n", "TOTAL VOTES:", totalVotes);

    }
		
}

/* 
Enter election results for New York:
Awbrey: 314159
Martinez: 271860

Enter election results for New Jersey:
Awbrey: 89008
Martinez: 121032

Enter election results for Connecticut:
Awbrey: 213451
Martinez: 231034

Candidate                      Votes  Percentage
Awbrey                        616618  49.71 %
Martinez                      623926  50.29 %
TOTAL VOTES:                 1240544
*/