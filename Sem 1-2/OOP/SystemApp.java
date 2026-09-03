import java.util.ArrayList;

interface Payable {
    double calculatePayment();
}

abstract class Person implements Payable {
    private String id;
    private String name;
    private String email;

    public Person(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public abstract void displayDetails();
}

class Student extends Person {
    private int yearOfStudy;
    private String program;
    private double scholarshipAmount;

    public Student(String id, String name, String email, int yearOfStudy, String program, double scholarshipAmount) {
        super(id, name, email);
        this.yearOfStudy = yearOfStudy;
        this.program = program;
        this.scholarshipAmount = scholarshipAmount;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public String getProgram() {
        return program;
    }

    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    @Override
    public double calculatePayment() {
        return this.scholarshipAmount;
    }

    @Override
    public void displayDetails() {
        System.out.println("Student ID: " + getId() + " | Student Name: " + getName() + " | Program: " + this.program + " | Year: " + this.yearOfStudy);
    }
}

class Lecturer extends Person {
    private String designation;
    private String specialization;
    private double salary;

    public Lecturer(String id, String name, String email, String designation, String specialization, double salary) {
        super(id, name, email);
        this.designation = designation;
        this.specialization = specialization;
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public double calculatePayment() {
        return this.salary;
    }

    @Override
    public void displayDetails() {
        System.out.println("Lecturer ID: " + getId() + " | Lecturer Name: " + getName() + " | Designation: " + this.designation + " | Specialization: " + this.specialization);
    }
}

class Course {
    private String courseId;
    private String courseTitle;
    private Lecturer lecturer;
    private List<Student> students;

    public Course(String courseId, String courseTitle, Lecturer lecturer) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.lecturer = lecturer;
        this.students = new ArrayList<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
        }
    }

    public void displayCourseDetails() {
        System.out.println("Lecturer: " + lecturer.getName());
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println("- " + student.getName() + " (" + student.getId() + ")");
        }
    }
}

class Department {
    private String departmentName;
    private List<Course> courses;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.courses = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void addCourse(Course course) {
        if (course != null) {
            courses.add(course);
        }
    }

    public void displayDepartmentDetails() {
        System.out.println("\n---------------------");
        System.out.println("Department Name: " + departmentName);
        System.out.println("=====================");

        for (Course course : courses) {
            course.displayCourseDetails();
        }
    }
}

public class SystemApp {
    public static void main(String[] args) {
        Lecturer l1 = new Lecturer("L302", "Nirmalan", "nirmalan@gmail.com", "BSc in CS", "AI", 500000.0);
        Lecturer l2 = new Lecturer("L402", "Bhanuka", "bhanuka@gmail.com", "BSc in Mathematics", "Pure", 800000.0);

        Student s1 = new Student("s302", "Tharusha", "tharusha@gmail.com", 4, "Computer Science", 2500.0);
        Student s2 = new Student("s32", "Hiran", "hiran@gmail.com", 4, "Mathematics", 0.0);

        Course c1 = new Course("CSC102", "Programming", l1);
        c1.addStudent(s1);
        c1.addStudent(s2);

        Department d1 = new Department("Computer Science");
        d1.addCourse(c1);

        l1.displayDetails();
        System.out.println();

        s1.displayDetails();
        System.out.println();

        s2.displayDetails();
        System.out.println();

        System.out.println("Department: " + d1.getDepartmentName() + " | Course: " + c1.getCourseTitle() + " (" + c1.getCourseId() + ")\n");

        c1.displayCourseDetails();
        System.out.println();

        System.out.println("--- Payment Information ---");
        System.out.printf("%s's Salary: LKR %,.2f%n", l1.getName(), l1.calculatePayment());
        System.out.printf("%s's Scholarship Amount: LKR %,.2f%n", s1.getName(), s1.calculatePayment());
    }
}