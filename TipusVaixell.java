package Principi.Reptes.EnfonsarFlota;

public enum TipusVaixell {
    Portaavions(4),
    Blindat(3),
    Destructor(2);

    private final int MIDA;

    private TipusVaixell (int mida) {
        this.MIDA = mida;
    }

    public int getMida () {
        return MIDA;
    }
}
