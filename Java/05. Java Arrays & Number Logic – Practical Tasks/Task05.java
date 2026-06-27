// Print array elements in reverse order.

public class Task05 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        
        System.out.print("Array elements in reverse order: ");

        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}