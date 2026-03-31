package Principi.Reptes.EnfonsarFlota;

public class PartVaixell {
    private final Posicio posicio;
    private boolean bombardejat = false;
    private Vaixell vaixellPare;

    public PartVaixell(Posicio posicio) {
        this.posicio = posicio;
    }

    public Posicio getPosicio () {
        return this.posicio;
    }

    public boolean getBombardejat () {
        return bombardejat;
    }
    public void setBombardejat () {
        this.bombardejat = true;
    }

    public void setVaixellPare (Vaixell va) {
        this.vaixellPare = va;
    }
    public boolean vaixellEnfonsat () {
        return vaixellPare.vaixellEnfonsat();
    }
}
