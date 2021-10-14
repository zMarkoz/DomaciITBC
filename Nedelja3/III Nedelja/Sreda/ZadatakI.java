public class ZadatakI {
    public static void main(String[] args) {
        String poruka = "Vo$z$ite $#@pazlj@i######vo!#";

        poruka = poruka.replaceAll("\\$","").replaceAll("#","").replaceAll("@","");

        System.out.println(poruka);
    }
}
