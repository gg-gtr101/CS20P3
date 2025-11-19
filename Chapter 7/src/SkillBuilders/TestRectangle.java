package SkillBuilders;

public class TestRectangle 
{

	public static void main(String[] args) 
	{
		Rectangle rec = new Rectangle();
		System.out.println("Initial dimensions: " + rec.getLength() + " x " + rec.getWidth());
		System.out.println("Initial Area: " + rec.Area());
		
		rec.setLength(10.5);
        rec.setWidth(5.0);
		System.out.println("\nNew dimensions: " + rec.getLength() + " x " + rec.getWidth());
        System.out.println("New Area: " + rec.Area());
        System.out.println("Calculated Perimeter: " + rec.getPerimeter());
        
     Rectangle rec2 = new Rectangle(7.2, 3.1); // Length=7.2, Width=3.1
     System.out.println("\nInitial dimensions: " + rec2.getLength() + " x " + rec2.getWidth());
     System.out.printf("Calculated Area: %.2f\n", rec2.Area());
     System.out.printf("Calculated Perimeter: %.2f\n", rec2.getPerimeter());
	}
}
