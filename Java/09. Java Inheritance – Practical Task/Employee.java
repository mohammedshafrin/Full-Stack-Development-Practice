class Employee {

    String name;
    int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Employee ID   : " + id);
        System.out.println("Employee Name : " + name);
    }
}

class FullTimeEmployee extends Employee {

    double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }


    public void calculateSalary() {
        System.out.println("Total Salary (Monthly Fixed): LKR " + monthlySalary);
    }
}

class PartTimeEmployee extends Employee {

    int hoursWorked;
    double hourlyRate;

    // கன்ஸ்ட்ரக்டர்
    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id); 
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public void calculateSalary() {
        double totalSalary = hoursWorked * hourlyRate;
        System.out.println("Calculated Salary (" + hoursWorked + " hours * LKR " + hourlyRate + "): LKR " + totalSalary);
    }
}

class EmployeeTask {
    public static void main(String[] args) {
        
        System.out.println("====== Full-Time Employee Details ======");

        FullTimeEmployee ftEmployee = new FullTimeEmployee("Mohamed Akmal", 101, 85000.0);
        ftEmployee.displayInfo();
        ftEmployee.calculateSalary();
        System.out.println("========================================\n");

        System.out.println("====== Part-Time Employee Details ======");

        PartTimeEmployee ptEmployee = new PartTimeEmployee("John Doe", 202, 45, 1200.0);
        ptEmployee.displayInfo();
        ptEmployee.calculateSalary();
        System.out.println("========================================");
    }
}