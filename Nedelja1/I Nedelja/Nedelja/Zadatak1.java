import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the names of teams: ");
        String firstTeam = sc.next();
        String secondTeam = sc.next();
        System.out.println("Medals for " + firstTeam + ":");
        int goldF = Math.abs(sc.nextInt());
        int silverF = Math.abs(sc.nextInt());
        int bronzeF = Math.abs(sc.nextInt());
        System.out.println("Medals for " + secondTeam + ":");
        int goldS = Math.abs(sc.nextInt());
        int silverS = Math.abs(sc.nextInt());
        int bronzeS = Math.abs(sc.nextInt());

        int firstTotal = (goldF + silverF + bronzeF);
        int secondTotal = (goldS + silverS + bronzeS);


        if (firstTotal > secondTotal) {
            System.out.println(firstTeam);
        } else if (secondTotal > firstTotal) {
            System.out.println(secondTeam);
        } else {

            if (goldF > goldS) {
                System.out.println(firstTeam);
            } else if (goldS > goldF) {
                System.out.println(secondTeam);
            } else {

                if (silverF > silverS) {
                    System.out.println(firstTeam);
                } else if (silverS > silverF) {
                    System.out.println(secondTeam);
                } else {

                    if (bronzeF > bronzeS) {
                        System.out.println(firstTeam);
                    } else if (bronzeS > bronzeF) {
                        System.out.println(secondTeam);
                    } else if (bronzeS == bronzeF) {
                        System.out.println("Draw");
                    }

                }
            }

        }
    }
}

