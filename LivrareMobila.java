class LivrareMobila
{
    private String numeDestinatar, prenumeDestinatar, tipMobila, adresa;
    private int pretMobila,nrClient;

    public LivrareMobila (String numeDestinatar, String prenumeDestinatar, int nrClient, String tipMobila, String adresa, int pretMobila)
    {
        this.numeDestinatar=numeDestinatar;
        this.prenumeDestinatar=prenumeDestinatar;
        this.nrClient=nrClient;
        this.tipMobila=tipMobila;
        this.adresa=adresa;
        this.pretMobila=pretMobila;
    }

    public String getNumeDestinatar()
    {
        return numeDestinatar;
    }
    public String getPrenumeDestinatar()
    {
        return prenumeDestinatar;
    }
    public int getNrClient()
    {
        return nrClient;
    }
    public String getTipMobila()
    {
        return tipMobila;
    }
    public String getAdresa()
    {
        return adresa;
    }
    public int getPretMobila()
    {
        return pretMobila;
    }

    public void setNumeDestinatar(String numeDestinatar)
    {
        this.numeDestinatar=numeDestinatar;
    }
    public void setPrenumeDestinatar(String prenumeDestinatar)
    {
        this.prenumeDestinatar=prenumeDestinatar;
    }
    public void setNrClient(int nrClient)
    {
        this.nrClient=nrClient;
    }
    public void setTipMobila (String tipMobila)
    {
        this.tipMobila=tipMobila;
    }
    public void setAdresa(String adresa)
    {
        this.adresa=adresa;
    }
    public void setPretMobila(int pretMobila)
    {
        this.pretMobila=pretMobila;
    }

    public String toString()
    {
        String msg="\nDatele clientului " + nrClient;
        msg+="\nNume :" + numeDestinatar;
        msg+="\nPrenume: " + prenumeDestinatar;
        msg+="\nMobila cumparata: " + tipMobila;
        msg+="\nAdresa: " + adresa;
        msg+="\nPretul comandei: " + pretMobila;
        msg+="\n";
        return msg;
    }
}