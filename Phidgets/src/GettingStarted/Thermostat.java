package GettingStarted;

import com.phidget22.*;

public class Thermostat 
{
    public static void main(String[] args) throws Exception 
    {

        TemperatureSensor tempSensor = new TemperatureSensor();
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

        tempSensor.open(1000);
        redButton.open(1000);
        redLED.open(1000);
        greenButton.open(1000);
        greenLED.open(1000);

        int setTemperature = 21; 
        long lastPrintTime = System.currentTimeMillis();
        boolean redPrevState = false;
        boolean greenPrevState = false;

        System.out.println("Thermostat Started. Default Set Temp: 21°C");

        while (true) 
        {
            boolean redCurrent = redButton.getState();
            boolean greenCurrent = greenButton.getState();

            if (greenCurrent && !greenPrevState) 
            {
                setTemperature++;
                System.out.println("Set Temp Increased: " + setTemperature + "°C");
            }

            if (redCurrent && !redPrevState) 
            {
                setTemperature--;
                System.out.println("Set Temp Decreased: " + setTemperature + "°C");
            }

            redPrevState = redCurrent;
            greenPrevState = greenCurrent;

            double currentTemp = tempSensor.getTemperature();
            if (Math.abs(currentTemp - setTemperature) <= 2) 
            {
                greenLED.setState(true);
                redLED.setState(false);
            } else 
            {
                greenLED.setState(false);
                redLED.setState(true);
            }

            if (System.currentTimeMillis() - lastPrintTime >= 10000) {
                System.out.println("Room: " + String.format("%.2f", currentTemp) + "°C | Set: " + setTemperature + "°C");
                lastPrintTime = System.currentTimeMillis();
            }

            Thread.sleep(20);
        }
    }
}
