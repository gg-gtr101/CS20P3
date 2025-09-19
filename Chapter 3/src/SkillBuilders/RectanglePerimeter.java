package SkillBuilders;

//import java.util.Scanner;

public class RectanglePerimeter 
{

	public static void main(String[] args) 
	{
		// Declaration
		//int width; 
		//int length;

		//Initialization (do this mostly)
		int width = 4; 
		int length = 13;
		
		//Scanner scanner = new Scanner(System.in);
		
		// Ask for user input
		//System.out.print("Enter the width of the rectangle: ");
        //width = scanner.nextInt();

        //System.out.print("Enter the length of the rectangle: ");
        //length = scanner.nextInt();
		
        int perimeter = 2 * (length + width);
        
        System.out.println("The perimeter of the rectangle is: " + perimeter);

	}

}
