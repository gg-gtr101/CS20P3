package Mastery;

public class DRPlayer 
{
	private int pts;
	private Die die1;
	private Die die2;
	
	public DRPlayer() 
	{
		pts = 1000;
		die1 = new Die();
		die2 = new Die();
	}
	
	public int playRound(int risk, int choice)
	{
		die1.roll();
		die2.roll();
		int total = die1.getValue() + die2.getValue();
		
		boolean isLow = (total >= 2 && total <= 6);
		boolean isHigh = (total >= 8 && total <= 12);
		
		if (total == 7)
		{
			pts -= risk;
		} else if (choice == 0 && isLow)
		{
			pts += (risk * 2);
		} else if (choice == 1 && isHigh)
		{
			pts += (risk * 2);
		} else 
		{
			pts -= risk;
		}
		
		return total;
	}
	
	public int getPts()
	{
		return pts;
	}
}
