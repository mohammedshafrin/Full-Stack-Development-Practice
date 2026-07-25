import java.util.ArrayList;
import java.util.Scanner;

// =====================================================
// BUS CLASS
// =====================================================
class Bus {

    private String busNumber;
    private String source;
    private String destination;
    private int capacity;
    private int bookedSeats;

    public Bus(
            String busNumber,
            String source,
            String destination,
            int capacity) {

        this.busNumber = busNumber;
        this.source = source;
        this.destination = destination;
        this.capacity = capacity;
        this.bookedSeats = 0;
    }

    // Getters
    public String getBusNumber() {
        return busNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    // Update bus capacity
    public boolean updateCapacity(int newCapacity) {

        if (newCapacity < bookedSeats) {
            return false;
        }

        capacity = newCapacity;
        return true;
    }

    // Check available seats
    public int getAvailableSeats() {
        return capacity - bookedSeats;
    }

    // Book one seat
    public boolean bookSeat() {

        if (getAvailableSeats() > 0) {
            bookedSeats++;
            return true;
        }

        return false;
    }

    // Cancel one booked seat
    public void cancelSeat() {

        if (bookedSeats > 0) {
            bookedSeats--;
        }
    }

    // Display bus details
    public void displayBusDetails() {

        System.out.println("----------------------------------------");
        System.out.println("Bus Number      : " + busNumber);
        System.out.println("Source          : " + source);
        System.out.println("Destination     : " + destination);
        System.out.println("Capacity        : " + capacity);
        System.out.println("Booked Seats    : " + bookedSeats);
        System.out.println("Available Seats : " + getAvailableSeats());
        System.out.println("----------------------------------------");
    }
}


// =====================================================
// BOOKING CLASS
// =====================================================
class Booking {

    private String passengerId;
    private String passengerName;
    private String busNumber;
    private String source;
    private String destination;

    public Booking(
            String passengerId,
            String passengerName,
            String busNumber,
            String source,
            String destination) {

        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.busNumber = busNumber;
        this.source = source;
        this.destination = destination;
    }

    // Getters
    public String getPassengerId() {
        return passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    // Display booking details
    public void displayBookingDetails() {

        System.out.println("----------------------------------------");
        System.out.println("Passenger ID   : " + passengerId);
        System.out.println("Passenger Name : " + passengerName);
        System.out.println("Bus Number     : " + busNumber);
        System.out.println("Source         : " + source);
        System.out.println("Destination    : " + destination);
        System.out.println("----------------------------------------");
    }
}


// =====================================================
// MAIN BUS RESERVATION SYSTEM CLASS
// =====================================================
public class BusReservationSystem {

    private static Scanner scanner =
            new Scanner(System.in);

    private static ArrayList<Bus> buses =
            new ArrayList<>();

    private static ArrayList<Booking> bookings =
            new ArrayList<>();


    // =================================================
    // MAIN METHOD
    // =================================================
    public static void main(String[] args) {

        int choice;

        do {

            displayMenu();

            choice = getIntegerInput(
                    "Enter your choice: "
            );

            switch (choice) {

                case 1:
                    addBus();
                    break;

                case 2:
                    viewAllBuses();
                    break;

                case 3:
                    updateBusCapacity();
                    break;

                case 4:
                    deleteBus();
                    break;

                case 5:
                    searchBus();
                    break;

                case 6:
                    bookTicket();
                    break;

                case 7:
                    viewAllBookings();
                    break;

                case 8:
                    cancelBooking();
                    break;

                case 9:
                    System.out.println();
                    System.out.println(
                            "Thank you for using "
                            + "the Bus Reservation System."
                    );

                    System.out.println(
                            "Application closed safely."
                    );
                    break;

                default:
                    System.out.println();
                    System.out.println(
                            "Invalid choice."
                    );

                    System.out.println(
                            "Please select a number "
                            + "between 1 and 9."
                    );
            }

        } while (choice != 9);

        scanner.close();
    }


