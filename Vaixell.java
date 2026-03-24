package Principi.Reptes.EnfonsarFlota;

import java.util.ArrayList;

public class Vaixell {
    // Horitzontal -> h, vertical -> v
    private final char direccio;
    private final int llargari;
    private ArrayList<PartVaixell> partsVaixell;

    public Vaixell (int llargari, char direccio) {
        this.llargari = llargari;
        this.direccio = direccio;
        this.partsVaixell = new ArrayList<PartVaixell>();
    }

    public int getLlargari () {
        return this.llargari;
    }

    public char getDireccio () {
        return this.direccio;
    }
}

