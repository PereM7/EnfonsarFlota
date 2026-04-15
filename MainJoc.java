package Principi.Reptes.EnfonsarFlota;

public class MainJoc {
    public static void main (String[] args) {

        Joc joc = new Joc ();
        joc.jugar();
    }
}
// Les caselles que no tenen cap part de vaixell assignada donen error al bombardejar.
// Segurament perque al intentar bombardejar i veure que es null no pot fer cap acció.
// S'ha de comprovar previament si es null o llevar l'estat de null.
// O mirar de fer certes accions només si hi ha part de vaiexll.