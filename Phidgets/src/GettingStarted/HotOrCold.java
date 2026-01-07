package GettingStarted;

import com.phidget22.*;

public class HotOrCold 
{
    public static void main(String[] args) throws Exception 
    {

        TemperatureSensor temperatureSensor = new TemperatureSensor();
        DigitalOutput redLED = new DigitalOutput();
        DigitalOutput greenLED = new DigitalOutput();
        
        redLED.setHubPort(1);            
        redLED.setIsHubPortDevice(true);
        
        greenLED.setHubPort(4);          
        greenLED.setIsHubPortDevice(true);

        temperatureSensor.open(1000);
        redLED.open(1000);
        greenLED.open(1000);

        while (true) 
        {
            double currentTemp = temperatureSensor.getTemperature();
            
            System.out.println("Current Temperature: " + currentTemp + " °C");

            if (currentTemp >= 20 && currentTemp <= 24) 
            {
                greenLED.setState(true);
                redLED.setState(false);
            } else 
            {
                greenLED.setState(false);
                redLED.setState(true);
            }

            Thread.sleep(150);
        }
    }
}