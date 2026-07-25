class Cab {
    private boolean isBooked = false; 

    public synchronized void bookCab(String customerName) {
        if (!isBooked) {
            System.out.println(customerName + " successfully booked the cab.");
            isBooked = true;
        } else {
            System.out.println(customerName + " failed to book the cab. Cab is already booked.");
        }
    }
}

class Customer extends Thread {
    private Cab cab;
    private String customerName;

    public Customer(Cab cab, String name) {
        this.cab = cab;
        this.customerName = name;
    }

    @Override
    public void run() {

        cab.bookCab(customerName);
    }
}

public class CabBookingSystem {
    public static void main(String[] args) {
        Cab myCab = new Cab();

        Customer c1 = new Customer(myCab, "Customer 1");
        Customer c2 = new Customer(myCab, "Customer 2");
        Customer c3 = new Customer(myCab, "Customer 3");

        c1.start();
        c2.start();
        c3.start();
    }
}