// ============================================================
// FILE NAME: EmployeeProcessing.java
// ============================================================

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Employee Processing System using Java Stream API & Predicate
 * Demonstrates functional programming with Stream operations
 * Tasks: Filter, Map, Sort, Count, Average, Group, Find, etc.
 */
public class EmployeeProcessing {
    
    // ============================================================
    // EMPLOYEE CLASS
    // ============================================================
    
    static class Employee {
        private int id;
        private String name;
        private int age;
        private double salary;
        private String department;
        
        // Constructor
        public Employee(int id, String name, int age, double salary, String department) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }
        
        // Getters
        public int getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
        public double getSalary() { return salary; }
        public String getDepartment() { return department; }
        
        // Setters
        public void setId(int id) { this.id = id; }
        public void setName(String name) { this.name = name; }
        public void setAge(int age) { this.age = age; }
        public void setSalary(double salary) { this.salary = salary; }
        public void setDepartment(String department) { this.department = department; }
        
        @Override
        public String toString() {
            return String.format("Employee{id=%d, name='%s', age=%d, salary=₹%.2f, dept='%s'}",
                id, name, age, salary, department);
        }
        
        // Display in table format
        public void display() {
            System.out.printf("| %-4d | %-15s | %-3d | ₹%-10.2f | %-12s |%n",
                id, name, age, salary, department);
        }
    }
    
    // ============================================================
    // MAIN CLASS
    // ============================================================
    
    private static List<Employee> employees = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("  EMPLOYEE PROCESSING SYSTEM");
        System.out.println("  Java Stream API & Predicate Implementation");
        System.out.println("=".repeat(80));
        
        // Initialize employee data
        initializeEmployees();
        
        // Display all employees
        System.out.println("\n📋 ALL EMPLOYEES:");
        System.out.println("+" + "-".repeat(6) + "+" + "-".repeat(17) + "+" + "-".repeat(5) + 
                          "+" + "-".repeat(14) + "+" + "-".repeat(14) + "+");
        System.out.printf("| %-4s | %-15s | %-3s | %-12s | %-12s |%n", 
            "ID", "Name", "Age", "Salary", "Department");
        System.out.println("+" + "-".repeat(6) + "+" + "-".repeat(17) + "+" + "-".repeat(5) + 
                          "+" + "-".repeat(14) + "+" + "-".repeat(14) + "+");
        employees.forEach(Employee::display);
        System.out.println("+" + "-".repeat(6) + "+" + "-".repeat(17) + "+" + "-".repeat(5) + 
                          "+" + "-".repeat(14) + "+" + "-".repeat(14) + "+");
        
        // Process all tasks
        System.out.println("\n" + "=".repeat(80));
        System.out.println("  PROCESSING EMPLOYEE DATA WITH STREAM API");
        System.out.println("=".repeat(80));
        
        // Task 01: Employees with salary > ₹60,000
        task01_EmployeesWithSalaryGreaterThan60000();
        
        // Task 02: IT department employees older than 30
        task02_ITEmployeesOlderThan30();
        
        // Task 03: Count employees older than 30
        task03_CountEmployeesOlderThan30();
        
        // Task 04: Highest paid employee
        task04_HighestPaidEmployee();
        
        // Task 05: Employee names in uppercase
        task05_EmployeeNamesUppercase();
        
        // Task 06: Average salary
        task06_AverageSalary();
        
        // Task 07: Group employees by department
        task07_GroupByDepartment();
        
        // Task 08: Sort employees by salary descending
        task08_SortBySalaryDescending();
        
        // Task 09: First employee with salary > ₹80,000
        task09_FirstEmployeeWithSalaryGreaterThan80000();
        
        // Task 10: Second highest salary
        task10_SecondHighestSalary();
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("  ✅ ALL TASKS COMPLETED SUCCESSFULLY!");
        System.out.println("=".repeat(80));
    }
    
    // ============================================================
    // TASK 01: Employees with salary > ₹60,000 using Predicate
    // ============================================================
    
    private static void task01_EmployeesWithSalaryGreaterThan60000() {
        System.out.println("\n" + "─".repeat(80));
        System.out.println("📌 TASK 01: Employees with salary > ₹60,000 (Using Predicate)");
        System.out.println("─".repeat(80));
        
        // Define Predicate for salary > 60000
        Predicate<Employee> highSalaryPredicate = emp -> emp.getSalary() > 60000;
        
        // Use filter with Predicate
        List<Employee> highSalaryEmployees = employees.stream()
            .filter(highSalaryPredicate)
            .collect(Collectors.toList());
        
        if (highSalaryEmployees.isEmpty()) {
            System.out.println("⚠️ No employees found with salary > ₹60,000");
        } else {
            System.out.println("\nEmployees with Salary > ₹60,000:");
            System.out.println("+" + "-".repeat(6) + "+" + "-".repeat(17) + "+" + "-".repeat(5) + 
                              "+" + "-".repeat(14) + "+" + "-".repeat(14) + "+");
            System.out.printf("| %-4s | %-15s | %-3s | %-12s | %-12s |%n", 
                "ID", "Name", "Age", "Salary", "Department");
            System.out.println("+" + "-".repeat(6) + "+" + "-".repeat(17) + "+" + "-".repeat(5) + 
                              "+" + "-".repeat(14) + "+" + "-".repeat(14) + "+");
            highSalaryEmployees.forEach(Employee::display);
            System.out.println("+" + "-".repeat(6) + "+" + "-".repeat(17) + "+" + "-".repeat(5) + 
                              "+" + "-".repeat(14) + "+" + "-".repeat(14) + "+");
            System.out.println("Total: " + highSalaryEmployees.size() + " employees");
        }
    }
    
    // ============================================================
    // TASK 02: IT department employees older than 30
    // ============================================================
    
    private static void task02_ITEmployeesOlderThan30() {
        System.out.println("\n" + "─".repeat(80));
        System.out.println("📌 TASK 02: IT department employees older than 30");
        System.out.println("─".repeat(80));
        
        // Combined Predicate: IT department AND age > 30
        Predicate<Employee> itDeptPredicate = emp -> "IT".equalsIgnoreCase(emp.getDepartment());
        Predicate<Employee> ageGreaterThan30 = emp -> emp.getAge() > 30;
        
        List<Employee> itEmployeesOlderThan30 = employees.stream()
            .filter(itDeptPredicate.and(ageGreaterThan30))
            .collect(Collectors.toList());
        
        if (itEmployeesOlderThan30.isEmpty()) {
            System.out.println("⚠️ No IT employees found older than 30");
        } else {
            System.out.println("\nIT Employees older than 30:");
            System.out.println("+" + "-".repeat(6) + "+" + "-".repeat(17) + "+" + "-".repeat(5) + 
                              "+" + "-".repeat(14) + "+" + "-".repeat(14) + "+");
            System.out.printf("| %-4s | %-15s | %-3s | %-12s | %-12s |%n", 
                "ID", "Name", "Age", "Salary", "Department");
            System.out.println("+" + "-".repeat(6) + "+" + "-".repeat(17) + "+" + "-".repeat(5) + 
                              "+" + "-".repeat(14) + "+" + "-".repeat(14) + "+");
            itEmployeesOlderThan30.forEach(Employee::display);
            System.out.println("+" + "-".repeat(6) + "+" + "-".repeat(17) + "+" + "-".repeat(5) + 
                              "+" + "-".repeat(14) + "+" + "-".repeat(14) + "+");
            System.out.println("Total: " + itEmployeesOlderThan30.size() + " employees");
        }
    }
    
    // ============================================================
    // TASK 03: Count employees older than 30
    // ============================================================
    
    private static void task03_CountEmployeesOlderThan30() {
        System.out.println("\n" + "─".repeat(80));
        System.out.println("📌 TASK 03: Count employees older than 30");
        System.out.println("─".repeat(80));
        
        long count = employees.stream()
            .filter(emp -> emp.getAge() > 30)
            .count();
        
        System.out.println("\n📊 Employees older than 30: " + count);
        System.out.println("   Total employees: " + employees.size());
        System.out.println("   Percentage: " + String.format("%.2f%%", (count * 100.0 / employees.size())));
    }
    
    // ============================================================
    // TASK 04: Highest paid employee
    // ============================================================
    
    private static void task04_HighestPaidEmployee() {
        System.out.println("\n" + "─".repeat(80));
        System.out.println("📌 TASK 04: Highest paid employee");
        System.out.println("─".repeat(80));
        
        Optional<Employee> highestPaid = employees.stream()
            .max(Comparator.comparingDouble(Employee::getSalary));
        
        if (highestPaid.isPresent()) {
            Employee emp = highestPaid.get();
            System.out.println("\n🏆 Highest Paid Employee:");
            System.out.println("   ID: " + emp.getId());
            System.out.println("   Name: " + emp.getName());
            System.out.println("   Age: " + emp.getAge());
            System.out.println("   Salary: ₹" + String.format("%.2f", emp.getSalary()));
            System.out.println("   Department: " + emp.getDepartment());
        } else {
            System.out.println("⚠️ No employees found");
        }
    }
    
    // ============================================================
    // TASK 05: Employee names in uppercase
    // ============================================================
    
    private static void task05_EmployeeNamesUppercase() {
        System.out.println("\n" + "─".repeat(80));
        System.out.println("📌 TASK 05: Employee names in uppercase");
        System.out.println("─".repeat(80));
        
        List<String> uppercaseNames = employees.stream()
            .map(Employee::getName)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        
        System.out.println("\n📝 Employee Names in Uppercase:");
        for (int i = 0; i < uppercaseNames.size(); i++) {
            System.out.printf("   %d. %s%n", i + 1, uppercaseNames.get(i));
        }
    }
    
    // ============================================================
    // TASK 06: Average salary
    // ============================================================
    
    private static void task06_AverageSalary() {
        System.out.println("\n" + "─".repeat(80));
        System.out.println("📌 TASK 06: Average salary");
        System.out.println("─".repeat(80));
        
        OptionalDouble averageSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .average();
        
        if (averageSalary.isPresent()) {
            System.out.println("\n💰 Average Salary: ₹" + String.format("%.2f", averageSalary.getAsDouble()));
            
            // Additional statistics
            DoubleSummaryStatistics stats = employees.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();
            
            System.out.println("   Highest Salary: ₹" + String.format("%.2f", stats.getMax()));
            System.out.println("   Lowest Salary: ₹" + String.format("%.2f", stats.getMin()));
            System.out.println("   Salary Range: ₹" + String.format("%.2f", stats.getMax() - stats.getMin()));
        } else {
            System.out.println("⚠️ No employees found");
        }
    }
    
    // ============================================================
    // TASK 07: Group employees by department
    // ============================================================
    
    private static void task07_GroupByDepartment() {
        System.out.println("\n" + "─".repeat(80));
        System.out.println("📌 TASK 07: Group employees by department");
        System.out.println("─".repeat(80));
        
        Map<String, List<Employee>> employeesByDept = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));
        
        System.out.println("\n🏢 Employees Grouped by Department:");
        employeesByDept.forEach((dept, empList) -> {
            System.out.println("\n   📂 Department: " + dept + " (" + empList.size() + " employees)");
            System.out.println("   " + "-".repeat(60));
            empList.forEach(emp -> 
                System.out.printf("      • %s (ID: %d, Age: %d, Salary: ₹%.2f)%n", 
                    emp.getName(), emp.getId(), emp.getAge(), emp.getSalary())
            );
        });
    }
    
    // ============================================================
    // TASK 08: Sort employees by salary descending
    // ============================================================
    
    private static void task08_SortBySalaryDescending() {
        System.out.println("\n" + "─".repeat(80));
        System.out.println("📌 TASK 08: Sort employees by salary descending");
        System.out.println("─".repeat(80));
        
        List<Employee> sortedBySalary = employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .collect(Collectors.toList());
        
        System.out.println("\n📊 Employees Sorted by Salary (Descending):");
        System.out.println("+" + "-".repeat(6) + "+" + "-".repeat(17) + "+" + "-".repeat(5) + 
                          "+" + "-".repeat(14) + "+" + "-".repeat(14) + "+");
        System.out.printf("| %-4s | %-15s | %-3s | %-12s | %-12s |%n", 
            "ID", "Name", "Age", "Salary", "Department");
        System.out.println("+" + "-".repeat(6) + "+" + "-".repeat(17) + "+" + "-".repeat(5) + 
                          "+" + "-".repeat(14) + "+" + "-".repeat(14) + "+");
        sortedBySalary.forEach(Employee::display);
        System.out.println("+" + "-".repeat(6) + "+" + "-".repeat(17) + "+" + "-".repeat(5) + 
                          "+" + "-".repeat(14) + "+" + "-".repeat(14) + "+");
        
        // Show ranking
        System.out.println("\n🏆 Salary Rankings:");
        for (int i = 0; i < sortedBySalary.size(); i++) {
            Employee emp = sortedBySalary.get(i);
            System.out.printf("   #%d: %s - ₹%.2f%n", i + 1, emp.getName(), emp.getSalary());
        }
    }
    
    // ============================================================
    // TASK 09: First employee with salary > ₹80,000
    // ============================================================
    
    private static void task09_FirstEmployeeWithSalaryGreaterThan80000() {
        System.out.println("\n" + "─".repeat(80));
        System.out.println("📌 TASK 09: First employee with salary > ₹80,000");
        System.out.println("─".repeat(80));
        
        Optional<Employee> firstHighSalary = employees.stream()
            .filter(emp -> emp.getSalary() > 80000)
            .findFirst();
        
        if (firstHighSalary.isPresent()) {
            Employee emp = firstHighSalary.get();
            System.out.println("\n🎯 First Employee with Salary > ₹80,000:");
            System.out.println("   ID: " + emp.getId());
            System.out.println("   Name: " + emp.getName());
            System.out.println("   Age: " + emp.getAge());
            System.out.println("   Salary: ₹" + String.format("%.2f", emp.getSalary()));
            System.out.println("   Department: " + emp.getDepartment());
        } else {
            System.out.println("\n⚠️ No employees found with salary > ₹80,000");
        }
    }
    
    // ============================================================
    // TASK 10: Second highest salary
    // ============================================================
    
    private static void task10_SecondHighestSalary() {
        System.out.println("\n" + "─".repeat(80));
        System.out.println("📌 TASK 10: Second highest salary");
        System.out.println("─".repeat(80));
        
        Optional<Double> secondHighestSalary = employees.stream()
            .map(Employee::getSalary)
            .distinct()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst();
        
        if (secondHighestSalary.isPresent()) {
            double secondHighest = secondHighestSalary.get();
            System.out.println("\n💎 Second Highest Salary: ₹" + String.format("%.2f", secondHighest));
            
            // Find employee(s) with second highest salary
            List<Employee> employeesWithSecondHighest = employees.stream()
                .filter(emp -> emp.getSalary() == secondHighest)
                .collect(Collectors.toList());
            
            System.out.println("\n📋 Employee(s) with Second Highest Salary:");
            employeesWithSecondHighest.forEach(emp -> 
                System.out.printf("   • %s (ID: %d, Dept: %s)%n", 
                    emp.getName(), emp.getId(), emp.getDepartment())
            );
            
            // Show top 3 salaries for context
            List<Double> top3Salaries = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
            
            System.out.println("\n🏆 Top 3 Salaries:");
            for (int i = 0; i < top3Salaries.size(); i++) {
                System.out.printf("   #%d: ₹%.2f%n", i + 1, top3Salaries.get(i));
            }
        } else {
            System.out.println("⚠️ Insufficient data to find second highest salary");
        }
    }
    
    // ============================================================
    // INITIALIZE EMPLOYEE DATA
    // ============================================================
    
    private static void initializeEmployees() {
        employees = Arrays.asList(
            new Employee(101, "Amit Sharma", 28, 55000.00, "IT"),
            new Employee(102, "Priya Patel", 35, 75000.00, "Finance"),
            new Employee(103, "Raj Kumar", 42, 92000.00, "IT"),
            new Employee(104, "Sneha Reddy", 29, 48000.00, "HR"),
            new Employee(105, "Vikram Singh", 38, 86000.00, "Marketing"),
            new Employee(106, "Ananya Gupta", 26, 52000.00, "IT"),
            new Employee(107, "Deepak Verma", 45, 110000.00, "Finance"),
            new Employee(108, "Kavya Nair", 31, 68000.00, "IT"),
            new Employee(109, "Rohit Mehra", 33, 78000.00, "Marketing"),
            new Employee(110, "Meera Iyer", 40, 95000.00, "Finance"),
            new Employee(111, "Arjun Reddy", 27, 45000.00, "HR"),
            new Employee(112, "Pooja Desai", 36, 82000.00, "IT"),
            new Employee(113, "Suresh Menon", 50, 105000.00, "Finance"),
            new Employee(114, "Neha Shah", 32, 67000.00, "Marketing"),
            new Employee(115, "Kiran Joshi", 29, 59000.00, "IT")
        );
        
        System.out.println("✅ " + employees.size() + " employees loaded successfully!");
    }
}
