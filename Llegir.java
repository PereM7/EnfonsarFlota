package Principi.Reptes.EnfonsarFlota;

import java.util.Scanner;

public class Llegir {
    private static final Scanner sn = new Scanner(System.in);

    public Llegir () {}

    public static String demanarNom () {
        System.out.println("Introdueix el teu nom: ");
        return sn.nextLine();
    }

    private static boolean esDinsTauler (Posicio pos) {
        int fila = pos.getFila();
        int columna = pos.getColumna();

        if ((fila <= 8 && fila >= 0) && (columna <= 8 && columna >= 0)) {
            return true;
        }
        return false;
    }

    public static Posicio demanarVaixell (TipusVaixell tipus) {
        Posicio novaPos;

        do {
            System.out.println("Introdueix fila inicial del " + tipus + ": ");
            int fila = sn.nextInt();
            System.out.println("Introdueix columna inicial del " + tipus + ": ");
            int columna = sn.nextInt();
            novaPos = new Posicio(fila, columna);

            if (!esDinsTauler(novaPos)) {
                System.out.println("Error, han de ser valors del 0 al 7 incluits.");
            }
        } while (!esDinsTauler(novaPos));

        return novaPos;
    }

    public static Direccio demanarDireccio () {
        String direccio = "";
        do {
            System.out.println("Introdueix la direcció (H / V): ");
            direccio = sn.nextLine().toLowerCase();

            if (!direccio.equals("h") && !direccio.equals("v")) {
                System.out.println("Error, ha de ser H o V.");
            }
        } while (!direccio.equals("h") && !direccio.equals("v"));

        Direccio dir;
        if (direccio.equals("h")) {
            dir = Direccio.Horitzontal;
        }
        else {
            dir = Direccio.Vertical;
        }
        return dir;
    }

    public static Posicio demanarPosicio () {
        Posicio novaPos;
        do {
            System.out.println("Introdueix fila (0-7): ");
            int fila = sn.nextInt();
            System.out.println("Introdueix columna (0-7): ");
            int columna = sn.nextInt();

            novaPos = new Posicio(fila, columna);

            if (!esDinsTauler(novaPos)) {
                System.out.println("Error, han de ser valors del 0 al 7 incluits.");
            }
        }while(!esDinsTauler(novaPos));
        return novaPos;
    }


}
