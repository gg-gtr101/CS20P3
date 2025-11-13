package SkillBuilders;

public class TestStudent 
{

	public static void main(String[] args) 
	{
		Student stA = new Student();
		
		System.out.println(stA.getFirstName());
		stA.setFirstName("AAAA");
		System.out.println(stA.getFirstName());
		stA.setStudentID(1111);
		System.out.println(stA.getStudentID());

	}

}
