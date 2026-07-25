import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Create an Employee class with id, name, and salary fields[cite: 14]
class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Salary=" + salary + "]";
    }
}

public class Task02_EmployeeLookup {
    static List<Employee> employees = Arrays.asList(
        new Employee(101, "Alice", 75000),
        new Employee(102, "Bob", 85000)
    );

    // Implement findEmployee(int id) returning Optional<Employee>[cite: 14]
    public static Optional<Employee> findEmployee(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    public static void main(String[] args) {
        // Create a default employee object[cite: 14]
        Employee defaultEmployee = new Employee(0, "Unknown Employee", 0.0);

        // Test Case 1: Valid ID
        // Use orElse() to return a default employee object when not found[cite: 14]
        Employee emp1 = findEmployee(101).orElse(defaultEmployee);
        System.out.println("Search Result for ID 101: " + emp1);

        // Test Case 2: Invalid ID (will return the default object)
        Employee emp2 = findEmployee(999).orElse(defaultEmployee);
        System.out.println("Search Result for ID 999: " + emp2);
    }
}