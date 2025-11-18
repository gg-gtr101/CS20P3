package SkillBuilders;

public class TestStudent 
{

	public static void main(String[] args) 
	{
		Student stA = new Student();
		
		System.out.println(stA.getFirstName());
		System.out.println(stA.getLastName());
		System.out.println(stA.getAddress());
		System.out.println(stA.getStudentID());

		System.out.println("------------------------");
		
		Student stB = new Student("Derek", "Jake", "1111 Slate Street", 1111);
		
		/*
		System.out.println(stB.getFirstName());
		System.out.println(stB.getLastName());
		System.out.println(stB.getAddress());
		System.out.println(stB.getStudentID());
		*/
		
		
		// stB.setFirstName("GG");
		System.out.println(stB);

	}

}
