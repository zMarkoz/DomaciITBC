import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;

public class zdt {
    public static int[] reverse(int[] n) {
        int[] x = new int[n.length];
        int place = 0;
        for (int i = 0; i < x.length; i++) {
            if (n[i] != 0) {
                x[place] = n[i];
                place++;
            }
        }
        return x;
    }

    public static int[] generateRandom() {
        Random r = new Random();
        int[] x = new int[r.nextInt(1000)];
        for (int i = 0; i < x.length; i++)
            x[i] = r.nextInt(10);
        return x;
    }

    public static void test() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("TestPrimeri.txt"));
            for (int i = 1; i <= 1000; i++) {
                int[] x = generateRandom();
                String s1 = Arrays.toString(reverse(x)).replace("[", "").replace("]", "");
                String s2 = Arrays.toString(x).replace("[", "").replace("]", "");
                String res = "assertEquals(new int[]{" + s1 + "}, initialArray(new int[]{" + s2 + "})";
                writer.write(res);
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test();
    }
}