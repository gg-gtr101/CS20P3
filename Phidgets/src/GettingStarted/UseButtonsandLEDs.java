package GettingStarted;

import com.phidget22.*;

public class UseButtonsandLEDs 
{
	    public static void main(String[] args) throws Exception
	    {

	        DigitalInput redButton = new DigitalInput();
	        DigitalOutput redLED = new DigitalOutput();
	        DigitalInput greenButton = new DigitalInput();
	        DigitalOutput greenLED = new DigitalOutput();

	        redButton.setHubPort(0);
	        redButton.setIsHubPortDevice(true);
	        redLED.setHubPort(4);
	        redLED.setIsHubPortDevice(true);
	        greenButton.setHubPort(5);
	        greenButton.setIsHubPortDevice(true);
	        greenLED.setHubPort(1);
	        greenLED.setIsHubPortDevice(true);

	        redButton.open(1000);
	        redLED.open(1000);
	        greenButton.open(1000);
	        greenLED.open(1000);

	        while(true)
	        {

	            if( redButton.getState()){
	                redLED.setState(false);
	            } else {
	                redLED.setState(true);
	            }

	            if(greenButton.getState()){
	                greenLED.setState(false);
	            } else {
	                greenLED.setState(true);
	            }

	            Thread.sleep(150);
	        }
	    }
}
