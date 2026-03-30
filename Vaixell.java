package Principi.Reptes.EnfonsarFlota;

import java.util.ArrayList;

public class Vaixell {
    private final Direccio direccio;
    private final Posicio posicio;
    private final TipusVaixell tipus;
    private ArrayList<PartVaixell> partsVaixell;

    public Vaixell (TipusVaixell tipus, Direccio direccio, Posicio pos) {
        this.tipus = tipus;
        this.direccio = direccio;
        this.posicio = pos;
        this.partsVaixell = new ArrayList<>();
        assignarPartsVaixell();
    }

    private void assignarPartsVaixell () {
        int fila = posicio.getFila();
        int columna = posicio.getColumna();
        Posicio novaPos;

        for (int x = 0; x < tipus.getMida(); x++) {
            if (direccio == Direccio.Vertical) {
                novaPos = new Posicio((fila + x), columna);
            }else {
                novaPos = new Posicio(fila, (columna + x));
            }
            partsVaixell.add(new PartVaixell(novaPos));
        }
    }

    public boolean vaixellEnfonsat () {
        int contador = partsVaixell.size() - 1;
        for (PartVaixell p : partsVaixell) {
            if (p.getBombardejat()) {
                contador--;
            }
        }
        return contador == 0;
    }

    public TipusVaixell getTipusVaixell () {
        return this.tipus;
    }

    public Direccio getDireccio () {
        return this.direccio;
    }

    public Posicio getPosicioInicial () {
        return this.posicio;
    }

    public ArrayList<PartVaixell> getPartsVaixell () {
        return this.partsVaixell;
    }
}

