public class Task2 {
    public static void main(String[] args) {
        
        int totalRows = 5;
        
        for (int row = totalRows; row >= 1; row = row - 1) {
            
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            
            System.out.println();
        }
    }
}