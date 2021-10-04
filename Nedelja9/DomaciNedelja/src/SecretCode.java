

public class SecretCode {

    public static String enkripcija(String poruka, int kljuc) {
        String encrypted = "";
        for (int i = 0; i < poruka.length(); i++) {
            int c = poruka.charAt(i) + kljuc;
            if (c > 126) {
                c -= 95;
            } else if (c < 32) {
                c += 95;
            }
            encrypted += (char) c;
        }
        return encrypted;
    }


    public static String dekripcija(String poruka, int kljuc) {
        return enkripcija(poruka, -kljuc);
    }

    public static void main(String[] args) {
        String code = "";
        int shift = 0;
        int brEnkripcije= 0;
        while (shift < 101) {
            System.out.println(brEnkripcije + " : " + dekripcija(code, shift));
            shift++;
            brEnkripcije++;
        }

    }
}
