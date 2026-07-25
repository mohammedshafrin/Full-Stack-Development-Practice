// Rotate an array to the right by one position.


public class Task10 {
    
        public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        int last = numbers[numbers.length - 1];

        for (int i = numbers.length - 1; i > 0; i--) {
            numbers[i] = numbers[i - 1];
        }

        numbers[0] = last;

        System.out.print("Array after right rotation: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}