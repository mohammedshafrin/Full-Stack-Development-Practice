class Printer {
    public synchronized void printDetails(String name) {
        System.out.println("Thread started: " + name);
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        System.out.println("Thread finished: " + name);
    }
}

public class Task01 {
    public static void main(String[] args) throws InterruptedException {
        Printer p = new Printer();
        Thread t1 = new Thread(() -> p.printDetails("Thread-1"));
        Thread t2 = new Thread(() -> p.printDetails("Thread-2"));
        Thread t3 = new Thread(() -> p.printDetails("Thread-3"));

        t1.start(); t2.start(); t3.start();
        
        System.out.println("Is t1 alive? " + t1.isAlive());
        t1.join(); t2.join(); t3.join();
        System.out.println("All threads finished.");
    }
}