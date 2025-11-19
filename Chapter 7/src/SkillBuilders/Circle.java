package SkillBuilders;

public class Circle 
{
	 private static final double PI = 3.14;
	 private double radius;

	 public Circle() 
	 {
		 radius = 1;
	 }
	 
	 public Circle(double r)
	 {
		 radius = r;
	 }

	 public void setRadius(double newRadius) 
	 {
		 radius = newRadius;
	 }

	 public double area() 
	 {
		 double circleArea;
		 circleArea = PI * radius * radius;
		 return(circleArea);
	 }
	 public double getRadius() 
	 {
 		 return(radius);

	 }
	 	 
	 public double circumfrence() 
	 {
		 double c;
		 
		 c = 2 * PI * radius;
		 
		 return c;
	 }
	 
	 public static void displayAreaFormula() 
	 {
		 System.out.println("The formula for the area of a circle is a= Pi * r * r ");
		}
	 
}
