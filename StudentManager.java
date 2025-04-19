// Student Management System
// Concepts: OOP (Class, Object), Lists, Scanner input, Exception Handling
// Requirements: Create Student class with attributes like name, id, grade. Allow adding, displaying, searching students.




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student
{
    private int id;
    private String name;
    private int standard;
    private char grade;

    public Student(int id,String name,int standard,char grade){
        this.id = id;
        this.name = name;
        this.standard = standard;
        this.grade = grade;
    }

    public int getId() {return this.id;}
    public String getName() {return this.name;}
    public int getStandard() {return this.standard;}
    public char getGrade() {return this.grade;}

    public void setName(String name) {this.name = name;}
    public void setStandard(int standard) {this.standard = standard;}
    public void setGrade(char grade) {this.grade = grade;}

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grade: " + grade;
    }
}



public class StudentManager {

    private static List<Student> studentList = new ArrayList<>();
    private static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {

        while(true){
            System.out.println("Enter 1 to add student\nEnter 2 to view all students\nEnter 3 to exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAll();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

    }

    public static void addStudent(){
        System.out.println("Enter ID : ");
        int id = sc.nextInt();
        System.out.println("Enter Name : ");
        String name = sc.next();
        System.out.println("Enter Standard : ");
        int standard = sc.nextInt();
        System.out.println("Enter Grdae : ");
        char grade = sc.next().charAt(0);

        Student s = new Student(id, name, standard, grade);
        studentList.add(s);
    }

    public static  void viewAll(){
        if(studentList.isEmpty()){
            System.out.println("No Students");
        }
        else{studentList.forEach(System.out::println);}
    }
}

