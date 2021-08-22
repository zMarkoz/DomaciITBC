package Posta;

public class Poruka {
    private String poruka;
    private String posiljalac;
    private String primalac;
    int suma;
    int id;

    public Poruka(String poruka, String posiljalac, String primalac, int suma, int id) {
        this.poruka = poruka;
        this.posiljalac = posiljalac;
        this.primalac = primalac;
        this.suma = suma;
        this.id = id;
    }


    // U konzoli ispisuje, ako je suma nenegativna:
    // {posiljalac} salje {suma} para {primalac}-u, uz poruku:
    // {poruka}
    // a ako je suma negativna:
    // {posiljalac} primac {suma} para od {primalac}-a, uz poruku:
    // {poruka}
    public void posalji() {
        if (suma > 0) {
            System.out.println(posiljalac + " salje");
        } else {
            System.out.println(posiljalac + " prima");
        }
        log();

        //TODO: Implement me
    }

    private void log() {
        System.out.println(posiljalac + " i " + primalac + " vrse tranzakciju od " + suma + " uz poruku: " + poruka + id);
    }

    // Ispisuje:
    // {posiljalac} i {prilamalac} vrse tranzakciju od {suma}, uz poruku: {poruka} ({id})


    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public String getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(String posiljalac) {
        this.posiljalac = posiljalac;
    }

    public String getPrimalac() {
        return primalac;
    }

    public void setPrimalac(String primalac) {
        this.primalac = primalac;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Poruka{" +
                "poruka='" + poruka + '\'' +
                ", posiljalac='" + posiljalac + '\'' +
                ", primalac='" + primalac + '\'' +
                ", suma=" + suma +
                ", id=" + id +
                '}';
    }
}
