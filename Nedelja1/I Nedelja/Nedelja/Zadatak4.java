import java.util.Scanner;

public class Zadatak4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int yearOne = sc.nextInt();
        int yearTwo = sc.nextInt();
        int leap = 0;


        for (int i = (yearOne + 1); i < yearTwo; i++) {
            if (i % 4 == 0) {
                if (i % 100 != 0)
                    leap++;
                if ((i % 100 == 0) && (i % 400 == 0))
                    leap++;


            }

        }
        System.out.println(leap);
    }
}
