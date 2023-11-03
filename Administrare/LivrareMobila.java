package Administrare;

import Mobila.Mobila;

public class LivrareMobila
{
    private String numeDestinatar, prenumeDestinatar, adresa;
    private int nrClient;
    Mobila mobila;

    public LivrareMobila(){}
    public LivrareMobila(String numeDestinatar, String prenumeDestinatar, String adresa, int nrClient, Mobila mobila) {
        this.numeDestinatar = numeDestinatar;
        this.prenumeDestinatar = prenumeDestinatar;
        this.adresa = adresa;
        this.nrClient = nrClient;
        this.mobila = mobila;
    }

    public String getNumeDestinatar() {
        return numeDestinatar;
    }

    public void setNumeDestinatar(String numeDestinatar) {
        this.numeDestinatar = numeDestinatar;
    }

    public String getPrenumeDestinatar() {
        return prenumeDestinatar;
    }

    public void setPrenumeDestinatar(String prenumeDestinatar) {
        this.prenumeDestinatar = prenumeDestinatar;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getNrClient() {
        return nrClient;
    }

    public void setNrClient(int nrClient) {
        this.nrClient = nrClient;
    }

    public Mobila getMobila() {
        return mobila;
    }

    public void setMobila(Mobila mobila) {
        this.mobila = mobila;
    }

    @Override
    public String toString() {
        return "Datele clientului " + nrClient +
                "\nNume :" + numeDestinatar +
                "\nPrenume: " + prenumeDestinatar +
                "\nAdresa: " + adresa +
                "\nMobila cumparata: " + mobila +"\n\n";

    }
}