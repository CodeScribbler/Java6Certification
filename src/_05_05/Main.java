package _05_05;

import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Comcave cave = new Comcave();

        cave.teilnehmerAufnehmen();


        cave.sortiertNachKurs();

        cave.sortiertNachName();


        // Über inner Klasse
        cave.new sortiertNachKurs();

        cave.new sortiertNachName();



        // Über anonyme Klasse
        Collections.sort(cave.teilnehmerList, new Comparator<Teilnehmer>() {
            @Override
            public int compare(Teilnehmer first, Teilnehmer second) {
                return first.getKurs().compareTo(second.getKurs());
            }
        });

        Collections.sort(cave.teilnehmerList, new Comparator<Teilnehmer>() {
            @Override
            public int compare(Teilnehmer first, Teilnehmer second) {
                return first.getName().compareTo(second.getName());
            }
        });

    }

}
