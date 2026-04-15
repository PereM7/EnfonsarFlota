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
        iniciarTauler();
    }

    private void iniciarTauler () {
        for (int x = 0; x < tauler.length; x++) {
            for (int y = 0; y < tauler[x].length; y++) {
                tauler[x][y] = new Casella();
            }
        }
    }

    public boolean assignarVaixell (TipusVaixell tipus, Direccio dir, Posicio posicioInicial) {
        if (!comprovarHiHaVaixell(posicioInicial, tipus, dir)) {
            for (int i = 0; i < vaixells.length; i++) {
                if (vaixells[i] == null) {
                    vaixells[i] = new Vaixell(tipus, dir, posicioInicial);

                    ArrayList<PartVaixell> parts = vaixells[i].getPartsVaixell();
                    for (PartVaixell p : parts) {
                        int fila = p.getPosicio().getFila();
                        int columna = p.getPosicio().getColumna();

                        tauler[fila][columna].setPartVaixell(p);
                        p.setVaixellPare(vaixells[i]);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private boolean comprovarHiHaVaixell (Posicio posicio, TipusVaixell tipus, Direccio dir) {
        int fila = posicio.getFila();
        int columna = posicio.getColumna();

        for (int x = 0; x < tipus.getMida(); x++) {
            if (dir == Direccio.Vertical) {
                if (tauler[fila + x][columna].hiHaPartVaixell()) {
                    return true;
                }
            }else {
                if (tauler[fila][columna + x].hiHaPartVaixell()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean vaixellTocat (Posicio pos) {
        int fila = pos.getFila();
        int columna = pos.getColumna();
        tauler[fila][columna].setBombardejada();

        return tauler[fila][columna].hiHaPartVaixell();
    }

    public boolean vaixellEnfonsat (Posicio pos) {
        int fila = pos.getFila();
        int columna = pos.getColumna();

        return tauler[fila][columna].vaixellEnfonsat();
    }

    public boolean totsVaixellsEnfonsats () {
        for (int i = 0; i < vaixells.length; i++) {
            if (vaixells[i] != null &&!vaixells[i].vaixellEnfonsat()) {
                return false;
            }
        }
        return true;
    }

    public void imprimirTaulerIntern () {
        for (int x = 0; x < tauler.length; x++) {
            for (int y = 0; y < tauler[x].length; y++) {
                if (tauler[x][y].hiHaPartVaixell()) {
                    System.out.print("V ");
                }
                else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public void imprimirTaulerExtern () {
        for (int x = 0; x < tauler.length; x++) {
            for (int y = 0; y < tauler[x].length; y++) {

                if (tauler[x][y].hiHaPartVaixell() && tauler[x][y].vaixellEnfonsat()) {
                    System.out.print("X ");
                }
                else if (tauler[x][y].hiHaPartVaixell() && tauler[x][y].getBombardejada()) {
                    System.out.print("· ");
                }
                else if (tauler[x][y].getBombardejada()) {
                    System.out.print("A");
                }
                else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
