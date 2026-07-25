import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingPractical {

    public static void main(String[] args) {

        // Folder and file paths
        File folder = new File("MyFolder");
        File file = new File("MyFolder/student.txt");

        try {

            // 1. Create a folder
            if (folder.mkdir()) {
                System.out.println("Folder created successfully.");
            } else {
                System.out.println("Folder already exists.");
            }

            // 2. Create a file
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }

            // 3. Write data into the file
            FileWriter writer = new FileWriter(file);

            writer.write("Student Name: Mohamed Akmal\n");
            writer.write("Course: Java Programming\n");
            writer.write("Topic: Java File Handling\n");

            writer.close();

            System.out.println("Data written successfully.");

            // 4. Read data from the file
            System.out.println("\nFile Content:");

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();

            // 5. Delete the file
            if (file.delete()) {
                System.out.println("\nFile deleted successfully.");
            } else {
                System.out.println("\nFile could not be deleted.");
            }

        } catch (IOException e) {

            System.out.println(
                "An error occurred: "
                + e.getMessage()
            );
        }
    }
}