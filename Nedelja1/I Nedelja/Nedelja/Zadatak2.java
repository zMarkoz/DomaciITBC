import java.util.Scanner;

public class Zadatak2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some number: ");
        int x = sc.nextInt();
        int y = 1;

        for (int i = 1; i <= x; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i + ":FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println(i + ":Fizz");
            } else if (i % 5 == 0) {
                System.out.println(i + ":Buzz");
            } else {
                System.out.println(i + ":");
            }
        }

    }
}


