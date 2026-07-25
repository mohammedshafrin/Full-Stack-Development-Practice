import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Create a Student class
class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}

public class Task01_StudentSearch {
    // Sample Data
    static List<Student> students = Arrays.asList(
        new Student(1, "John Doe"),
        new Student(2, "Jane Smith")
    );

    // Implement a method that returns Optional<Student>
    public static Optional<Student> findStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst(); 
    }

    public static void main(String[] args) {
        // Test Case 1: Searching for an existing student
        Optional<Student> studentOpt = findStudentById(1);
        
        // Demonstrate the use of isPresent()[cite: 14]
        if (studentOpt.isPresent()) {
            System.out.println("Student Name: " + studentOpt.get().getName()); // Display name if found[cite: 14]
        } else {
            System.out.println("Student not found"); // Otherwise print[cite: 14]
        }

        // Test Case 2: Searching for a non-existing student
        Optional<Student> missingStudentOpt = findStudentById(99);
        if (missingStudentOpt.isPresent()) {
            System.out.println("Student Name: " + missingStudentOpt.get().getName());
        } else {
            System.out.println("Student not found"); // Prints this because ID 99 does not exist[cite: 14]
        }
    }
}