// MARS TECH - Java OOP Library Management System Assignment

// ==========================================
// 1. INTERFACE CONCEPT (இன்டர்ஃபேஸ் கொள்கை)
// ==========================================
interface Borrowable {
    void borrowItem(); // புத்தகம் எடுக்க [cite: 370]
    void returnItem(); // புத்தகம் திரும்ப ஒப்படைக்க [cite: 371]
}

// ==========================================
// 2. ABSTRACTION CONCEPT (அப்ஸ்ட்ராக்ஷன் கொள்கை)
// ==========================================
abstract class LibraryItem {
    // அப்ஸ்ட்ராக்ட் மெத்தட்: குழந்தை கிளாஸ் இதை கண்டிப்பாக ஓவர்ரைடு செய்ய வேண்டும் [cite: 359, 362]
    public abstract void displayInfo(); 
}

// ==========================================
// 3. ENCAPSULATION & POLYMORPHISM (Book Class)
// ==========================================
// Book கிளாஸ் LibraryItem-ஐ நீட்டித்து, Borrowable இன்டர்ஃபேஸை செயல்படுத்துகிறது [cite: 362, 373, 375]
class Book extends LibraryItem implements Borrowable {
    // Encapsulation: மாறிகளை வெளியில் இருந்து நேரடியாக மாற்ற முடியாதபடி private ஆக்குகிறோம் [cite: 342, 343]
    private int bookId; [cite: 344]
    private String title; [cite: 345]
    private String author; [cite: 346]
    private double price; [cite: 347]
    private boolean isBorrowed = false; // புத்தகத்தின் நிலையைக் குறிக்க

    // கன்ஸ்ட்ரக்டர் (Constructor)
    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // கெட்டர் மற்றும் செட்டர் மெத்தட்கள் (Getter and Setter Methods) [cite: 349]
    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Runtime Polymorphism: பெற்றோர் கிளாஸ் மெத்தடை மாற்றி எழுதுகிறோம் (Method Overriding) [cite: 363, 364, 365]
    @Override
    public void displayInfo() {
        System.out.println("Book ID    : " + bookId);
        System.out.println("Title      : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Price      : LKR " + price);
        System.out.println("Status     : " + (isBorrowed ? "Borrowed" : "Available"));
    }

    // Interface Methods Implementation [cite: 373, 386]
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

// ==========================================
// 4. INHERITANCE CONCEPT (மரபுரிமை கொள்கை)
// ==========================================
// பெற்றோர் கிளாஸ் (Base Class) [cite: 350, 351]
class Person {
    String name; [cite: 357]
    int id; [cite: 357]

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

// குழந்தை கிளாஸ் 1: Student (Person-ஐ நீட்டித்து, Borrowable-ஐ செயல்படுத்துகிறது) [cite: 353, 354, 373, 374]
class Student extends Person implements Borrowable {
    private String batch;

    public Student(String name, int id, String batch) {
        super(name, id); // பெற்றோர் கிளாஸ் கன்ஸ்ட்ரக்டரை அழைத்தல் [cite: 357]
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

// குழந்தை கிளாஸ் 2: Librarian (Person-ஐ மட்டும் நீட்டிக்கிறது) [cite: 353, 355, 357]
class Librarian extends Person {
    private String employeeRole;

    public Librarian(String name, int id, String employeeRole) {
        super(name, id); [cite: 357]
        this.employeeRole = employeeRole;
    }

    public void displayLibrarian() {
        System.out.println("Librarian Name: " + name + " (ID: " + id + ") | Role: " + employeeRole);
    }
}

// ==========================================
// 5. MAIN MAIN METHOD CLASS (முதன்மை கிளாஸ்)
// ==========================================
public class LibrarySystem {
    public static void main(String[] args) {
        
        System.out.println("==================================================");
        System.out.println("     LIBRARY MANAGEMENT SYSTEM (OOP DEMO)        ");
        System.out.println("==================================================\n");

        // அ) ஆப்ஜெக்ட்களை உருவாக்குதல் (Object Creation) [cite: 378, 379]
        Student student = new Student("Mohamed Akmal", 501, "Batch 26"); [cite: 379]
        Librarian librarian = new Librarian("Sarah John", 1001, "Head Librarian"); [cite: 379]
        
        System.out.println("--- 1. Inheritance & User Info ---"); [cite: 382]
        student.displayStudent();
        librarian.displayLibrarian();
        System.out.println();

        System.out.println("--- 2. Runtime Polymorphism & Abstraction ---"); [cite: 383, 384]
        // பெற்றோர் அப்ஸ்ட்ராக்ட் கிளாஸ் குறிப்பிற்கு குழந்தை ஆப்ஜெக்ட்டை ஒதுக்குகிறோம் [cite: 366]
        LibraryItem item = new Book(101, "Java Full Stack Guide", "James Gosling", 2500.0); [cite: 366, 378]
        item.displayInfo(); // இது Book கிளாஸின் displayInfo()-வை இயக்கும் (Overriding) [cite: 367]
        System.out.println();

        System.out.println("--- 3. Encapsulation (Using Getters/Setters) ---"); [cite: 381]
        // நேரடியாக மாற்றாமல் Book குறிப்பிற்கு மாற்றி செட்டர் மூலம் விலையை மாற்றுகிறோம்
        Book myBook = (Book) item; 
        System.out.println("Old Price: LKR " + myBook.getPrice());
        myBook.setPrice(2950.0);
        System.out.println("Updated Price via Setter: LKR " + myBook.getPrice()); [cite: 349, 381]
        System.out.println();

        System.out.println("--- 4. Interface Implementation (Borrow/Return) ---"); [cite: 386]
        student.borrowItem(); [cite: 386]
        myBook.borrowItem();
        System.out.println();
        
        System.out.println("--- 5. Checking Updated Book Status ---");
        myBook.displayInfo();
        System.out.println();

        System.out.println("--- 6. Returning the Item ---");
        student.returnItem(); [cite: 386]
        myBook.returnItem();
        System.out.println("==================================================");
    }
}