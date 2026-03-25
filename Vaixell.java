package Principi.Reptes.EnfonsarFlota;

import java.util.ArrayList;

public class Vaixell {
    private final Direccio direccio;
    private final Posicio posicio;
    private final int llargari;
    private ArrayList<PartVaixell> partsVaixell;

    public Vaixell (int llargari, Direccio direccio, Posicio pos) {
        this.llargari = llargari;
        this.direccio = direccio;
        this.posicio = pos;
        this.partsVaixell = new ArrayList<>();
        assignarPartsVaixell();
    }

    private void assignarPartsVaixell () {
        int fila = posicio.getFila();
        int columna = posicio.getColumna();
        Posicio novaPos;

        for (int x = 0; x < llargari; x++) {
            if (direccio == Direccio.Vertical) {
                novaPos = new Posicio((fila + x), columna);
            }else {
                novaPos = new Posicio(fila, (columna + x));
            }
            partsVaixell.add(new PartVaixell(novaPos));
        }
    }

    public int getLlargari () {
        return this.llargari;
    }

    public Direccio getDireccio () {
        return this.direccio;
    }

    public Posicio getPosicioInicial () {
        return this.posicio;
    }
}

