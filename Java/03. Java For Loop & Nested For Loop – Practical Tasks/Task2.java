public class Task2{

    public static void main ( String[]args) {

        for (int j=5;j>=1;j=j-1) {
            
            for (int i=5;i>=j;i=i-1){

                 System.out.print("*");
            }

            System.out.println();
        }
    }

}