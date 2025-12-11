package SkillBuilders;

import java.util.Scanner;

public class CountLetters 
{

	public static void main(String[] args) 
	{
		final int LOW = 'A';
		final int HIGH = 'Z';
		
		int[] letterCounts = new int[HIGH - LOW + 1];
		
		Scanner input = new Scanner(System.in);
		
		String phrase;
		char[] phraseCharacters;
		int offset;
		
		System.out.print("Enter a phrase (including spaces and punctuation if desired): ");
		phrase = input.nextLine();
		
		phrase = phrase.toUpperCase();
		phraseCharacters = phrase.toCharArray();
		for (int characterIndex = 0; characterIndex < phraseCharacters.length; characterIndex++)
		{
			char currentChar = phraseCharacters[characterIndex];
			if (Character.isLetter(currentChar))
			{
				offset = currentChar - LOW;
				letterCounts[offset] += 1;
			}
		}
		
		for (int i = LOW; i <= HIGH; i++)
		{
			int count = letterCounts[i - LOW];
			
			if (count > 0)
			{
				System.out.println((char)i + ": " + count);

			}
			// Code below is if you want all letter (A-Z)
			// System.out.println((char)i + ": " + letterCounts[i - LOW]);
		}
	}
}
