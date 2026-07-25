import java.util.ArrayList;
import java.util.Scanner;

/*
 * Bus Reservation System
 *
 * Features:
 * 1. Add Bus
 * 2. View All Buses
 * 3. Update Bus Capacity
 * 4. Delete Bus
 * 5. Book Ticket
 * 6. View All Bookings
 * 7. Cancel Booking
 * 8. Exit
 */

// -------------------------
// BUS CLASS
// -------------------------
class Bus {

    private int busId;
    private String busNumber;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;

    public Bus(
            int busId,
            String busNumber,
            String source,
            String destination,
            int totalSeats) {

        this.busId = busId;
        this.busNumber = busNumber;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public int getBusId() {
        return busId;
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

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void updateCapacity(int newCapacity) {

        int bookedSeats = totalSeats - availableSeats;

        if (newCapacity < bookedSeats) {
            System.out.println(
                "Error: New capacity cannot be less than "
                + bookedSeats
                + " already booked seats."
            );
            return;
        }

        totalSeats = newCapacity;
        availableSeats = newCapacity - bookedSeats;

        System.out.println(
            "Bus capacity updated successfully."
        );
    }

    public boolean bookSeat() {

        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }

        return false;
    }

    public void cancelSeat() {

        if (availableSeats < totalSeats) {
            availableSeats++;
        }
    }

    public void displayBusDetails() {

        System.out.println(
            "Bus ID          : " + busId
        );

        System.out.println(
            "Bus Number      : " + busNumber
        );

        System.out.println(
            "Source          : " + source
        );

        System.out.println(
            "Destination     : " + destination
        );

        System.out.println(
            "Total Seats     : " + totalSeats
        );

        System.out.println(
            "Available Seats : " + availableSeats
        );

        System.out.println(
            "----------------------------------"
        );
    }
}


// -------------------------
// BOOKING CLASS
// -------------------------
class Booking {

    private int bookingId;
    private String passengerName;
    private String passengerPhone;
    private int busId;

    public Booking(
            int bookingId,
            String passengerName,
            String passengerPhone,
            int busId) {

        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.passengerPhone = passengerPhone;
        this.busId = busId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getBusId() {
        return busId;
    }

    public void displayBookingDetails() {

        System.out.println(
            "Booking ID      : " + bookingId
        );

        System.out.println(
            "Passenger Name   : " + passengerName
        );

        System.out.println(
            "Passenger Phone  : " + passengerPhone
        );

        System.out.println(
            "Bus ID           : " + busId
        );

        System.out.println(
            "----------------------------------"
        );
    }
}


// -------------------------
// MAIN CLASS
// -------------------------
public class BusReservationSystem {

    private static Scanner scanner =
        new Scanner(System.in);

    private static ArrayList<Bus> buses =
        new ArrayList<>();

    private static ArrayList<Booking> bookings =
        new ArrayList<>();

    private static int nextBusId = 1;

    private static int nextBookingId = 1;


    // -------------------------
    // MAIN METHOD
    // -------------------------
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
                    bookTicket();
                    break;

                case 6:
                    viewAllBookings();
                    break;

                case 7:
                    cancelBooking();
                    break;

                case 8:
                    System.out.println(
                        "\nThank you for using "
                        + "the Bus Reservation System."
                    );
                    break;

                default:
                    System.out.println(
                        "\nInvalid choice. "
                        + "Please try again."
                    );
            }

        } while (choice != 8);

