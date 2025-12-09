package SkillBuilders;

public class Squares 
{

	public static void main(String[] args) 
	{
		int arraySize = 5;
		int[] squaresArray = new int[arraySize];
		
		System.out.println("Calculation Phase");
		for (int i = 0; i < arraySize; i++)
		{
			int squaredValue = i * i;
			
			squaresArray[i] = squaredValue;
			
			System.out.println("Index " + i + "squared is: " + squaredValue + " -> Stored in array.");
		}
		
		System.out.println("Final Array Values");
		
		for(int i = 0; i < squaresArray.length; i++);
		{
			System.out.println("Element at Index " + i + ": " + squaresArray[i]);
		}
		

	}

}
