package SkillBuilders;

public class Reverse 
{

	public static void main(String[] args) 
	{
		final int Size = 11;
		int[] indexArray = new int[Size];
		
		System.out.println("Array Initalization:");
		for (int i = 0; i < Size; i++)
		{
			indexArray[i] = i;
			System.out.println("Stored value: " + indexArray[i] + " at index " + i);
		}
		
		System.out.println("Countdown");
		
		for (int i = Size - 1; i>= 0; i-- )
		{
			System.out.println(indexArray[i]);
		}

	}

}
