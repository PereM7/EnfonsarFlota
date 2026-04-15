package Principi.Reptes.EnfonsarFlota;

public class Jugador {

    private String nom;
    private Tablero tauler = new Tablero();

    public Jugador () { }

    public Tablero getTauler() {
        return this.tauler;
    }

    public String getNom () {
        return nom;
    }
    public void setNom (String nom) {
        this.nom = nom;
    }
}
