class PrintService {
    public synchronized void printDocument(String empName) {
        System.out.println(empName + " is printing...");
    }
}

public class Task04 {
    public static void main(String[] args) throws InterruptedException {
        PrintService ps = new PrintService();
        Thread t1 = new Thread(() -> ps.printDocument("Emp-1 (Normal)"));
        Thread t2 = new Thread(() -> ps.printDocument("Emp-2 (High Priority)"));

        t2.setPriority(Thread.MAX_PRIORITY); // உயரிய முன்னுரிமை
        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println("All print jobs completed.");
    }
}