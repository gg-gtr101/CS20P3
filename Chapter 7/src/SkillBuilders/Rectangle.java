package SkillBuilders;

public class Rectangle 
{
	private double length;
	private double width;
	
	public Rectangle()
	{
		length = 0.0;
		width = 0.0;
	}
	
	public Rectangle(double l, double w)
	{
		length = (l > 0) ? l : 0.0;
		width = (w > 0) ? w : 0.0;
	}

	public double getLength()
	{
		return length;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public void setLength(double newLength)
	{
		length = newLength;
	}
	
	public void setWidth(double newWidth)
	{
		width = newWidth;
	}
	
	public double Area()
	{
		return length * width;
	}
	
	public double getPerimeter()
	{
		return 2 * (length + width);
	}
	
	public static void displayAreaFormula()
	{
		 System.out.println("The formula for the area of a rectangle is a = l * w");
	}
	
}
