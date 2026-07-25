//Find the largest element in an array.

public class Task01 {
    public static void main(String[] args) {
        
        int[] numbers = {12, 45, 8, 93, 21};
        
        int largest = numbers[0];
        
        for (int i = 1; i < numbers.length; i++) {
            
            if (numbers[i] > largest) {

                largest = numbers[i]; 
            }
        }
        
        System.out.println("The largest element in the given array is: " + largest);
    }
}