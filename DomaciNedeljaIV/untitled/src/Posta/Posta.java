package Posta;
import java.util.ArrayList;
import java.util.List;

public class Posta {
    private List<Poruka> poruke;

    public Posta(List<Poruka> poruke) {
        this.poruke = poruke;
    }

    public List<Poruka> getPoruke() {
        return poruke;
    }

    public void setPoruke(ArrayList<Poruka> poruke) {
        this.poruke = poruke;
    }
// Poruke {id:1}, Poruka {id:2} Poruka {id:3}
    /*Konstruktori*/

    /*Metode*/

    //Dodaje poruku p u poruke ako ona vec ne postoji (gledano u odnosu na id)
    public void add(Poruka p){
        boolean postoji = nadjiPorukuPoId(p.getId());
        if (postoji==false){
            poruke.add(p);
        }
    }

    //Brise poruku p iz poruka ako ona postoji (gledano u odnosu na id)
    public void remove(Poruka p){
        boolean postoji = nadjiPorukuPoId(p.getId());
        if (postoji==true){
            poruke.remove(p);
        }
    }

    //Ispisuje poruku p i ibrese je iz poruka, ako ona postoji (gledano u odnosu na id)
    public void send(Poruka p){
        boolean postoji = nadjiPorukuPoId(p.getId());
        if (postoji==true){
            System.out.println(p.getPoruka());
            poruke.remove(p);
        }
    }

    private boolean nadjiPorukuPoId(int id){
        boolean postoji = false;
        for (Poruka p1 : poruke){
            if (p1.getId() == id){
                postoji = true;
            }
        }
        return  postoji;
    }

    //Menja tekst poruke
    public void change(Poruka p, String msg){
        for (Poruka p1 : poruke){
            if (p1.getId()==p.getId()){
                p1.setPoruka(msg);
            }
        }
    }

    // Vraca sumu poruke p ako ta poruka postoji u listi
    public int isplata(Poruka p){
        for (Poruka p1 : poruke){
            if (p1.getId()==p.getId()){
                return p1.getSuma();
            }
        }
        return 0;
    }


    // U konzoli ispisuje, ako je suma nenegativna:
    // {posiljalac} salje {suma} para {primalac}-u, uz poruku:
    // {poruka}
    // a ako je suma negativna:
    // {posiljalac} primac {suma} para od {primalac}-a, uz poruku:
    // {poruka}
    // za svaki element iz liste!
    @Override
    public String toString() {
        return "Posta{}";
    }

}
