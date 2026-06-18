public class Arithmetic {

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a Value");
        int number = input.nestInt();

        System.out.println("You entered :" + number);

        input.close();

    }

}