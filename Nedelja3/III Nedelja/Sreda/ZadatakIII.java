public class ZadatakIII {

    public static boolean validna(String password) {

        boolean validna = true;

        String velikaSlova = "(.*[A-Z].*)";
        if (!password.matches(velikaSlova)) {
            validna = false;

            System.out.println("Password must have more one or more upper case");
        }

        if (password.length() < 8) {
            validna = false;

            System.out.println("Password must have more than 8 characters");
        }

        return validna;

    }

    public static void main(String[] args) {
        System.out.println(validna("nekatamosifra"));

    }
}
