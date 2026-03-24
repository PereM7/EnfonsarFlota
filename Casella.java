package Principi.Reptes.EnfonsarFlota;

public class Casella {
    private boolean bombardejada = false;
    private boolean vaixell = false;

    public Casella () {}

    public boolean getBombardejada () {
        return this.bombardejada;
    }
    public void setBombardejada (boolean bomba) {
        this.bombardejada = bomba;
    }

    public boolean getVaixell () {
        return this.vaixell;
    }
    public void setVaixell (boolean vaixell) {
        this.vaixell = vaixell;
    }
}
