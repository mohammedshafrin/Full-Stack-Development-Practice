// Remove duplicate elements from an array.

import java.util.Arrays;

public class Task09 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 20, 30, 30, 40, 10};
        
        Arrays.sort(numbers); 
        
        int[] temp = new int[numbers.length];
        int j = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] != numbers[i + 1]) {
                temp[j++] = numbers[i];
            }
        }
        temp[j++] = numbers[numbers.length - 1];

        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < j; i++) {
            System.out.print(temp[i] + " ");
        }
    }
}