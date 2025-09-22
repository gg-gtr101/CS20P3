package SkillBuilders;

import java.util.Scanner;

public class Hurricane 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
        System.out.print("Enter a hurricane category (1-5): ");
        int category = input.nextInt();

        System.out.print("\nWind speeds for Category " + category + ": ");

        if (category == 1) 
        {
            System.out.println("74-95 mph, 64-82 kts, 119-153 km/hr");
        } else if (category == 2) {
            System.out.println("96-110 mph, 83-95 kts, 154-177 km/hr");
        } else if (category == 3) {
            System.out.println("111-130 mph, 96-113 kts, 178-209 km/hr");
        } else if (category == 4) {
            System.out.println("131-155 mph, 114-135 kts, 210-249 km/hr");
        } else if (category == 5) {
            System.out.println("> 155 mph, > 135 kts, > 249 km/hr");
        } else 
        {
            System.out.println("Invalid category. Please enter a number between 1 and 5.");
        }
    }
}
		

	

