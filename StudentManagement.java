import java.util.*;


class Student {
    String id;
    String name;
    int programmingMarks = -1;
    int dbmsMarks = -1;

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }}

public class StudentManagement {
    static Scanner input = new Scanner(System.in);
      static Map<String, Student> students = new HashMap<>();
        public static void main(String[] args) {
            while (true) {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t WELCOME TO STUDENTS MARKS MANAGEMENT SYSTEM \t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("[1] Add New Student\t\t\t[2] Add New Student With Marks");
                System.out.println("[3] Add Marks\t\t\t\t[4] Update Student Details");
                System.out.println("[5] Update Marks\t\t\t[6] Delete Students");
                System.out.println("[7] Print Student Details\t\t[8] Print Students Ranks");
                System.out.println("[9] Best in Programming Fundamental\t[10] Best In Database Management System");
                System.out.println("[0] Exit");
                System.out.print("\nEnter an option to continue > ");
                int option = input.nextInt();
            
            switch(option) {
                case 1: addNewStudent();break;
                case 2: addNewStudentWithMarks();break;
                case 3: addMarks();  break;
                case 4: updateStudentDetails();  break;
                case 5: updateMarks(); break;  
                case 6: deleteStudents(); break; 
                case 7: printStudentDetails();  break;
                case 8: printStudentsRanks();break;
                case 9: bestInProgrammingFundamentals(); break;     
                case 10:  bestInDatabaseManagement(); break;    
                case 0: System.out.println("Exiting the system. Goodbye!");  input.close();    return;  
                default:  System.out.println("Invalid option. Please try again.");
               
                    
                    
                
              
            }}     }


public static void addNewStudent() {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("|\t\t\t\tAdd New Student \t\t\t\t|");
    System.out.println("---------------------------------------------------------------------------------");

    while (true) {
        System.out.print("Enter Student ID: ");
        String id = input.nextLine();  // Fixed here
        if (students.containsKey(id)) {
            System.out.println("Student ID already exists. Try again.");
            continue;
        }
        System.out.print("Enter Student Name: ");
        String name = input.nextLine();
        students.put(id, new Student(id, name));
        System.out.println("Student added successfully!");
        break;
    }



} }                   
                    
                   
                

               
                   
                    
               
                    
                 
               
  