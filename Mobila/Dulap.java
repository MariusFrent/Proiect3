package Mobila;

public class Dulap implements Mobila{

    int pret;
    int lungime;
    int latime;
    int inaltime;

    public Dulap(){}

    public Dulap(int pret, int lungime, int latime, int inaltime) {
        this.pret = pret;
        this.lungime = lungime;
        this.latime = latime;
        this.inaltime = inaltime;
    }

    @Override
    public int arie(int lungime, int latime) {
        return lungime * latime;
    }

    @Override
    public int getPret() {
        return this.pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getLungime() {
        return lungime;
    }

    public void setLungime(int lungime) {
        this.lungime = lungime;
    }

    public int getLatime() {
        return latime;
    }

    public void setLatime(int latime) {
        this.latime = latime;
    }

    public int getInaltime() {
        return inaltime;
    }

    public void setInaltime(int inaltime) {
        this.inaltime = inaltime;
    }

    @Override
    public String toString() {
        return "Dulap{" +
                "pret=" + pret +
                ", lungime=" + lungime +
                ", latime=" + latime +
                ", inaltime=" + inaltime +
                '}';
    }
}
