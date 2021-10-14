import java.util.Scanner;

public class Zadatak_I {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some number: ");

        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = a + b;
        int sub = a - b;
        int mtp = a * b;
        int div = a / b;
        int mod = a % b;

        System.out.println("Results :");
        System.out.println(sum);
        System.out.println(sub);
        System.out.println(mtp);
        System.out.println(div);
        System.out.println(mod);
    }
}
