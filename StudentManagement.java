import java.util.*;


class Student {
    String id;
    String name;
    double programmingMarks = -1;
    double dbmsMarks = -1;

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
        System.out.print("Enter Student ID: ");  // Prompt for ID on a new line
        String id = input.next();
        
        // Check if the ID already exists
        if (students.containsKey(id)) {
            System.out.println("Student ID already exists. Please try again.");
            continue;  // Go back to asking for the ID
        }else{
        
        // Ask for the name only if the ID is unique
        System.out.print("Enter Student Name: ");  // Prompt for Name on a new line
        String name = input.next();
        
        // Add the student to the map
        students.put(id, new Student(id, name));

        while (true) {
            System.out.print("Do you want to add a new student? (y/n): ");
            String choice = input.next();
            
            if (choice.equals("y") || choice.equals("Y")) {
                addNewStudent(); // Make sure this method exists
                return;
            } else if (choice.equals("n") || choice.equals("N")) {
                return;
            } else {
                System.out.println("Invalid choice. Please enter 'y' or 'n'");
            }
        }
    }}
} 
 public  static void addNewStudentWithMarks() {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("|\t\t\t\tAdd New Student With Marks \t\t\t|");
    System.out.println("---------------------------------------------------------------------------------");
    addNewStudent();
    System.out.print("Enter Student ID: ");
    String id = input.nextLine();
    if (!students.containsKey(id)) {
        System.out.println("Student not found!");
        return; }
    Student student = students.get(id);

    System.out.print("Enter Programming Fundamentals Marks (0-100): ");
    student.programmingMarks = validateMarks();
    System.out.print("Enter DBMS Marks (0-100): ");
    student.dbmsMarks = validateMarks();
    System.out.println("Marks added successfully! Do you want to add a new student(y/n)");
    String choice = input.nextLine();
        
        if (choice.equals("y") || choice.equals("Y")) {
            addMarks();  
            return;
        } else if (choice.equals("n") || choice.equals("N")) {
            return;  
        } else {
            System.out.println("Invalid choice. Please enter 'y' or 'n'");
        }

}


public static void addMarks() {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("|\t\t\t\tAdd Marks   \t\t\t\t\t|");
    System.out.println("---------------------------------------------------------------------------------");
    System.out.print("Enter Student ID: ");
    String id = input.nextLine();
    if (!students.containsKey(id)) {
        System.out.println("Student not found!");
        return; }
    Student student = students.get(id);

    System.out.print("Enter Programming Fundamentals Marks (0-100): ");
    student.programmingMarks = validateMarks();
    System.out.print("Enter DBMS Marks (0-100): ");
    student.dbmsMarks = validateMarks();
    System.out.println("Marks added successfully! Do you want to add a new student(y/n)");
    String choice = input.nextLine();
        
        if (choice.equals("y") || choice.equals("Y")) {
            addMarks();  
            return;
        } else if (choice.equals("n") || choice.equals("N")) {
            return;  
        } else {
            System.out.println("Invalid choice. Please enter 'y' or 'n'");
        }

}
 
static  double validateMarks() {
     double marks;
     while (true) {
        try {
            marks = input.nextInt();
            input.nextLine();
            if (marks >= 0 && marks <= 100) break;
        } catch (InputMismatchException e) {
            input.nextLine();
        }
        System.out.print("Invalid marks. Enter again (0-100): ");
    }
    return marks;
}

public static void updateStudentDetails() {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("|\t\t\t\tUpdate Student Details \t\t\t\t|");
    System.out.println("---------------------------------------------------------------------------------");
   
}

public static void updateMarks() {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("|\t\t\t\tUpdate Marks  \t\t\t\t\t|");
    System.out.println("---------------------------------------------------------------------------------");
    
}

public static void deleteStudents() {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("|\t\t\t\t Delete Students \t\t\t\t\t|");
    System.out.println("---------------------------------------------------------------------------------");
    
}

public static void printStudentDetails() {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("|\t\t\t\t Print Student Details \t\t\t\t|");
    System.out.println("---------------------------------------------------------------------------------");
    
}

public static void printStudentsRanks() {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("|\t\t\t\tPrint Students Ranks  \t\t\t\t|");
    System.out.println("---------------------------------------------------------------------------------");
  
}

public static void bestInProgrammingFundamentals() {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("|\t\t\t  Best in Programming Fundamentals     \t\t\t|");
    System.out.println("---------------------------------------------------------------------------------");
   
}

public static void bestInDatabaseManagement() {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("|\t\t       Best In Database Management System   \t\t\t|");
    System.out.println("---------------------------------------------------------------------------------");
   
}

public final static void clearConsole() {
    try {
    final String os = System.getProperty("os.name");
    if (os.contains("Windows")) {
    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } else {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    }
    } catch (final Exception e) {
    e.printStackTrace();
    // Handle any exceptions.
    }
    }

}                   
                    
                   
                

               
                   
                    
               
                    
                 
               
  