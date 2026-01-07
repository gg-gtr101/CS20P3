package GettingStarted;

import com.phidget22.*;

public class ReadTempandHumidity 
{
    public static void main(String[] args) throws Exception
    {

        HumiditySensor humiditySensor = new HumiditySensor();
        TemperatureSensor temperatureSensor = new TemperatureSensor();

        humiditySensor.open(1000);
        temperatureSensor.open(1000);

        while(true)
        {
            double currentHumidity = humiditySensor.getHumidity();
            double currentTemperature = temperatureSensor.getTemperature();

            if (currentHumidity > 30) {
                System.out.println("Humidity: " + currentHumidity + " %RH");
            } else 
            {
                System.out.println("Humidity is low");
            }

            if (currentTemperature > 21) {
                 System.out.println("Temperature: " + currentTemperature + " °C");
            } else 
            {
                System.out.println("Room is too cold");
            }
            
            System.out.println("----------------"); 

            Thread.sleep(150);
        }
    }
}