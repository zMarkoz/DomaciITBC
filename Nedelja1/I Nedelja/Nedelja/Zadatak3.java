import java.util.Scanner;

public class Zadatak3 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Input price, 0 to exit.");
        double price = scan.nextDouble();
        double sum = 0;
        double num = 0;

        while (price!=0) {
            System.out.println("Input price: ");
            double c = scan.nextDouble();

            if (c == 0 ) {
                double avg = sum / num;
                System.out.println("Average price is: " + avg);
                break;

            }if (c < 0) {
                c=0;
            }
            else {
                c =
                sum = sum + c;
                num++;
            }
        }


    }
}