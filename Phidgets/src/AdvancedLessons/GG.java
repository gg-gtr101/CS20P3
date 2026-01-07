package AdvancedLessons;

import com.phidget22.*;

public class GG 
{
	public static void main(String[] args) throws Exception 
    {

        DigitalOutput redLED = new DigitalOutput();

        redLED.setHubPort(1);
        redLED.setIsHubPortDevice(true);
        redLED.open(1000);

        for (int i = 0; i < 5; i++) 
        {
            
            for (double brightness = 0.0; brightness <= 1.0; brightness += 0.05) 
            {
                redLED.setDutyCycle(brightness);
                Thread.sleep(50);
            }

            for (double brightness = 1.0; brightness >= 0.0; brightness -= 0.05) 
            {
                redLED.setDutyCycle(brightness);
                Thread.sleep(50);
            }
        }
        
        System.out.println("Brightness Demo Finished.");
    }
}