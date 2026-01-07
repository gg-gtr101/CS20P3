package GettingStarted;

import com.phidget22.*;

public class ReadButton 
{
	public static void main(String[] args) throws Exception
	{
	        
	        DigitalInput greenButton = new DigitalInput();
	        DigitalInput redButton = new DigitalInput();


	        greenButton.setHubPort(5);
	        greenButton.setIsHubPortDevice(true);
	        redButton.setHubPort(0);
	        redButton.setIsHubPortDevice(true);

	        greenButton.open(1000);
	        redButton.open(1000);

	        while(true)
	        {
	            System.out.println("Green Button State: " + greenButton.getState());
	            Thread.sleep(500);
	            System.out.println("Red Button State: " + redButton.getState());
	            Thread.sleep(500);
	        }
	  }
}
	  


