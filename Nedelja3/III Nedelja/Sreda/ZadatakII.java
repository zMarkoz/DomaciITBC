public class ZadatakII {
    public static String test(String msg, String[] kljuc, String[] decode) {

        String[] podeljeniString = msg.split(" ");

        for (int i = 0; i < podeljeniString.length; i++) {
            for (int j = 0; j < kljuc.length; j++) {
                if (podeljeniString[i].equals(kljuc[j])) {
                    podeljeniString[i] = decode[j];
                }
            }
        }
        return String.join(" ", podeljeniString);
    }

    public static void main(String[] args) {
        String poruka = "Jedi #$%^ !@#$!!!@# mali!";
        String[] kljuc = {"#$%^", "!@#$!!!@#"};
        String[] decode = {"pite", "moroncinu"};

        System.out.println(test(poruka, kljuc, decode));
    }
}