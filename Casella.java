package Principi.Reptes.EnfonsarFlota;

public class Casella {
    private boolean bombardejada = false;
    private PartVaixell partVaixell = null;

    public Casella () {}

    public boolean getBombardejada () {
        return this.bombardejada;
    }
    public void setBombardejada () {
        this.bombardejada = true;
        if (partVaixell != null) {
            partVaixell.setBombardejat();
        }
    }

    public void setPartVaixell (PartVaixell part) {
        this.partVaixell = part;
    }
    public boolean hiHaPartVaixell(){
        return ( partVaixell != null ) ;
    }

    public boolean vaixellEnfonsat () {
        return partVaixell.vaixellEnfonsat();
    }
}
