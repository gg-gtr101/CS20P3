package SkillBuilders;

public class Student 
{
	private String firstName;
	private String lastName;
	private String address;
	private int stuID;
	
	public Student() // Constructor method
	{
		firstName = "G";
		lastName = "G";
		address = "####";
		stuID = 0;
	}
	
	public Student(String f, String l, String ad, int ID) // Overload constructor
	{
		firstName = f;
		lastName = l;
		address = ad;
		stuID = ID;
	}
	
	//Accessor methods
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public int getStudentID()
	{
		return stuID;
	}
	
	//Modifier methods
	public void setFirstName(String f)
	{
		firstName = f;
	}
	
	public void setLastName(String l)
	{
		lastName = l;
	}
	
	public void setAddress(String ad)
	{
		address = ad;
	}
	
	public void setStudentID(int ID)
	{
		stuID = ID;
	}
	
	
	public String toString()
	{
		return ("First Name: " + firstName + "\nLast Name: " + lastName + "\nAddress: " + address + "\nStudent ID: " + stuID);
	}
} // Closes the Class
