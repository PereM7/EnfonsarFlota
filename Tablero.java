package Principi.Reptes.EnfonsarFlota;

import java.util.ArrayList;

public class Tablero {
    private final int ALTURA = 8;
    private final int AMPLARI = 8;
    private final int NOMBRE_VAIXELLS = 5;
    private Casella[][] tauler;
    private Vaixell[] vaixells;

    public Tablero () {
        this.tauler = new Casella[ALTURA][AMPLARI];
        this.vaixells = new Vaixell[NOMBRE_VAIXELLS];
    }

    public void assignarVaixell (TipusVaixell tipus, Direccio dir, Posicio posicioInicial) {
        for (int i = 0; i < vaixells.length; i++) {
            if (vaixells[i] != null) {
                vaixells[i] = new Vaixell(tipus, dir, posicioInicial);

                ArrayList<PartVaixell> parts = vaixells[i].getPartsVaixell();
                for (PartVaixell p : parts) {
                    int fila = p.getPosicio().getFila();
                    int columna = p.getPosicio().getFila();

                    tauler[fila][columna].setPartVaixell(p);
                }
            }
        }
    }

    private boolean comprovarHiHaVaixell () {
        return false; //Demanar
    }

    private boolean vaixellTocat (Posicio pos) {
        int fila = pos.getFila();
        int columna = pos.getColumna();
        tauler[fila][columna].setBombardejada();

        return tauler[fila][columna].hiHaPartVaixell();
    }

    //Com saber el vaixell? O eliminar el vaixell?
    private boolean vaixellEnfonsat (Vaixell vaixell) {
        ArrayList<PartVaixell> part = vaixell.getPartsVaixell();
        int contador = part.size() - 1;
        for (PartVaixell p : part) {
            if (p.getBombardejat()) {
                contador--;
            }
        }
        return contador == 0;
    }
}
