class Report {
    public synchronized void writeResult(String student, int marks) {
        System.out.println("Writing to Report -> Student: " + student + ", Marks: " + marks);
    }
}

public class Task03 {
    public static void main(String[] args) throws InterruptedException {
        Report report = new Report();
        Thread t1 = new Thread(() -> report.writeResult("Akmal", 95));
        t1.start();
        t1.join();
        System.out.println("Is thread alive? " + t1.isAlive());
    }
}