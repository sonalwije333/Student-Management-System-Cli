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
        System.out.print("Enter Student ID: "); 
        String id = input.next();
        
      
        if (students.containsKey(id)) {
            System.out.println("Student ID already exists. Please try again.");
            continue; 
        }else{
        
        
        System.out.print("Enter Student Name: ");  
        String name = input.next();
        
        students.put(id, new Student(id, name));

        while (true) {
            System.out.print("Do you want to add a new student? (y/n): ");
            String choice = input.next();
            
            if (choice.equals("y") || choice.equals("Y")) {
                addNewStudent(); 
                return;
            } else if (choice.equals("n") || choice.equals("N")) {
                return;
            } else {
                System.out.println("Invalid choice. Please enter 'y' or 'n'");
               clearConsole();
            }
          
        }
       
    }}
    
} 
 public  static void addNewStudentWithMarks() {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("|\t\t\t\tAdd New Student With Marks \t\t\t|");
    System.out.println("---------------------------------------------------------------------------------");
   
while (true) {
    System.out.print("Enter Student ID: ");  
    String id = input.next();
    
    // Check if the ID already exists
    if (students.containsKey(id)) {
        System.out.println("Student ID already exists. Please try again.");
        continue;  // Go back to asking for the ID
    }else{
    
    // Ask for the name only if the ID is unique
    System.out.print("Enter Student Name: ");  
    String name = input.next();
    
    // Add the student to the map
    students.put(id, new Student(id, name));
   
    Student student = students.get(id);

    System.out.print("Enter Programming Fundamentals Marks (0-100): ");
    student.programmingMarks = validateMarks();
    System.out.print("Enter DBMS Marks (0-100): ");
    student.dbmsMarks = validateMarks();
    System.out.println("Marks added successfully! Do you want to add a new student(y/n)");
    String choice = input.nextLine();
        
        if (choice.equals("y") || choice.equals("Y")) {
            addNewStudentWithMarks();
            return;
        } else if (choice.equals("n") || choice.equals("N")) {
            return;  
        } else {
            System.out.println("Invalid choice. Please enter 'y' or 'n'");
        }



} }

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
 
//Validate marks
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
while (true) {
    System.out.print("Enter Student ID: ");  
    String id = input.next();
    
    if (!students.containsKey(id)){
        System.out.println("Student ID not found. Please try again. ");
        continue;
    } 
    
    Student student = students.get(id);
    System.out.println(" Student Name: " + student.name);
    System.out.print("Enter the New Student Name: ");
    String newName = input.next();
    student.name = newName;
    System.out.println("Student details updated successfully!");
    while (true) {
        System.out.print("Do you want to update another student's details? (y/n): ");
        String choice = input.next();
        if (choice.equalsIgnoreCase("y")) {
            break; 
        } else if (choice.equalsIgnoreCase("n")) {
            return; 
        } else {
            System.out.println("Invalid choice. Please enter 'y' or 'n'");
        }

}}



}

public static void updateMarks() {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("|\t\t\t\tUpdate Marks  \t\t\t\t\t|");
    System.out.println("---------------------------------------------------------------------------------");

    String id;
    while (true) {  // Loop to check valid ID
        System.out.print("Enter Student ID: ");  
        input.nextLine();  
        id = input.nextLine();  
        
        if (!students.containsKey(id)) {
            System.out.println("Student ID not found. Please try again.");
            continue;
        }
        break;  // Exit loop if valid ID is found
    }

    Student student = students.get(id);
    System.out.println(" Student Name: " + student.name);
    System.out.println(" Programming Fundamentals Marks: " + student.programmingMarks);
    System.out.println(" DBMS Marks: " + student.dbmsMarks);

    // Validate and update marks
    System.out.print("Enter new Programming Fundamentals Marks (0-100): ");
    student.programmingMarks = validateMarks();
    System.out.print("Enter new DBMS Marks (0-100): ");
    student.dbmsMarks = validateMarks();

    System.out.println("Marks updated successfully!");

    while (true) {
        System.out.print("Do you want to update another student's details? (y/n): ");
        String choice = input.next();
        if (choice.equalsIgnoreCase("y")) {
            updateMarks();  // Recursively call the function
            return;
        } else if (choice.equalsIgnoreCase("n")) {
            return;
        } else {
            System.out.println("Invalid choice. Please enter 'y' or 'n'");
        }
    }
}


public static void deleteStudents() {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("|\t\t\t\t Delete Students \t\t\t\t|");
    System.out.println("---------------------------------------------------------------------------------");
 
    String id;
    while (true) {
        System.out.print("Enter Student ID: ");  
        input.nextLine();  
        id = input.nextLine();  
        
        if (!students.containsKey(id)) {
            System.out.println("Student ID not found. Please try again.");
            continue;
        }
        break;  
    }   
    Student student = students.get(id);
    System.out.println(" Student Name: " + student.name);
    System.out.print("Are you sure you want to delete this student? (y/n): ");
    String confirmChoice = input.nextLine();

    if (confirmChoice.equalsIgnoreCase("y")) {
        // Delete the student from the map
        students.remove(id);
        System.out.println("Student " + student.name + " has been deleted successfully!");
    } else {
        System.out.println("Student deletion cancelled.");
    }

    System.out.print("Do you want to delete another student? (y/n): ");
    String choice = input.nextLine();

    if (choice.equalsIgnoreCase("n")) {
        return; 
    } else if (!choice.equalsIgnoreCase("y")) {
        System.out.println("Invalid choice. Please enter 'y' or 'n'.");
    }
}





