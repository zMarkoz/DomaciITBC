package Karate;

import java.util.Arrays;

public class Karatista {
    private String ime;
    private int godine;
    private String rang;

    private String[] kata;

    //={"10Kyu", "9Kyu", "8Kyu", "7Kyu", "6Kyu", "5Kyu", "4Kyu", "3Kyu", "2Kyu", "1Kyu",
//            "1Dan", "2Dan" ,"3Dan", "4Dan", "5Dan", "6Dan" ,"7Dan", "8Dan", "9Dan", "10Dan"};
    public Karatista(String ime, int godine, String rang, String[] kata) {
        int imeLenght = ime.length();
        if (imeLenght < 3) {
            ime = " ";
            System.out.println("Ime mora sadrzati 3 ili vise slova!");
        } else this.ime = ime;
        if (godine < 0) {
            godine = 0;
            System.out.println("Morate uneti ispravan broj godina!");
        } else this.godine = godine;

        String[] rangovi = new String[]{"10Kyu", "9Kyu", "8Kyu", "7Kyu", "6Kyu", "5Kyu", "4Kyu", "3Kyu", "2Kyu", "1Kyu", "1Dan", "2Dan", "3Dan", "4Dan", "5Dan", "6Dan", "7Dan", "8Dan", "9Dan", "10Dan"};
        boolean postoji = false;
        for (String s : rangovi) {
            if (s.equals(rang)) {
                postoji = true;
                break;
            }
        }
        if (postoji) {
            this.rang = rang;
        } else {
            System.out.println("Uneli ste nepostojeci rang!");
        }

        this.rang = rang;

        this.kata = kata;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;

    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
         this.godine = godine;
    }

    public String getRang() {
        return rang;
    }



    public void setRang(String rang) {
        this.rang = rang;
    }


    public String[] getKata() {
        return kata;
    }

    public void setKata(String[] kata) {
        this.kata = kata;
    }

    public void napadni() {

        System.out.println("Karatista " + this.ime + " napada sa " + Arrays.toString(this.kata) + "katom");
    }

    public void log() {

        System.out.println("Karatista " + this.ime + ", " + this.godine + ", " + this.rang + " - zna naredne kate " + Arrays.toString(this.kata));

    }

    public void vatreniNapad() {
        int rnd;
        rnd = (int) Math.random();
        String rndKata = kata[rnd];
        System.out.println("Karatista " + this.ime + " napada sa " + rndKata + " katom.");
    }


}

