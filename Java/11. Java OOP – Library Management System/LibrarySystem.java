
interface Borrowable {
    void borrowItem(); 
    void returnItem(); 
}


abstract class LibraryItem {

    public abstract void displayInfo(); 
}

class Book extends LibraryItem implements Borrowable {

    private int bookId; 
    private String title;
    private String author;
    private double price;
    private boolean isBorrowed = false; 

    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public void displayInfo() {
        System.out.println("Book ID    : " + bookId);
        System.out.println("Title      : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Price      : LKR " + price);
        System.out.println("Status     : " + (isBorrowed ? "Borrowed" : "Available"));
    }

    @Override
    public void borrowItem() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Notification: The book '" + title + "' has been successfully borrowed.");
        } else {
            System.out.println("Notification: Sorry, '" + title + "' is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Notification: The book '" + title + "' has been successfully returned.");
        } else {
            System.out.println("Notification: This book was not borrowed.");
        }
    }
}

class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Student extends Person implements Borrowable {
    private String batch;

    public Student(String name, int id, String batch) {
        super(name, id); 
        this.batch = batch;
    }

    public void displayStudent() {
        System.out.println("Student Name : " + name + " (ID: " + id + ") | Batch: " + batch);
    }

    @Override
    public void borrowItem() {
        System.out.println("Student " + name + " is requesting to borrow a book.");
    }

    @Override
    public void returnItem() {
        System.out.println("Student " + name + " is returning a book.");
    }
}

class Librarian extends Person {
    private String employeeRole;

    public Librarian(String name, int id, String employeeRole) {
        super(name, id);
        this.employeeRole = employeeRole;
    }

    public void displayLibrarian() {
        System.out.println("Librarian Name: " + name + " (ID: " + id + ") | Role: " + employeeRole);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        
        System.out.println("==================================================");
        System.out.println("     LIBRARY MANAGEMENT SYSTEM (OOP DEMO)        ");
        System.out.println("==================================================\n");

        Student student = new Student("Mohamed Akmal", 501, "Batch 26");
        Librarian librarian = new Librarian("Sarah John", 1001, "Head Librarian");
        
        System.out.println("--- 1. Inheritance & User Info ---");
        student.displayStudent();
        librarian.displayLibrarian();
        System.out.println();

        System.out.println("--- 2. Runtime Polymorphism & Abstraction ---");

        LibraryItem item = new Book(101, "Java Full Stack Guide", "James Gosling", 2500.0);
        item.displayInfo();
        System.out.println();

        System.out.println("--- 3. Encapsulation (Using Getters/Setters) ---");

        Book myBook = (Book) item; 
        System.out.println("Old Price: LKR " + myBook.getPrice());
        myBook.setPrice(2950.0);
        System.out.println("Updated Price via Setter: LKR " + myBook.getPrice());
        System.out.println();

        System.out.println("--- 4. Interface Implementation (Borrow/Return) ---");
        student.borrowItem();
        myBook.borrowItem();
        System.out.println();
        
        System.out.println("--- 5. Checking Updated Book Status ---");
        myBook.displayInfo();
        System.out.println();

        System.out.println("--- 6. Returning the Item ---");
        student.returnItem();
        myBook.returnItem();
        System.out.println("==================================================");
    }
}