        scanner.close();
    }


    // -------------------------
    // DISPLAY MENU
    // -------------------------
    private static void displayMenu() {

        System.out.println();
        System.out.println(
            "======================================"
        );

        System.out.println(
            "       BUS RESERVATION SYSTEM"
        );

        System.out.println(
            "======================================"
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
            "5. Book Ticket"
        );

        System.out.println(
            "6. View All Bookings"
        );

        System.out.println(
            "7. Cancel Booking"
        );

        System.out.println(
            "8. Exit"
        );

        System.out.println(
            "======================================"
        );
    }


    // -------------------------
    // ADD BUS
    // -------------------------
    private static void addBus() {

        System.out.println(
            "\n----- ADD NEW BUS -----"
        );

        System.out.print(
            "Enter bus number: "
        );

        String busNumber =
            scanner.nextLine();

        System.out.print(
            "Enter source: "
        );

        String source =
            scanner.nextLine();

        System.out.print(
            "Enter destination: "
        );

        String destination =
            scanner.nextLine();

        int totalSeats =
            getIntegerInput(
                "Enter total seat capacity: "
            );

        if (totalSeats <= 0) {

            System.out.println(
                "Seat capacity must be greater than zero."
            );

            return;
        }

        Bus bus = new Bus(
            nextBusId,
            busNumber,
            source,
            destination,
            totalSeats
        );

        buses.add(bus);

        System.out.println(
            "\nBus added successfully."
        );

        System.out.println(
            "Assigned Bus ID: "
            + nextBusId
        );

        nextBusId++;
    }


    // -------------------------
    // VIEW ALL BUSES
    // -------------------------
    private static void viewAllBuses() {

        System.out.println(
            "\n----- ALL AVAILABLE BUSES -----"
        );

        if (buses.isEmpty()) {

            System.out.println(
                "No buses available."
            );

            return;
        }

        for (Bus bus : buses) {

            bus.displayBusDetails();
        }
    }


    // -------------------------
    // UPDATE BUS CAPACITY
    // -------------------------
    private static void updateBusCapacity() {

        System.out.println(
            "\n----- UPDATE BUS CAPACITY -----"
        );

        int busId =
            getIntegerInput(
                "Enter Bus ID: "
            );

        Bus bus =
            findBusById(busId);

        if (bus == null) {

            System.out.println(
                "Bus not found."
            );

            return;
        }

        int newCapacity =
            getIntegerInput(
                "Enter new capacity: "
            );

        if (newCapacity <= 0) {

            System.out.println(
                "Capacity must be greater than zero."
            );

            return;
        }

        bus.updateCapacity(newCapacity);
    }


    // -------------------------
    // DELETE BUS
    // -------------------------
    private static void deleteBus() {

        System.out.println(
            "\n----- DELETE BUS -----"
        );

        int busId =
            getIntegerInput(
                "Enter Bus ID: "
            );

        Bus bus =
            findBusById(busId);

        if (bus == null) {

            System.out.println(
                "Bus not found."
            );

            return;
        }

        boolean hasBookings = false;

        for (Booking booking : bookings) {

            if (booking.getBusId() == busId) {

                hasBookings = true;
                break;
            }
        }

        if (hasBookings) {

            System.out.println(
                "Cannot delete this bus."
            );

            System.out.println(
                "There are active bookings "
                + "for this bus."
            );

            return;
        }

        buses.remove(bus);

        System.out.println(
            "Bus deleted successfully."
        );
    }


    // -------------------------
    // BOOK TICKET
    // -------------------------
    private static void bookTicket() {

        System.out.println(
            "\n----- BOOK TICKET -----"
        );

        int busId =
            getIntegerInput(
                "Enter Bus ID: "
            );

        Bus bus =
            findBusById(busId);

        if (bus == null) {

            System.out.println(
                "Bus not found."
            );

            return;
        }

        if (bus.getAvailableSeats() <= 0) {

            System.out.println(
                "Sorry, no seats are available."
            );

            return;
        }

        System.out.print(
            "Enter passenger name: "
        );

        String passengerName =
            scanner.nextLine();

        if (passengerName.trim().isEmpty()) {

            System.out.println(
                "Passenger name cannot be empty."
            );

            return;
        }

        System.out.print(
            "Enter passenger phone number: "
        );

        String passengerPhone =
            scanner.nextLine();

        if (passengerPhone.trim().isEmpty()) {

            System.out.println(
                "Phone number cannot be empty."
            );

            return;
        }

        boolean seatBooked =
            bus.bookSeat();

        if (seatBooked) {

            Booking booking =
                new Booking(
                    nextBookingId,
                    passengerName,
                    passengerPhone,
                    busId
                );

            bookings.add(booking);

            System.out.println(
                "\nTicket booked successfully."
            );

            System.out.println(
                "Booking ID: "
                + nextBookingId
            );

            System.out.println(
                "Remaining Seats: "
                + bus.getAvailableSeats()
            );

            nextBookingId++;
        }
    }


    // -------------------------
    // VIEW ALL BOOKINGS
    // -------------------------
    private static void viewAllBookings() {

        System.out.println(
            "\n----- ALL BOOKINGS -----"
        );

        if (bookings.isEmpty()) {

            System.out.println(
                "No bookings available."
            );

            return;
        }

        for (Booking booking : bookings) {

            booking.displayBookingDetails();
        }
    }


    // -------------------------
    // CANCEL BOOKING
    // -------------------------
    private static void cancelBooking() {

        System.out.println(
            "\n----- CANCEL BOOKING -----"
        );

        int bookingId =
            getIntegerInput(
                "Enter Booking ID: "
            );

        Booking booking =
            findBookingById(bookingId);

        if (booking == null) {

            System.out.println(
                "Booking not found."
            );

            return;
        }

        Bus bus =
            findBusById(
                booking.getBusId()
            );

        if (bus != null) {

            bus.cancelSeat();
        }

        bookings.remove(booking);

        System.out.println(
            "Booking cancelled successfully."
        );

        System.out.println(
            "The seat is now available again."
        );
    }


    // -------------------------
    // FIND BUS BY ID
    // -------------------------
    private static Bus findBusById(
            int busId) {

        for (Bus bus : buses) {

            if (bus.getBusId() == busId) {

                return bus;
            }
        }

        return null;
    }


    // -------------------------
    // FIND BOOKING BY ID
    // -------------------------
    private static Booking findBookingById(
            int bookingId) {

        for (Booking booking : bookings) {

            if (
                booking.getBookingId()
                == bookingId
            ) {

                return booking;
            }
        }

        return null;
    }


    // -------------------------
    // INTEGER INPUT VALIDATION
    // -------------------------
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

            } catch (NumberFormatException e) {

                System.out.println(
                    "Invalid input."
                    + " Please enter a number."
                );
            }
        }
    }
}