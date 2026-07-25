import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Create a Book class with id, title, and author fields[cite: 14]
class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }

    @Override
    public String toString() {
        return "Book [ID=" + id + ", Title='" + title + "', Author='" + author + "']";
    }
}

public class Task03_BookLibrary {
    static List<Book> books = Arrays.asList(
        new Book(1, "Java Concurrency", "Brian Goetz"),
        new Book(2, "Effective Java", "Joshua Bloch")
    );

    // Search for a book by title returning Optional<Book>[cite: 14]
    public static Optional<Book> searchBookByTitle(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    public static void main(String[] args) {
        System.out.println("--- Searching for 'Effective Java' ---");
        Optional<Book> foundBook = searchBookByTitle("Effective Java");
        
        // Use ifPresent() to print the book details when the book is found[cite: 14]
        foundBook.ifPresent(book -> System.out.println("Book Details: " + book));

        System.out.println("\n--- Searching for 'Unknown Book' ---");
        Optional<Book> missingBook = searchBookByTitle("Unknown Book");
        
        // This will safely do nothing because the book is not found (avoids NullPointerException)
        missingBook.ifPresent(book -> System.out.println("Book Details: " + book));
    }
}