public static void printStudentDetails() {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("|\t\t\t\t Print Student Details \t\t\t\t|");
    System.out.println("---------------------------------------------------------------------------------");

    String id;
    while (true) {  // Loop to check valid ID
        System.out.print("Enter Student ID: ");
        input.nextLine();
        id = input.nextLine();

        if (!students.containsKey(id)) {
            System.out.println("Student ID not found. Please try again.");
            continue;
        }
        break;
    }

    Student student = students.get(id);
    System.out.println(" Student Name: " + student.name);

    if (student.programmingMarks == -1 && student.dbmsMarks == -1) {
        System.out.println("Marks yet to be added");
        System.out.println("Do you want to search another student details? (y/n)");
        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("n")) {
            return; 
        } else if (!choice.equalsIgnoreCase("y")) {
            System.out.println("Invalid choice. Please enter 'y' or 'n'.");
        }
    } else {
        // Calculate total and average marks
        double totalMarks = student.programmingMarks + student.dbmsMarks;
        double avgMarks = totalMarks / 2;

        // Rank Calculation: Sort students by total marks
        List<Student> allStudents = new ArrayList<>(students.values());
        allStudents.sort((s1, s2) -> {
            double total1 = s1.programmingMarks + s1.dbmsMarks;
            double total2 = s2.programmingMarks + s2.dbmsMarks;
            return Double.compare(total2, total1); // Sort in descending order
        });

        int rank = 1;
        for (Student s : allStudents) {
            double sTotal = s.programmingMarks + s.dbmsMarks;
            if (sTotal == totalMarks) {
                break;
            }
            rank++;
        }

 System.out.println("-----------------------------------------------------------------------------------------------------");
System.out.printf("| %-30s | %-15s | %-12s | %-18s | %-10s |%n", "Subject", "Marks", "Total Marks", "Average Marks", "Rank");
System.out.println("-----------------------------------------------------------------------------------------------------");
System.out.printf("| %-30s | %-15.2f | %-12.2f | %-18.2f | %-10d |%n", "Programming Fundamentals", student.programmingMarks, totalMarks, avgMarks, rank);
System.out.printf("| %-30s | %-15.2f | %-12.2f | %-18.2f | %-10d |%n", "DBMS", student.dbmsMarks, totalMarks, avgMarks, rank);
System.out.println("-----------------------------------------------------------------------------------------------------");


        // Rank positions in text
        String rankPosition = "";
        switch (rank) {
            case 1:
                rankPosition = "First Rank";
                break;
            case 2:
                rankPosition = "Second Rank";
                break;
            case 3:
                rankPosition = "Third Rank";
                break;
            default:
                rankPosition = "Rank " + rank;
        }
        System.out.println("Rank Position: " + rankPosition);

        // Ask if the user wants to continue
        System.out.println("Do you want to search another student details? (y/n)");
        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("n")) {
            return;
        } else if (!choice.equalsIgnoreCase("y")) {
            System.out.println("Invalid choice. Please enter 'y' or 'n'.");
        } 
    }
}



public static void printStudentsRanks() {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("|\t\t\t\tPrint Students Ranks  \t\t\t\t|");
    System.out.println("---------------------------------------------------------------------------------");

    // Create a list of students who have marks
    List<Student> validStudents = new ArrayList<>();
    for (Student student : students.values()) {
        if (student.programmingMarks != -1 && student.dbmsMarks != -1) {
            validStudents.add(student);
        }
    }

    // Sort students by total marks in descending order
    validStudents.sort((s1, s2) -> {
        double total1 = s1.programmingMarks + s1.dbmsMarks;
        double total2 = s2.programmingMarks + s2.dbmsMarks;
        return Double.compare(total2, total1); // Sorting in descending order
    });

    // Print the table header
    System.out.println("---------------------------------------------------------------------------------");
    System.out.printf("| %-5s | %-12s | %-20s | %-12s | %-16s |%n", "Rank", "Student ID", "Name", "Total Marks", "Avg. Marks");
    System.out.println("---------------------------------------------------------------------------------");

    // Iterate through the students and print the details
    int rank = 1;
    for (Student student : validStudents) {
        double totalMarks = student.programmingMarks + student.dbmsMarks;
        double avgMarks = totalMarks / 2;

        // Print each student's details in table format
        System.out.printf("| %-5d | %-12s | %-20s | %-12.2f | %-16f |%n", rank, student.id, student.name, totalMarks, avgMarks);
        rank++;
    }

    System.out.println("---------------------------------------------------------------------------------");

    String choice;
    while (true) {
        System.out.print("Do you want to go back to the main menu? (y/n): ");

      
        input.nextLine(); 

        choice = input.nextLine().trim().toLowerCase(); 

        if (choice.equals("y")) {
            return; 
        } else if (choice.equals("n")) {
            break;
        } else {
            System.out.println("Invalid choice. Please enter 'y' or 'n'.");
        }
    }
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
                 
                   
                

               
                   
                    
               
                    
                 
               
  