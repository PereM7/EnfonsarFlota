package Principi.Reptes.EnfonsarFlota;

public class Posicio {
    private int fila;
    private int columna;

    public Posicio (int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila () {
        return this.fila;
    }
    public void setFila (int fila) {
        this.fila = fila;
    }

    public int getColumna () {
        return this.columna;
    }
    public void setColumna (int columna) {
        this.columna = columna;
    }
}
