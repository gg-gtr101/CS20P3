/*
Program: PennyPitch.java          Last Date of this Revision: December 11, 2025

Purpose: The program will simulate a Penny Pitch game, using random number generation to place prizes on a 
         grid and determine which prizes are won based on randomized "penny throws."

Author: Gurshan Gaur, 
School: CHHS
Course: Computer Programming 20
*/

package Mastery;

import java.util.List;

public class PennyPitch 
{

	public static void main(String[] args) 
	{
		// Create an instance of the game
		PennyPitchGame game = new PennyPitchGame();
		
		// --- 1. Initial Setup and Display ---
		System.out.println("--- NEW GAME STARTED ---");
		game.displayBoard();
		
		// --- 2. Simulation ---
		System.out.println("\nPitching pennies...");
		game.throwPennies(10);
		
		// --- 3. Results and Output ---
		System.out.println("\n--- FINAL BOARD ---");
		game.displayBoard();
		
		List<String> wins = game.checkWins();
		
		System.out.println("\n--- RESULTS ---");
		if (wins.isEmpty())
		{
			System.out.println("No prize won.");
		}
		else
		{
			for (String prize : wins)
			{
				System.out.println("You won a: " + prize);
			}
		}
	}

}

/*
 * --- NEW GAME STARTED ---
[ BALL    ][ BALL    ][ POSTER  ][         ][ GAME    ]
[ PUZZLE  ][ POSTER  ][         ][ GAME    ][         ]
[ POSTER  ][ DOLL    ][         ][         ][ GAME    ]
[ DOLL    ][ DOLL    ][ PUZZLE  ][ BALL    ][         ]
[         ][ PUZZLE  ][         ][         ][         ]

Pitching pennies...

--- FINAL BOARD ---
[*BALL    ][ BALL    ][ POSTER  ][         ][ GAME    ]
[*PUZZLE  ][ POSTER  ][*        ][*GAME    ][         ]
[ POSTER  ][ DOLL    ][*        ][         ][*GAME    ]
[ DOLL    ][ DOLL    ][*PUZZLE  ][ BALL    ][         ]
[         ][*PUZZLE  ][         ][*        ][         ]

--- RESULTS ---
You won a: PUZZLE
 */
