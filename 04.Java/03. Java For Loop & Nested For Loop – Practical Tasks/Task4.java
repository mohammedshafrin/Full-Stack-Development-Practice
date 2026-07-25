public class Task4 {
    public static void main(String[] args) {
        
        int totalRows = 5;
        
        for (int i = 1; i <= totalRows; i++) {
            
            int starsCount = (2 * i) - 1;
            
            for (int j = 1; j <= starsCount; j++) {
                System.out.print("*");
            }
            
            System.out.println();
        }
    }
}