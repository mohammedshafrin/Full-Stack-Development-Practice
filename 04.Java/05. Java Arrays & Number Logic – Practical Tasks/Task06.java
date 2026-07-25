// Find the second largest element.

public class Task06 {
    public static void main(String[] args) {
        int[] numbers = {14, 46, 47, 45, 92, 52, 86};
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                secondLargest = largest;
                largest = numbers[i];
            } else if (numbers[i] > secondLargest && numbers[i] != largest) {
                secondLargest = numbers[i];
            }
        }
        
        System.out.println("The second largest element is: " + secondLargest);
    }
}