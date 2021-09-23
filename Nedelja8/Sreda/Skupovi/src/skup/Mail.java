package skup;

import java.util.ArrayList;
import java.util.TreeSet;

public class Mail {

    public static boolean anagram(String s1, String s2) {
        boolean same = true;
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();
        if (s1.length() != s2.length())
            same = false;

        TreeSet<Character> set = new TreeSet<>();
        TreeSet<Character> set2 = new TreeSet<>();

        for (char s3 : s1.toCharArray()) {
            set.add(s3);
        }
        for (char s4 : s2.toCharArray()) {
            set2.add(s4);
        }
        if (set == set2)
            same = true;


        return same;
    }
    public static ArrayList<Integer> razlika(ArrayList<Integer> a, ArrayList<Integer> b) {

        if (a == null && b == null) {
            return null;
        }
        if (a == null)
            return b;
        if (b == null)
            return a;
        a.removeAll(b);
        TreeSet<Integer> set = new TreeSet<>(a);
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer i : set){
            res.add(i);
        }

        return res;
    }
//


//    public static String console(String input){
////        input.toCharArray();
////        TreeSet<Character> set = new TreeSet<>();
////        for (Character s : input.toCharArray())
////            set.add(s);
////        while(input.equals("iX")){
////            set.add("");
//        }
//        return "";
//    }


    public static void main(String[] args) {

        System.out.println(anagram("zamalO", "mazalo"));
        System.out.println(anagram("panta redovno zakasni", "neopravdan izostanak"));
    }
}
