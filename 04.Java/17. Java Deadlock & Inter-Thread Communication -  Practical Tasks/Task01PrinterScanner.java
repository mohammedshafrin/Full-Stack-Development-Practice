class Resource {
    private final String resourceName;
    private boolean available = true;

    public Resource(String resourceName) {
        this.resourceName = resourceName;
    }

    public synchronized void acquire() throws InterruptedException {
        while (!available) {
            System.out.println(
                Thread.currentThread().getName()
                + " is waiting for " + resourceName
            );
            wait();
        }

        available = false;

        System.out.println(
            Thread.currentThread().getName()
            + " acquired " + resourceName
        );
    }

    public synchronized void release() {
        available = true;

        System.out.println(
            Thread.currentThread().getName()
            + " released " + resourceName
        );

        notifyAll();
    }
}

public class Task01PrinterScanner {

    public static void main(String[] args) {

        Resource printer = new Resource("Printer");
        Resource scanner = new Resource("Scanner");

        Thread user1 = new Thread(() -> {
            try {
                printer.acquire();
                Thread.sleep(100);

                scanner.acquire();

                System.out.println(
                    "User1 is using Printer and Scanner"
                );

                Thread.sleep(500);

                scanner.release();
                printer.release();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "User1");

        Thread user2 = new Thread(() -> {
            try {
                printer.acquire();
                Thread.sleep(100);

                scanner.acquire();

                System.out.println(
                    "User2 is using Printer and Scanner"
                );

                Thread.sleep(500);

                scanner.release();
                printer.release();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "User2");

        user1.start();
        user2.start();
    }
}