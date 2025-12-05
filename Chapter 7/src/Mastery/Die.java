package Mastery;

import java.util.Random;

public class Die 
{
	private int amount;
	private Random rdm;
	
	public Die()
	{
		amount = 1;
		rdm = new Random();
	}
	
	public void roll()
	{
		amount = rdm.nextInt(6) + 1;
	}
	
	public int getValue() 
	{
		return amount;
	}
}