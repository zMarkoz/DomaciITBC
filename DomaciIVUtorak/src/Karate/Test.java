package Karate;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String[] kate = new String[]{};
        Karatista k1 = new Karatista("Samo", 4, "12Kyu", kate);
        Karatista k2 = new Karatista("Denis", 18, "5Kyu", kate);
        k1.log();
        k2.napadni();

    }



}
