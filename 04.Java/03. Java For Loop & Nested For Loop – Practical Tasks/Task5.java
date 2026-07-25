public class Task5 {
    public static void main(String[] args) {
        
        int n = 5;

        for (int i = 1; i <= n; i++) {

            int starsCount = (2 * i) - 1;
            
            for (int j = 1; j <= starsCount; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        for (int i = n - 1; i >= 1; i--) {

            int starsCount = (2 * i) - 1;
            
            for (int j = 1; j <= starsCount; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


