package Principi.Reptes.EnfonsarFlota;

public class Casella {
    private boolean bombardejada = false;
    private PartVaixell partVaixell = null;
    private Vaixell vaixellPare = null;

    public Casella () {}

    public boolean getBombardejada () {
        return this.bombardejada;
    }
    public void setBombardejada () {
        this.bombardejada = true;
        partVaixell.setBombardejat();
    }

    public void setPartVaixell (PartVaixell part) {
        this.partVaixell = part;
    }

    public boolean hiHaPartVaixell(){
        return ( partVaixell != null ) ;
    }

    public void setVaixellPare (Vaixell va) {
        this.vaixellPare = va;
    }
    public boolean vaixellEnfonsat () {
        return vaixellPare.vaixellEnfonsat();
    }
}