    // =================================================
    // DISPLAY MENU
    // =================================================
    private static void displayMenu() {

        System.out.println();
        System.out.println(
                "========================================"
        );

        System.out.println(
                "       BUS RESERVATION SYSTEM"
        );

        System.out.println(
                "========================================"
        );

        System.out.println(
                "1. Add Bus"
        );

        System.out.println(
                "2. View All Buses"
        );

        System.out.println(
                "3. Update Bus Capacity"
        );

        System.out.println(
                "4. Delete Bus"
        );

        System.out.println(
                "5. Search Bus"
        );

        System.out.println(
                "6. Book Ticket"
        );

        System.out.println(
                "7. View All Bookings"
        );

        System.out.println(
                "8. Cancel Booking"
        );

        System.out.println(
                "9. Exit"
        );

        System.out.println(
                "========================================"
        );
    }


    // =================================================
    // MODULE 01 - ADD BUS
    // =================================================
    private static void addBus() {

        System.out.println();
        System.out.println(
                "------------ ADD NEW BUS ------------"
        );

        String busNumber =
                getNonEmptyString(
                        "Enter bus number: "
                );

        // Check whether bus number already exists
        if (findBusByNumber(busNumber) != null) {

            System.out.println();
            System.out.println(
                    "Error: Bus number already exists."
            );

            return;
        }

        String source =
                getNonEmptyString(
                        "Enter source: "
                );

        String destination =
                getNonEmptyString(
                        "Enter destination: "
                );

        int capacity =
                getPositiveInteger(
                        "Enter bus capacity: "
                );

        Bus bus = new Bus(
                busNumber,
                source,
                destination,
                capacity
        );

        buses.add(bus);

        System.out.println();
        System.out.println(
                "Bus added successfully."
        );
    }


    // =================================================
    // MODULE 01 - VIEW ALL BUSES
    // =================================================
    private static void viewAllBuses() {

        System.out.println();
        System.out.println(
                "------------ ALL BUSES ------------"
        );

        if (buses.isEmpty()) {

            System.out.println(
                    "No buses are available."
            );

            return;
        }

        for (Bus bus : buses) {

            bus.displayBusDetails();
        }
    }


    // =================================================
    // MODULE 01 - UPDATE BUS CAPACITY
    // =================================================
    private static void updateBusCapacity() {

        System.out.println();
        System.out.println(
                "-------- UPDATE BUS CAPACITY --------"
        );

        String busNumber =
                getNonEmptyString(
                        "Enter bus number: "
                );

        Bus bus =
                findBusByNumber(busNumber);

        if (bus == null) {

            System.out.println(
                    "Error: Bus not found."
            );

            return;
        }

        int newCapacity =
                getPositiveInteger(
                        "Enter new capacity: "
                );

        if (bus.updateCapacity(newCapacity)) {

            System.out.println();
            System.out.println(
                    "Bus capacity updated successfully."
            );

        } else {

            System.out.println();
            System.out.println(
                    "Error: New capacity cannot be "
                    + "less than booked seats."
            );
        }
    }


    // =================================================
    // MODULE 01 - DELETE BUS
    // =================================================
    private static void deleteBus() {

        System.out.println();
        System.out.println(
                "------------ DELETE BUS ------------"
        );

        String busNumber =
                getNonEmptyString(
                        "Enter bus number: "
                );

        Bus bus =
                findBusByNumber(busNumber);

        if (bus == null) {

            System.out.println(
                    "Error: Bus not found."
            );

            return;
        }

        // Prevent deletion if the bus has bookings
        if (bus.getBookedSeats() > 0) {

            System.out.println();
            System.out.println(
                    "Cannot delete this bus."
            );

            System.out.println(
                    "This bus has active bookings."
            );

            return;
        }

        buses.remove(bus);

        System.out.println();
        System.out.println(
                "Bus deleted successfully."
        );
    }


    // =================================================
    // OPTIONAL - SEARCH BUS
    // =================================================
    private static void searchBus() {

        System.out.println();
        System.out.println(
                "------------ SEARCH BUS ------------"
        );

        String busNumber =
                getNonEmptyString(
                        "Enter bus number: "
                );

        Bus bus =
                findBusByNumber(busNumber);

        if (bus == null) {

            System.out.println(
                    "Bus not found."
            );

        } else {

            System.out.println(
                    "Bus found successfully."
            );

            bus.displayBusDetails();
        }
    }


