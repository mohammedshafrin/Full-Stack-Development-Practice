public class Student {

    int studentId;
    String studentName;
    String course;

    Student() {
        studentId   = 0;
        studentName = "Unknown";
        course      = "Not Assigned";
        System.out.println("Default Constructor called!");
    }

    Student(int studentId, String studentName, String course) {
        this.studentId   = studentId;
        this.studentName = studentName;
        this.course      = course;
        System.out.println("Parameterized Constructor called!");
    }

    Student(Student other) {
        this.studentId   = other.studentId;
        this.studentName = other.studentName;
        this.course      = other.course;
        System.out.println("Copy Constructor called!");
    }

    void displayDetails() {
        System.out.println("-----------------------------");
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + studentName);
        System.out.println("Course       : " + course);
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {

        System.out.println("===== Student Details =====\n");

        Student student1 = new Student();
        student1.displayDetails();

        Student student2 = new Student(101, "Arun Kumar", "Computer Science");
        student2.displayDetails();

        Student student3 = new Student(student2);
        student3.displayDetails();
    }
}