import java.beans.BeanInfo;
import java.util.Scanner;

public class Zadatak3 {
    public static void bid(boolean b, int i, double d) {

        if (b == false) {
            System.out.println("Boolean");
        }
        if (i > 49) {
            System.out.println("Integer");
        }
        if (Math.floor(d) > i * 2) {
            System.out.print("Double");
        }
    }

    public static void main(String[] args) {

        bid(false, 20, 40.9);
    }
}
