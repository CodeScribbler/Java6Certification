package _05_04;

import java.util.ArrayList;
import java.util.List;

public class Mannschaft <S extends Spieler> {

    private List<S> mannschaftsList = new ArrayList<S>();

    public void aufnehmen(S spieler) {
        mannschaftsList.add(spieler);
    }

    public void rausschmeissen(S spieler) {
       if(mannschaftsList.remove(spieler)) System.out.println("Der Spieler wurde entfernt!");
       else System.out.println("Der Spieler konnte nicht gefunden werden!");
    }

    public void auswechseln(S alt, S neu) {
        int index = mannschaftsList.indexOf(alt);
        mannschaftsList.set(index, neu);
    }

    public void ausgabeMannschaft() {
        for (Spieler index : mannschaftsList) {
            System.out.println(index.getName());
        }
    }

}