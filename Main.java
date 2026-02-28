import java.util.Scanner;

public class Main {
    public static void main(String[] args){
       Scanner Input = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        manager.loadFromFile();



       while (true){
           System.out.println(" ========================== Student Management System ==========================  ");
           System.out.println("Number of students: " + manager.getStudentCount());
           System.out.println("1. addStudent\n2. viewStudents\n3. deleteStudent\n4. updateStudent\n5. searchStudent\n6. calculateAverageGPA\n7. sortStudentsByGPA \n8. clearAllStudents\n9. Exiting..." );
           System.out.println("Choose :");
           int choose;
           try {
               choose =Integer.parseInt(Input.nextLine());
           } catch (Exception e) {
                 System.err.println(" Please entre a number !");
                 continue;
           }
           try {
               switch (choose) {
                   case 1 ->{
                       System.out.print("Enter ID: ");
                       int id = Integer.parseInt(Input.nextLine());
                       System.out.print("Enter name: ");
                       String name = Input.nextLine();
                       System.out.print("Enter GPA: ");
                       double gpa = Double.parseDouble(Input.nextLine());
                       Student newStudent = new Student(id, name, gpa);
                       boolean added = manager.addStudent(newStudent);
                       if(added){
                           manager.saveToFile();
                       }
                   }
                   case 2 ->{
                       manager.viewStudents();
                   }
                   case 3 -> {
                       System.out.print("Enter ID For Deleting: ");
                       int id = Integer.parseInt(Input.nextLine());

                       boolean deleted = manager.deleteStudent(id);
                       if(deleted){
                           manager.saveToFile();
                       }
                   }
                   case 4 -> {
                       System.out.println("What do you want to edit?");
                       System.out.println("1. Name\n2. Id\n3. Gpa");
                       int edit = Integer.parseInt(Input.nextLine());

                       System.out.print("Enter ID of student to edit: ");
                       int id = Integer.parseInt(Input.nextLine());

                       System.out.print("Enter new value: ");
                       String newValue = Input.nextLine();

                       boolean updated = manager.updateStudent(id, edit, newValue);
                       if(updated){
                           manager.saveToFile();
                       }
                   }
                   case 5 -> {
                       System.out.print("Enter ID to search: ");
                       int id = Integer.parseInt(Input.nextLine());
                       manager.searchStudent(id);
                   }
                   case 6 ->{
                       manager.calculateAverageGPA();
                   }
                   case 7 ->{
                       manager.sortStudentsByGPA();
                   }
                   case 8 ->{
                       manager.clearAllStudents();
                   }
                   case 9 ->{
                       System.out.println(" System is end");
                       return;
                   }

                   default -> {
                       System.out.println("Invalid choice!");
                   }

               }
           }catch (Exception e){
                      System.err.println("Unexpected Error :"+e.getMessage());
           }

           }
       }

    }
