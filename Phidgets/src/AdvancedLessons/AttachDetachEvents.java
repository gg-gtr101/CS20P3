package AdvancedLessons;

import com.phidget22.*;

public class AttachDetachEvents 
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

	        tempSensor.addAttachListener(new AttachListener() 
	        {
	            public void onAttach(AttachEvent e) 
	            { System.out.println("Attach: Temperature Sensor"); }
	        });
	        
	        tempSensor.addDetachListener(new DetachListener() 
	        {
	            public void onDetach(DetachEvent e) 
	            { System.out.println("Detach: Temperature Sensor"); }
	        });
	        
	        redButton.addAttachListener(new AttachListener() 
	        {
	            public void onAttach(AttachEvent e) 
	            { System.out.println("Attach: Red Button"); }
	        });
	        
	        redButton.addDetachListener(new DetachListener() 
	        {
	            public void onDetach(DetachEvent e) 
	            { System.out.println("Detach: Red Button"); }
	        });
 
	        greenButton.addAttachListener(new AttachListener() 
	        {
	            public void onAttach(AttachEvent e) 
	            { System.out.println("Attach: Green Button"); }
	        });
	        
	        greenButton.addDetachListener(new DetachListener() 
	        {
	            public void onDetach(DetachEvent e) 
	            { System.out.println("Detach: Green Button"); }
	        });

	        redLED.addAttachListener(new AttachListener() 
	        {
	            public void onAttach(AttachEvent e) 
	            { System.out.println("Attach: Red LED"); }
	        });
	        
	        redLED.addDetachListener(new DetachListener() 
	        {
	            public void onDetach(DetachEvent e) 
	            { System.out.println("Detach: Red LED"); }
	        });

	        greenLED.addAttachListener(new AttachListener() 
	        {
	            public void onAttach(AttachEvent e) 
	            { System.out.println("Attach: Green LED"); }
	        });

	       greenLED.addDetachListener(new DetachListener() 
	        {
	            public void onDetach(DetachEvent e) 
	            { System.out.println("Detach: Green LED"); }
	        });
	       
	        tempSensor.open(1000);
	        redButton.open(1000);
	        greenButton.open(1000);
	        redLED.open(1000);
	        greenLED.open(1000);

	        while (true) 
	        {
	            Thread.sleep(150);
	        }
	    }
	}