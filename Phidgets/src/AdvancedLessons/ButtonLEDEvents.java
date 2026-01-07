package AdvancedLessons;

import com.phidget22.*;

public class ButtonLEDEvents 
{
	static int redPresses = 0;
	static int greenPresses = 0;
	static int totalPresses = 0;
	static boolean gameFinished = false;
	
	public static void main(String[] args) throws Exception 
	{
		    DigitalInput redButton = new DigitalInput();
	        DigitalInput greenButton = new DigitalInput();
	        DigitalOutput redLED = new DigitalOutput();
	        DigitalOutput greenLED = new DigitalOutput();

	        redButton.setHubPort(0);
	        redButton.setIsHubPortDevice(true);
	        redLED.setHubPort(1);
	        redLED.setIsHubPortDevice(true);

	        greenButton.setHubPort(5);
	        greenButton.setIsHubPortDevice(true);
	        greenLED.setHubPort(4);
	        greenLED.setIsHubPortDevice(true);

	        redButton.addStateChangeListener(new DigitalInputStateChangeListener() 
	        {
	            public void onStateChange(DigitalInputStateChangeEvent e) 
	            {
	                if (e.getState() && !gameFinished) 
	                {
	                    try {
	                        redPresses++;
	                        totalPresses++;
	                        
	                        greenLED.setState(true);
	                        
	                        System.out.println("Red Clicked! [" + redPresses + "/10] | Total: " + totalPresses);

	                        if (redPresses >= 10) 
	                        {
	                            gameFinished = true;
	                            System.out.println("\n*** RED PLAYER WINS! ***");
	                            redLED.setState(true);
	                            greenLED.setState(true);
	                        }
	                    } catch (PhidgetException ex) { System.out.println(ex.getDescription()); }
	                } 
	                else if (!e.getState() && !gameFinished) 
	                {
	                    try { greenLED.setState(false); } catch (PhidgetException ex) { }
	                }
	            }
	        });

	        greenButton.addStateChangeListener(new DigitalInputStateChangeListener() 
	        {
	            public void onStateChange(DigitalInputStateChangeEvent e) 
	            {
	                if (e.getState() && !gameFinished) 
	                {
	                    try {
	                        greenPresses++;
	                        totalPresses++;
	                        
	                        redLED.setState(true);
	                        
	                        System.out.println("Green Clicked! [" + greenPresses + "/10] | Total: " + totalPresses);

	                        if (greenPresses >= 10) {
	                            gameFinished = true;
	                            System.out.println("\n*** GREEN PLAYER WINS! ***");
	                            redLED.setState(true); 
	                            greenLED.setState(true);
	                        }
	                    } catch (PhidgetException ex) { System.out.println(ex.getDescription()); }
	                } 
	                else if (!e.getState() && !gameFinished) {
	                    try { redLED.setState(false); } catch (PhidgetException ex) { }
	                }
	            }
	        });

	        redButton.open(1000);
	        redLED.open(1000);
	        greenButton.open(1000);
	        greenLED.open(1000);

	        System.out.println("RACE STARTED! First to 10 presses wins.");
	        
	        while (true) 
	        {
	            Thread.sleep(150);
	        }
	    }
	}