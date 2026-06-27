// Remove duplicate elements from an array.

import java.util.Arrays;

public class Task08 {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 6, 5, 2, 9, 1};
        
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
        System.out.println();
    }
}