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
	
	public static void test()
	{
		
		Circle spot1 = new Circle(3);
		Circle spot2 = new Circle(4);

		if (spot1.equals(spot2)) 
		{
			 System.out.println("Objects are equal.");
		} else {
			System.out.println("Objects are not equal.");
		}
		System.out.println(spot1);
		System.out.println(spot2);
	}
}
