package Principi.Reptes.EnfonsarFlota;

public class Casella {
    private boolean bombardejada = false;
    private PartVaixell partVaixell = null ;

    public Casella () {}

    public boolean getBombardejada () {
        return this.bombardejada;
    }
    public void setBombardejada () {
        this.bombardejada = true;
        partVaixell.setBombardejat();
    }

    public boolean hiHaVaixell(){
        return ( partVaixell != null ) ;
    }
}
