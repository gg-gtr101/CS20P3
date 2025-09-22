package SkillBuilders;

public class RandomNumbers 
{

	public static void main(String[] args) 
	{
		int randNum;
		int seqL = 0;
		
		
		do
		{
			randNum = (int)(11*Math.random());
			
			System.out.println(randNum + " ");
			
			seqL = seqL + 1;
			
			
			
		}while(randNum != 0);
		
		System.out.println("\n" + "Length of sequence was " + seqL);
		

	}

}
