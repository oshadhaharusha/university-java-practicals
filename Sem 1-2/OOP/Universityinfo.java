abstract  class Person
{
	protected String id;
	protected String name;
	
	public Person(String id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public abstract void displaydetails();
}

class Student extends Person
{
	private String program;
	private int yearofstudy;
	
	public Student(String id, String name, String program, int yearofstudy)
	{
		super(id, name);
		this.program = program;
		this.yearofstudy = yearofstudy;
	}
	
	@Override
	public void displaydetails()
	{
		System.out.println("--- STUDENT DETAILS ---");
		System.out.println("Student ID : "+this.id);
		System.out.println("Student Name : "+this.name);
		System.out.println("Program : "+this.program);
		System.out.println("Year of Study : Year"+this.yearofstudy);
		System.out.println();
	}
}

class Lecturer extends Person
{
	private String designation;
	private String specialization;
	
	public Lecturer(String id, String name, String designation, String specialization)
	{
		super(id, name);
		this.designation = designation;
		this.specialization = specialization;
	}
	
	@Override
	public void displaydetails()
	{
		System.out.println("--- LECTURER DETAILS ---");
		System.out.println("Lecturer ID : "+this.id);
		System.out.println("Lecturer Name : "+this.name);
		System.out.println("Designation : "+this.designation);
		System.out.println("Specialized in : "+this.specialization);
		System.out.println();
	}
}

public class Universityinfo
{
	public static void main(String [] args)
	{
		Person s1 = new Student("11cs", "Oshadha", "Bsc. CS", 2);
		
		Person l1 = new Lecturer("L234", "Tharusha", "Prof", "AI");
		
		s1.displaydetails();
		l1.displaydetails();
	}
}


