import java.util.Scanner;

public class Zadatak_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some number: ");

        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a > 0 && b > 0) {
            System.out.println("Numbers " + a + " and " + b + " have same value.");
        } else if (a < 0 && b > 0) {
            System.out.println("Numbers " + a + " and " + b + " have opposite value.");
        } else if (a > 0 && b < 0) {
            System.out.println("Numbers " + a + " and " + b + " have opposite value.");
        } else if (a < 0 && b < 0) {
            System.out.println("Numbers " + a + " and " + b + " have same value.");
        } else {
            System.out.println("Both numbers are zero");
        }
    }

}

