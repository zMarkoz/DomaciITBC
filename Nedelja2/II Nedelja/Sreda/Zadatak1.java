import java.util.Scanner;

public class Zadatak1 {
    public static double minDouble(double num1, double num2) {
        if (num1 <= num2)
            return num1;
        return num2;
    }

    public static double minNum(double num1, double num2, double num3) {
        if (minDouble(num1, num2) >= num3)
            return num3;
        return minDouble(num1, num2);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double z = sc.nextDouble();

        System.out.println(minNum(x, y, z));
    }
}
