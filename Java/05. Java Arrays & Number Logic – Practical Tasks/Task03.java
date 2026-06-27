// Count even and odd numbers in an array.

public class Task03 {
    public static void main(String[] args) {
        int[] numbers = {12, 35, 44, 7, 90, 11, 2};
        int evenCount = 0;
        int oddCount = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        
        System.out.println("Total Even numbers: " + evenCount);
        System.out.println("Total Odd numbers: " + oddCount);
    }
}