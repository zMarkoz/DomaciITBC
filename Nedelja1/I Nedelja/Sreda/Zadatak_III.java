import java.util.Scanner;

public class Zadatak_III {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some number between 1000 and 9999: ");

        int number = sc.nextInt();


        if (number >= 1000 && number < 10000) {
            int j = number % 10;
            number = number / 10;
            int d = number % 10;
            number = number / 10;
            int s = number % 10;
            number = number / 10;
            int h = number % 10;

            System.out.println(h * s - (d + j));
        } else System.out.println("Enter valid number in between 1000 and 9999.");

    }
}
