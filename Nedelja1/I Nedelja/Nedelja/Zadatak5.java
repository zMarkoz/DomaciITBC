import java.util.Scanner;

public class Zadatak5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int digit;
        int digit2;
        int sum = 0;

        while (num > 0) {
            digit = num % 10;
            sum += digit;
            num /= 10;

            if (sum > 0) {
                digit2 = num % 10;
                sum += digit2;
                num /= 10;
                System.out.println(digit2);
                if (sum > 0) {
                    digit2 = num % 10;
                    sum += digit2;
                    num /= 10;
                    System.out.println(digit2);
                }
            }
        }
    }
}
