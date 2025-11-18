package SkillBuilders;

public class Circle 
{
	 private static final double PI = 3.14;
	 private double radius;
	 private double Circumfrence;

	 public Circle() 
	 {
		 radius = 1;
		 Circumfrence = 2 * PI * radius;
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
	 		 return(Circumfrence);
	 	 }
	}
