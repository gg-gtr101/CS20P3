package SkillBuilders;

public class TestCircle 
{

	public static void main(String[] args) 
	{
		Circle spot = new Circle(5);

		 System.out.println("Circle radius:" + spot.getRadius());
		 System.out.println("Circle area: " + spot.area());
		 Circle.displayAreaFormula();
	}

}
