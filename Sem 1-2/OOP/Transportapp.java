class Vehicle
{
    private String brand;
    private double speed;
    private Engine engine;
    private Driver driver;

    public Vehicle(String brand, double speed, String enginetype, Driver driver)
    {
        this.brand = brand;
        this.speed = speed;
        this.engine = new Engine(enginetype);
        this.driver = driver;
    }

    public String getbrand()
    {
        return this.brand;
    }
    public void setbrand(String brand)
    {
        this.brand = brand;
    }

    public double getspeed()
    {
        return this.speed;
    }
    public void setspeed(double speed)
    {
        this.speed = speed;
    }

    public Engine getengine()
    {
        return this.engine;
    }

    public Driver getdriver()
    {
        return this.driver;
    }
    public void setdriver(Driver driver)
    {
        this.driver = driver;
    }

    public void start()
    {
        System.out.println("Engine start...");
    }

    public void displaydetails()
    {
        System.out.println("Brand : "+this.brand+" | Speed : "+this.speed+" kmh");
        System.out.println("Engine Type : "+engine.getenginetype());
        System.out.println("Driver Name : "+driver.getname()+" | L Number : "+this.driver.getlnumber());

    }
}

class Bus extends Vehicle
{
    private Driver driver;

    public Bus(String brand, double speed, String enginetype, Driver driver)
    {
        super(brand, speed, enginetype, driver);
    }

    @Override
    public void start()
    {
        System.out.println("Bus is started...");
    }
}

class Truck extends Vehicle
{
    private Driver driver;

    public Truck(String brand, double speed, String enginetype, Driver driver)
    {
        super(brand, speed, enginetype, driver);
    }

    @Override
    public void start()
    {
        System.out.println("Truck is started...");
    }
}

class Engine
{
    private String enginetype;

    public Engine(String enginetype)
    {
        this.enginetype = enginetype;
    }

    public String getenginetype()
    {
        return this.enginetype;
    }
    public void setenginetype(String enginetype)
    {
        this.enginetype = enginetype;
    }
}

class Driver
{
    private String name;
    private String lnumber;

    public Driver(String name, String lnumber)
    {
        this.name = name;
        this.lnumber = lnumber;
    }

    public String getname()
    {
        return this.name;
    }
    public String getlnumber()
    {
        return this.lnumber;
    }

    public void setname(String name)
    {
        this.name = name;
    }
    public void setlnumber(String lnumber)
    {
        this.lnumber = lnumber;
    }

    public void driverdisplay()
    {
        System.out.println("Driver Name : "+this.name+" | L Nmuber : "+this.lnumber);
    }
}

public class Transportapp
{
    public static void main(String [] args)
    {
        Driver driver1 = new Driver("John Doe", "L12345");
        Vehicle vehicle1 = new Vehicle("Toyota", 120.0, "Petrol", driver1);
        vehicle1.start();
        vehicle1.displaydetails();

        System.out.println();

        Driver driver2 = new Driver("Jane Smith", "L67890");
        Bus bus1 = new Bus("Mercedes", 80.0, "Diesel", driver2);
        bus1.start();
        bus1.displaydetails();

        System.out.println();

        Driver driver3 = new Driver("Mike Johnson", "L54321");
        Truck truck1 = new Truck("Volvo", 100.0, "Diesel", driver3);
        truck1.start();
        truck1.displaydetails();
    }
}