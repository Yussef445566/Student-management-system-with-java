import java.io.*;
import java.util.*;
public class StudentManager {
    ArrayList<Student> Students = new  ArrayList<>();
    public boolean addStudent(Student newStudent){
        for(Student b:Students) {
            if (b.getId() == newStudent.getId()) {
                System.out.println("Id already exist!");
                return false;
            }
        }
        Students.add(newStudent);
        System.out.println("Student added successfully!");
        return true ;
    }
    public void viewStudents(){
        if(Students.isEmpty()){
            System.out.println("No students added!");
            return;
        }
        for(Student s : Students){
            s.displayInfo();
        }
    }
    public boolean deleteStudent(int id){
        for (Student s : Students){
            if (s.getId() == id){
                Students.remove(s);
                System.out.println("Student with ID " + id + " deleted successfully!");
                return true;
            }
        }
        System.out.println("Student with ID " + id + " not found!");
        return false;
    }
    public boolean updateStudent(int id, int edit, String newValue){
        for (Student s : Students){
            if (s.getId() == id){
                switch (edit){
                    case 1 -> s.setName(newValue);
                    case 2 -> s.setId(Integer.parseInt(newValue));
                    case 3 -> s.setGpa(Double.parseDouble(newValue));
                    default -> {
                        System.out.println("Invalid edit choice!");
                        return false;
                    }
                }
                System.out.println("Student updated successfully!");
                return true;
            }
        }
        System.out.println("Student with ID " + id + " not found!");
        return false;
    }
    public void searchStudent(int id){
        for(Student s : Students){
            if(s.getId() == id){
                System.out.println("Student found:");
                s.displayInfo();
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found!");
    }
    public void calculateAverageGPA(){
        if(Students.size() == 0){
            System.out.println("No students added!");
            return;
        }
        double sum = 0;
        for(Student b: Students){
            sum += b.getGpa();
        }
        double result = sum / Students.size();
        System.out.println("Average GPA: " + result);
    }
    public void sortStudentsByGPA(){
        if(Students.isEmpty()){
            System.out.println("No students added!");
            return;
        }

        Students.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));

        System.out.println("Students sorted by GPA (Highest to Lowest):");
        for(Student s : Students){
            s.displayInfo();
        }
    }
    public void saveToFile(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"))) {
            for(Student s : Students){
                bw.write(s.getId() + "," + s.getName() + "," + s.getGpa());
                bw.newLine();
            }
        } catch (Exception e){
            System.out.println("Error saving to file");
        }
    }
    public void loadFromFile(){
        File file = new File("students.txt");
        if(!file.exists()) return;

        try (Scanner sc = new Scanner(file)){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double gpa = Double.parseDouble(data[2]);

                Students.add(new Student(id, name, gpa));
            }
        } catch (Exception e){
            System.out.println("Error loading file");
        }
    }
    public int getStudentCount()
    {
        return Students.size();
    }
    public void clearAllStudents() {
        Students.clear();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"))) {
        } catch (Exception e) {
            System.out.println("Error clearing the file");
        }

        System.out.println("All students have been deleted.");
    }

}
