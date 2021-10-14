import java.util.Scanner;

public class Zadatak2 {

    public static int subNumber(int num) {
        if (num==0)
            return 1;
        else
            return (num*subNumber(num-1));

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int fact = 1;
        fact = subNumber(a);
        System.out.println("Factorial of "+a+" is: "+fact);
    }
}

