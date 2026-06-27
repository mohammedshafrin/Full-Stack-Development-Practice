// Count the number of even and odd elements in an array.

public class Task05 {
    public static void main(String[] args) {
        int[] numbers = {18, 22, 37, 48, 50, 61};
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Number of Even elements: " + evenCount);
        System.out.println("Number of Odd elements: " + oddCount);
    }
}