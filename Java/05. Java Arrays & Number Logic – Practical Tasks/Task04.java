// Reverse an array.

public class Task04 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            
            start++;
            end--;
        }

        System.out.print("Reversed array content: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}