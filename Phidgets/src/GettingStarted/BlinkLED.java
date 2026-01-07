package GettingStarted;

import com.phidget22.*;

public class BlinkLED 
{
    public static void main(String[] args) throws Exception
    {

        DigitalOutput redLED = new DigitalOutput();
        DigitalOutput greenLED = new DigitalOutput();

        redLED.setHubPort(1);
        redLED.setIsHubPortDevice(true);
        greenLED.setHubPort(4);
        greenLED.setIsHubPortDevice(true);

        redLED.open(1000);
        greenLED.open(1000);

        while(true)
        {
            redLED.setState(true);
            greenLED.setState(true);
            Thread.sleep(1000);
            redLED.setState(false);
            greenLED.setState(false);
            Thread.sleep(1000);
        }
        
    }
}
  