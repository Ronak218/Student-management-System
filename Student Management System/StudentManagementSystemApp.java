import java.io.*;
import java.util.ArrayList;
import java.util.*;

class Student
{
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade)
    {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade; 
    }

    public String getName()
    {
        return name;
    }

    public int getRollNumber()
    {
        return rollNumber;
    }

    public String getGrade(){
        return grade;
    }

    public String toString()
    {
        return "Name:" + name + ", Roll Number:" + rollNumber + ", Grade:" +grade;
    }
}

class StudentManagementSystem 
{
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) 
    {
        students.add(student);
    }

    public void removeStudent(int rollNumber) 
    {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student findStudent(int rollNumber) 
    {
        for (Student student : students) 
        {
            if (student.getRollNumber() == rollNumber) 
            {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> getAllStudents() 
    {
        return students;
    }
}

public class StudentManagementSystemApp 
{
    public static void main(String[] args) 
    {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) 
        {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    String grade = sc.next();

                    Student newStudent = new Student(name, rollNumber, grade);
                    sms.addStudent(newStudent);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Roll Number to remove: ");
                    int rollToRemove = sc.nextInt();
                    sms.removeStudent(rollToRemove);
                    System.out.println("Student removed successfully!");
                    break;

                case 3:
                    System.out.print("Enter Roll Number to search: ");
                    int rollToSearch = sc.nextInt();
                    Student foundStudent = sms.findStudent(rollToSearch);
                    if (foundStudent != null) 
                    {
                        System.out.println("Student found: " + foundStudent);
                    } 
                    else 
                    {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    ArrayList<Student> allStudents = sms.getAllStudents();
                    System.out.println("All Students:");
                    for (Student student : allStudents) 
                    {
                        System.out.println(student);
                    }
                    break;

                case 5:
                    System.out.println("Exiting Student Management System.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
       }
    }
}