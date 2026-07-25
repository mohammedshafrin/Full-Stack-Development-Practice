// Find duplicate elements in an array

public class Task07 {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 4, 2, 10, 6};
        
        System.out.print("Duplicate elements found: ");

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    System.out.print(numbers[j] + " ");
                    break;
                }
            }
        }
        System.out.println();
    }
}