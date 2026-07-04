class NumberPrinter {
    public synchronized void print(boolean isEven, int limit) {
        for (int i = (isEven ? 2 : 1); i <= limit; i += 2) {
            System.out.println((isEven ? "Even: " : "Odd: ") + i);
            try { Thread.sleep(300); } catch (InterruptedException e) {}
        }
    }
}

public class Task02 {
    public static void main(String[] args) {
        NumberPrinter np = new NumberPrinter();
        new Thread(() -> np.print(false, 10)).start();
        new Thread(() -> np.print(true, 10)).start();
    }
}