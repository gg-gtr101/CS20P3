package SkillBuilders;

public class Student 
{
	private String firstName;
	private String lastName;
	private String address;
	private int stuID;
	
	public Student() // Constructor method
	{
		firstName = "";
		lastName = "";
		address = "###";
		stuID = 0000000;
	}
	
	public Student(String f, String l, String ad, int ID) // Overload constructor
	{
		firstName = f;
		lastName = l;
		address = ad;
		stuID = ID;
	}
}
