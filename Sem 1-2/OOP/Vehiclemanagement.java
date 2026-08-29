class Vehicle
{
	private String vehicleID;
	private String vehiclename;
	private int rentaldays;
	
	public Vehicle()
	{
		this.vehicleID = "Unknown";
		this.vehiclename = "Unknown";
		this.rentaldays = 0;
	}
	
	public Vehicle(String vehicleID, String vehiclename, int rentaldays)
	{
		this.vehicleID=vehicleID;
		this.vehiclename=vehiclename;
		this.rentaldays=rentaldays;
	}
	
	public String getvehicleid()
	{
		return this.vehicleID;
	}
	public String getvehclename()
	{
		return this.vehiclename;
	}
	public int getrentdays()
	{
		return this.rentaldays;
	}
	
	public void setvehicleid(String vehicleID)
	{
		this.vehicleID=vehicleID;
	}
	public void setvehiclename(String vehiclename)
	{
		this.vehiclename = vehiclename;
	}
	public void setrentdays(int rentaldays)
	{
		this.rentaldays=rentaldays;
	}
	
	public void displaydetails()
	{
		System.out.println("Vehivle ID :- "+this.vehicleID);
		System.out.println("Vehicle name :- "+this.vehiclename);
		System.out.println("Renter days :- "+this.rentaldays);
	}
}

class Car extends Vehicle
{
	public Car(String vehicleID, String vehiclename, int rentaldays)
	{
		super(vehicleID, vehiclename, rentaldays);
	}
	public double calculaterent()
	{
		return getrentdays()*50;
	}
	
	@Override
	public void displaydetails()
	{
		System.out.println("=== Vehicle Details ===");
		super.displaydetails();
		System.out.println("Rental Cost is :- "+calculaterent());
	}
}

class Truck extends Vehicle
{
	public Truck(String vehicleID, String vehiclename, int rentaldays)
	{
		super(vehicleID, vehiclename, rentaldays);
	}
	
	public double calculaterent()
	{
		return getrentdays()*80;
	}
	
	@Override
	public void displaydetails()
	{
		System.out.println("=== Vehicle Details ===");
		super.displaydetails();
		System.out.println("Rental Cost is :- "+calculaterent());
	}
}

public class Vehiclemanagement
{
	public static void main(String [] args)
	{
		Car c1 = new Car("CBO123", "BMW", 10);
		Truck t1 = new Truck("LY234", "Isuzu", 5);
		
		c1.displaydetails();
		t1.displaydetails();
	}
}