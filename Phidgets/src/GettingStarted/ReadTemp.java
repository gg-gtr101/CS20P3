package GettingStarted;

import com.phidget22.*;

public class ReadTemp 
{
    public static void main(String[] args) throws Exception
    {

        TemperatureSensor temperatureSensor = new TemperatureSensor();
        temperatureSensor.open(1000);

        while(true) 
        {
            double celsius = temperatureSensor.getTemperature();

            double fahrenheit = (celsius * 1.8) + 32;

            System.out.println("Temperature: " + fahrenheit + " °F" );
            
            Thread.sleep(150);
        }
    }
}