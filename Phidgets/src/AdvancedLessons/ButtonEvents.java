package AdvancedLessons;

import com.phidget22.*;

public class ButtonEvents 
{
    public static void main(String[] args) throws Exception 
    {

        DigitalInput redButton = new DigitalInput();
        DigitalInput greenButton = new DigitalInput(); 
        
        redButton.setHubPort(0);
        redButton.setIsHubPortDevice(true);

        greenButton.setHubPort(5); 
        greenButton.setIsHubPortDevice(true);

        
        redButton.addStateChangeListener(new DigitalInputStateChangeListener() 
        {
            public void onStateChange(DigitalInputStateChangeEvent e) {
                if (e.getState()) {
                    System.out.println("Red Button: Pressed");
                } else {
                    System.out.println("Red Button: Not Pressed");
                }
            }
        });

        greenButton.addStateChangeListener(new DigitalInputStateChangeListener() 
        {
            public void onStateChange(DigitalInputStateChangeEvent e) 
            {
                if (e.getState()) {
                    System.out.println("Green Button: Pressed");
                } else {
                    System.out.println("Green Button: Not Pressed");
                }
            }
        });

        redButton.open(1000);
        greenButton.open(1000);

        System.out.println("Monitoring buttons...");
        System.in.read(); 

        redButton.close();
        greenButton.close();
    }
}