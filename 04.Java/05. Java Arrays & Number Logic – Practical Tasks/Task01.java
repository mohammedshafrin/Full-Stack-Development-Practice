// Find the largest element in an array.

public class Task01 {
    public static void main(String[] args) {
        int[] numbers = {23, 78, 45, 92, 56, 12};

        int largest = numbers[0];
    
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }
        
        System.out.println("The largest element in the array is: " + largest);
    }
}