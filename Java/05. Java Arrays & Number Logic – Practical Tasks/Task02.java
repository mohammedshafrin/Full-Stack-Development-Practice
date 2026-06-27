// Find the smallest element in an array.

public class Task02 {
    public static void main(String[] args) {
        int[] numbers = {23, 78, 45, 92, 56, 5};
        
        int smallest = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < smallest) {
                smallest = numbers[i];
            }
        }
        
        System.out.println("The smallest element in the array is: " + smallest);
    }
}