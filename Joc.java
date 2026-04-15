package Principi.Reptes.EnfonsarFlota;

public class Joc {
    private Jugador[] players = new Jugador[2];
    private int torn = 0;
    private final int NOMBRE_VAIXELLS = 5;
    private TipusVaixell[] vaixellsNecessaris;

    public Joc () {
        iniciarVaixellsNecessaris();
        iniciarPlayers();
    }

    private void iniciarVaixellsNecessaris () {
        vaixellsNecessaris = new TipusVaixell[NOMBRE_VAIXELLS];
        vaixellsNecessaris[0] = TipusVaixell.Portaavions;
        vaixellsNecessaris[1] = TipusVaixell.Blindat;
        vaixellsNecessaris[2] = TipusVaixell.Blindat;
        vaixellsNecessaris[3] = TipusVaixell.Destructor;
        vaixellsNecessaris[4] = TipusVaixell.Destructor;
        //Dudoso
    }
    private void iniciarPlayers () {
        players[0] = new Jugador();
        players[1] = new Jugador();
        //Dudoso
    }

    private void nomJugador (Jugador jugador) {
        String nom = Llegir.demanarNom();
        jugador.setNom(nom);
    }

    private void iniciarVaixell (TipusVaixell tipus) {
        Tablero taulerJugador = players[torn % 2].getTauler();
        Posicio posPortaavions;
        Direccio dir;
        do {
            posPortaavions = Llegir.demanarVaixell(tipus);
            dir = Llegir.demanarDireccio();

            if (!taulerJugador.assignarVaixell(tipus, dir, posPortaavions)) {
                System.out.println("Error, ja hi ha un vaixell.");
            }
            else {
                System.out.println(tipus + " afegit.");
                break;
            }
        } while(true);
    }

    private void iniciarVaixellsAleatoris () {
        Tablero taulerJugador = players[torn % 2].getTauler();
        for (TipusVaixell v: vaixellsNecessaris) {
            Posicio pos;
            Direccio dir;
            do {
                int fila = (int) (Math.random() * (8));
                int columna = (int) (Math.random() * (8));
                pos = new Posicio (fila, columna);
                if (Math.random() > 0.5) {
                    dir = Direccio.Vertical;
                } else { dir = Direccio.Horitzontal; }
            } while (!taulerJugador.assignarVaixell(v, dir, pos));
        }
    }

    private void bombardejar () {

        Tablero taulerJugador = players[torn % 2].getTauler();
        Posicio posBomba = Llegir.demanarPosicio();
        if (taulerJugador.vaixellTocat(posBomba)) {
            System.out.println("Vaixell tocat!");
            if (taulerJugador.vaixellEnfonsat(posBomba)) {
                System.out.println("Vaixell enfonsat!");
            }
        }else {
            System.out.println("Aigua");
        }
    }

    private boolean haGuanyat () {
        Tablero taulerJugador = players[torn % 2].getTauler();
        if (taulerJugador.totsVaixellsEnfonsats()) {
            return true;
        }
        return false;
    }

    public void jugar () {
        nomJugador(players[0]);
        nomJugador(players[1]);

        do {
            int contador;
            if (torn % 2 == 0) {
                contador = 1;
            }
            else {contador = 0; }//dudoso

            Tablero taulerJugador = players[torn % 2].getTauler();
            System.out.println("Torn del jugador " + players[contador].getNom());
            if (torn == 0 || torn == 1) {
                if (Llegir.demanarAleatori()) {
                    iniciarVaixellsAleatoris();
                    taulerJugador.imprimirTaulerIntern();
                }
                else {
                    for (int i = 0; i < vaixellsNecessaris.length; i++) {
                        taulerJugador.imprimirTaulerIntern();
                        iniciarVaixell(vaixellsNecessaris[i]);
                    }
                }
            }
            else {
                taulerJugador.imprimirTaulerExtern();
                bombardejar();
                if (haGuanyat()) {
                    taulerJugador.imprimirTaulerExtern();
                    System.out.println(players[torn % 2].getNom() + " has Guanyat!!!");
                    break;
                }
            }
            torn++;
        } while (true);
    }
}
