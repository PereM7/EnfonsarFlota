package Principi.Reptes.EnfonsarFlota;

public class Joc {
    private Jugador j1;
    private Jugador j2;
    private int torn = 0;

    public Joc (Jugador j1, Jugador j2) {
        this.j1 = j1;
        this.j2 = j2;
    }

    private void nomJugador (Jugador jugador) {
        String nom = Llegir.demanarNom();
        jugador.setNom(nom);
    }

    private void iniciarVaixell (Jugador jugador, TipusVaixell tipus) {
        Tablero taulerJugador = jugador.getTauler();
        Posicio posPortaavions;
        Direccio dir;
        do {
            posPortaavions = Llegir.demanarVaixell(tipus);
            dir = Llegir.demanarDireccio();

            if (!taulerJugador.assignarVaixell(tipus, dir, posPortaavions)) {
                System.out.println("Error, ja hi ha un vaixell.");
            }
        } while(taulerJugador.assignarVaixell(tipus, dir, posPortaavions));
    }

    private void bombardejar (Jugador jugador) {
        Tablero taulerJugador = jugador.getTauler();
        Posicio posBomba = Llegir.demanarPosicio();
        if (taulerJugador.vaixellTocat(posBomba)) {
            System.out.println("Vaixell tocat!");
        }else {
            System.out.println("Aigua");
        }
        if (taulerJugador.vaixellEnfonsat(posBomba)) {
            System.out.println("Vaixell enfonsat!");
        }
    }

    private boolean haGuanyat (Jugador jugador) {
        Tablero taulerJugador = jugador.getTauler();
        return true;

    }
}
