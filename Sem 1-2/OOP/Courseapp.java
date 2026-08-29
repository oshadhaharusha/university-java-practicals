class Course
{
	private String courseid;
	private String coursename;
	private int duration;
	
	public Course()
	{
		this.courseid = "Unknown";
		this.coursename = "Unknown";
		this.duration = 0;
	}
	public Course(String courseid, String coursename, int duration)
	{
		this.courseid=courseid;
		this.coursename=coursename;
		this.duration=duration;
	}
	
	public String getcourseid()
	{
		return this.courseid;
	}
	public void setcourseid(String courseid)
	{
		this.courseid=courseid;
	}
	public String getcoursename()
	{
		return this.coursename;
	}
	public void setcoursename(String coursename)
	{
		this.coursename=coursename;
	}
	public int getduration()
	{
		return this.duration;
	}
	public void setduration(int duration)
	{
		this.duration=duration;
	}
	
	public double calculatetotalfee()
	{
		return 10000.00;
	}
	public double calculatetotalfee(double discountpresentage)
	{
		double basicfee = calculatetotalfee();
		return basicfee - (basicfee*discountpresentage/100);
	}
	
	public void displaydetails()
	{
		System.out.println("Course ID : "+this.courseid);
		System.out.println("Course Name : "+this.coursename);
		System.out.println("Duration Months : "+this.duration);
	}
}

class Regularcourse extends Course
{
	private boolean haslivesession;
	
	public Regularcourse()
	{
		super();
		this.haslivesession = false;
	}
	
	public Regularcourse(String courseid, String coursename, int duration, boolean haslivesession)
	{
		super(courseid, coursename, duration);
		this.haslivesession=haslivesession;
	}
	
	@Override
	public double calculatetotalfee()
	{
		return 100.00*getduration();
	}
	
	@Override
	public void displaydetails()
	{
		System.out.println("===--- Regular Details ---===");
		super.displaydetails();
		System.out.println("Has Live Sessions : "+this.haslivesession);
		System.out.println("Total fee : Rs."+calculatetotalfee());
		System.out.println("Basic Fee : Rs."+calculatetotalfee());
		System.out.println("Discounted Fee : Rs."+calculatetotalfee(10));
	}
	
}

class PremiumCourse extends Course
{
	private boolean includecertificate;
	
	public PremiumCourse()
	{
		super();
		this.includecertificate = false;
	}
	public PremiumCourse(String courseid, String coursename, int duration, boolean includecertificate)
	{
		super(courseid, coursename, duration);
		this.includecertificate=includecertificate;
	}
	@Override
	public double calculatetotalfee()
	{
		double Feeof = 150*getduration();
		if(includecertificate)
		{
			Feeof += 50;
		}
		return Feeof;
	}
	
	@Override
	public void displaydetails()
	{
		System.out.println("===--- Premium Details ---===");
		super.displaydetails();
		System.out.println("Certificate Included : "+includecertificate);
		System.out.println("Total Fee : Rs."+calculatetotalfee());
		System.out.println("Basic Fee : Rs."+calculatetotalfee());
		System.out.println("Discounted Fee : Rs."+calculatetotalfee(20));
	}
}

public class Courseapp
{
	public static void main(String [] args)
	{
		Regularcourse r1 = new Regularcourse();
		r1.displaydetails();
		
		PremiumCourse p1 = new PremiumCourse("csc103", "Python", 10, true);
		
		p1.displaydetails();
	}
}