package GettingStarted;

import com.phidget22.*;

public class TugOfWar 
{
	public static void main(String[] args) throws Exception 
	{
        DigitalInput greenButton = new DigitalInput();
        DigitalOutput greenLED = new DigitalOutput();
        DigitalInput redButton = new DigitalInput();
        DigitalOutput redLED = new DigitalOutput();

        redButton.setHubPort(0);
        redButton.setIsHubPortDevice(true);
        redLED.setHubPort(1);
        redLED.setIsHubPortDevice(true);
        
        greenButton.setHubPort(5);
        greenButton.setIsHubPortDevice(true);
        greenLED.setHubPort(4);
        greenLED.setIsHubPortDevice(true);
        
        redButton.open(1000);
        redLED.open(1000);
        greenButton.open(1000);
        greenLED.open(1000);
        
        int redCount = 0;
        int greenCount = 0;
        boolean redPrevState = false;
        boolean greenPrevState = false;
        
        while (redCount < 10 && greenCount < 10)
        {
        	boolean redCurrentState = redButton.getState();
        	boolean greenCurrentState = greenButton.getState();
        	
        	if (redCurrentState && !redPrevState)
        	{
        		redCount++;
        		System.out.println("Red Score: " + redCount);
        	}
        	
        	if (greenCurrentState && !greenPrevState)
        	{
        		greenCount++;
        		System.out.println("Green Score: " + greenCount);
        	}
        	
        	redPrevState = redCurrentState;
        	greenPrevState = greenCurrentState;
        	
        	Thread.sleep(20);
       }
        
       DigitalOutput winnerLED;
       if (redCount >= 10)
       {
    	   System.out.println("Red Wins!");
    	   winnerLED = redLED;
       }
       else
       {
    	   System.out.println("Green Wins!");
    	   winnerLED = greenLED;
       }
       
       redLED.setState(true);
       greenLED.setState(true);
       Thread.sleep(500);
       redLED.setState(false);
       greenLED.setState(false);
       Thread.sleep(500);

       for (int i = 0; i < 5; i++)
       {
    	   winnerLED.setState(true);
           Thread.sleep(500);
    	   winnerLED.setState(false);
           Thread.sleep(500);
       }
	}

}