    // =================================================
    // MODULE 02 - BOOK TICKET
    // =================================================
    private static void bookTicket() {

        System.out.println();
        System.out.println(
                "------------ BOOK TICKET ------------"
        );

        String passengerId =
                getNonEmptyString(
                        "Enter passenger ID: "
                );

        // Ensure passenger ID is unique
        if (findBookingByPassengerId(
                passengerId
        ) != null) {

            System.out.println();
            System.out.println(
                    "Error: Passenger ID already exists."
            );

            return;
        }

        String passengerName =
                getNonEmptyString(
                        "Enter passenger name: "
                );

        String busNumber =
                getNonEmptyString(
                        "Enter bus number: "
                );

        Bus bus =
                findBusByNumber(busNumber);

        if (bus == null) {

            System.out.println();
            System.out.println(
                    "Error: Bus not found."
            );

            return;
        }

        // Check seat availability
        if (bus.getAvailableSeats() <= 0) {

            System.out.println();
            System.out.println(
                    "Sorry, no seats are available."
            );

            return;
        }

        // Book one seat
        if (bus.bookSeat()) {

            Booking booking =
                    new Booking(
                            passengerId,
                            passengerName,
                            bus.getBusNumber(),
                            bus.getSource(),
                            bus.getDestination()
                    );

            bookings.add(booking);

            System.out.println();
            System.out.println(
                    "Ticket booked successfully."
            );

            System.out.println(
                    "Passenger ID: "
                    + passengerId
            );

            System.out.println(
                    "Bus Number: "
                    + bus.getBusNumber()
            );

            System.out.println(
                    "Remaining Seats: "
                    + bus.getAvailableSeats()
            );
        }
    }


    // =================================================
    // MODULE 03 - VIEW BOOKINGS
    // =================================================
    private static void viewAllBookings() {

        System.out.println();
        System.out.println(
                "------------ ALL BOOKINGS ------------"
        );

        if (bookings.isEmpty()) {

            System.out.println(
                    "No bookings are available."
            );

            return;
        }

        for (Booking booking : bookings) {

            booking.displayBookingDetails();
        }
    }


    // =================================================
    // MODULE 04 - CANCEL BOOKING
    // =================================================
    private static void cancelBooking() {

        System.out.println();
        System.out.println(
                "------------ CANCEL BOOKING ------------"
        );

        String passengerId =
                getNonEmptyString(
                        "Enter passenger ID: "
                );

        Booking booking =
                findBookingByPassengerId(
                        passengerId
                );

        if (booking == null) {

            System.out.println();
            System.out.println(
                    "Error: Booking not found."
            );

            return;
        }

        // Find the related bus
        Bus bus =
                findBusByNumber(
                        booking.getBusNumber()
                );

        if (bus != null) {

            // Decrease booked seat count
            bus.cancelSeat();
        }

        // Remove booking
        bookings.remove(booking);

        System.out.println();
        System.out.println(
                "Booking cancelled successfully."
        );

        System.out.println(
                "Passenger ID: "
                + passengerId
        );

        System.out.println(
                "The seat is now available."
        );
    }


    // =================================================
    // FIND BUS BY BUS NUMBER
    // =================================================
    private static Bus findBusByNumber(
            String busNumber) {

        for (Bus bus : buses) {

            if (
                    bus.getBusNumber()
                            .equalsIgnoreCase(
                                    busNumber
                            )
            ) {

                return bus;
            }
        }

        return null;
    }


    // =================================================
    // FIND BOOKING BY PASSENGER ID
    // =================================================
    private static Booking findBookingByPassengerId(
            String passengerId) {

        for (Booking booking : bookings) {

            if (
                    booking.getPassengerId()
                            .equalsIgnoreCase(
                                    passengerId
                            )
            ) {

                return booking;
            }
        }

        return null;
    }


    // =================================================
    // GET INTEGER INPUT
    // =================================================
    private static int getIntegerInput(
            String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine();

            try {

                return Integer.parseInt(
                        input
                );

            } catch (
                    NumberFormatException e
            ) {

                System.out.println();
                System.out.println(
                        "Invalid input."
                );

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }


    // =================================================
    // GET POSITIVE INTEGER
    // =================================================
    private static int getPositiveInteger(
            String message) {

        while (true) {

            int number =
                    getIntegerInput(message);

            if (number > 0) {

                return number;
            }

            System.out.println();
            System.out.println(
                    "Please enter a number "
                    + "greater than zero."
            );
        }
    }


    // =================================================
    // GET NON-EMPTY STRING
    // =================================================
    private static String getNonEmptyString(
            String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine().trim();

            if (!input.isEmpty()) {

                return input;
            }

            System.out.println();
            System.out.println(
                    "Input cannot be empty."
            );
        }
    }
}