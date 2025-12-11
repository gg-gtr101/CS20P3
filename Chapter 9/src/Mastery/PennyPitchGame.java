package Mastery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PennyPitchGame 
{
	private static final int ROWS = 5;
	private static final int CLMS = 5;
	private static final String [] PRIZES = {"PUZZLE", "GAME", "BALL", "POSTER", "DOLL"};
	
	// State variables (The "Game Elements")
	private String[][] board;
	private boolean[][] pennies;

	// Constructor: Sets up the board immediately when "new PennyPitchGame()" is called
	public PennyPitchGame() 
	{
		board = new String[ROWS][CLMS];
		pennies = new boolean[ROWS][CLMS];
		setupBoard();
	}
	
	// Initializes the board by randomly placing 3 instances of each prize and filling the remaining squares with empty space.
	public void setupBoard()
	{
		// Add 3 of each prize
		List<String> prizePool = new ArrayList <>();
		for (String prize : PRIZES) 
		{
			for (int i = 0; i < 3; i ++) prizePool.add(prize);
		}	
		// Fill rest with empty
		while (prizePool.size() < (ROWS * CLMS))
		{
			prizePool.add(" ");
		}
		Collections.shuffle(prizePool);
		
		// Fill grid
		int index = 0;
		for (int r = 0; r < ROWS; r++)
		{
			for (int c = 0; c < CLMS; c++)
			{
				board[r][c] = prizePool.get(index++);
			}
		}
	}
	
	// Simulates throwing the specified number of pennies onto the board by setting random spots in the 'pennies' array to true.
	public void throwPennies(int NoOfPennies)
	{
		Random rdm = new Random();
		for (int i = 0; i < NoOfPennies; i++)
		{
			int r = rdm.nextInt(ROWS);
			int c = rdm.nextInt(CLMS);
			pennies[r][c] = true;
		}
	}
	
	// Returns a list of prizes won so the Main class can decide how to print them
	public List<String> checkWins()
	{
		List<String> wonPrizes = new ArrayList<>();
		
		for (String prize: PRIZES)
		{
			int hits = 0;
			for (int r = 0; r < ROWS; r++)
			{
				for (int c = 0; c < CLMS; c++)
				{
					if (board[r][c].equals(prize) && pennies[r][c])
					{
						hits++;
					}
				}
			}
			if (hits == 3)
			{
				wonPrizes.add(prize);
			}
		}
		return wonPrizes;
	}
	
	// Prints the current state of the game board to the console, marking squares covered by a penny with an asterisk (*)
	public void displayBoard()
	{
		for (int r = 0; r < ROWS; r++)
		{
			for (int c = 0; c < CLMS; c++)
			{
				String label = board[r][c];
				String marker = pennies[r][c] ? "*" : " ";
				
				if (label.trim().isEmpty())
				{
					System.out.printf("[%s%-8s]", marker, "");
				}
				else
				{
					System.out.printf("[%s%-8s]", marker, label);
				}
			}
			
			System.out.println();
		}
	}
}
