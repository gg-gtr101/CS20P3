package AdvancedLessons;

import com.phidget22.*;

public class SmartPhidgetEvents 
{
    public static void main(String[] args) throws Exception {

        TemperatureSensor tempSensor = new TemperatureSensor();
        HumiditySensor humiditySensor = new HumiditySensor();

        
        tempSensor.addTemperatureChangeListener(new TemperatureSensorTemperatureChangeListener() {
            public void onTemperatureChange(TemperatureSensorTemperatureChangeEvent e) {
                double temp = e.getTemperature();
                
                if (temp > 21.0) {
                    System.out.println("Current Temperature: " + temp + "°C");
                } else {
                    System.out.println("Room is too cold");
                }
            }
        });

        humiditySensor.addHumidityChangeListener(new HumiditySensorHumidityChangeListener() {
            public void onHumidityChange(HumiditySensorHumidityChangeEvent e) {
                System.out.println("Humidity: " + e.getHumidity() + "% RH");
            }
        });

        tempSensor.open(1000);
        humiditySensor.open(1000);
        
        while (true) 
        {
            Thread.sleep(150);
        }
    }
}
	