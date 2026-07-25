// Calculate the sum of all elements in an array. //


public class Task03 {
    public static void main(String[] args) {
        
        int[] numbers = {5, 10, 15, 20, 25, 100, 54};
        
        int sum = 0;
        
        for (int i = 0; i < numbers.length; i++) {

            sum = sum + numbers[i]; 
        }
        
        System.out.println("The sum of all elements in the array is: " + sum);
    }
}