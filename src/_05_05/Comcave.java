package _05_05;


import java.util.*;

public class Comcave implements Comparator<Teilnehmer> {

    List<Teilnehmer> teilnehmerList;


    public Comcave() {
        this.teilnehmerList = new ArrayList<Teilnehmer>();
    }


    public void teilnehmerAufnehmen() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Eingabe Kurs: ");
        String kurs = scan.next();

        System.out.print("Eingabe Kursdauer: ");
        int dauer = scan.nextInt();

        System.out.print("Eingabe Name: ");
        String name = scan.next();

        teilnehmerList.add(new Teilnehmer(kurs, dauer, name));
    }

    public void sortiertNachKurs() {
        Collections.sort(teilnehmerList, new Comparator<Teilnehmer>() {
            @Override
            public int compare(Teilnehmer first, Teilnehmer second) {
                return first.getKurs().compareTo(second.getKurs());
            }
        });
    }

    public void sortiertNachName() {
        Collections.sort(teilnehmerList, new Comparator<Teilnehmer>() {
            @Override
            public int compare(Teilnehmer first, Teilnehmer second) {
                return first.getName().compareTo(second.getName());
            }
        });
    }

    @Override
    public int compare(Teilnehmer o1, Teilnehmer o2) {
        return o1.getName().compareTo(o2.getName());
    }


    class sortiertNachName implements Comparator<Teilnehmer> {
        @Override
        public int compare(Teilnehmer first, Teilnehmer second) {
            return first.getName().compareTo(second.getName());
        }
    }

    class sortiertNachKurs implements Comparator<Teilnehmer> {
        @Override
        public int compare(Teilnehmer first, Teilnehmer second) {
            return first.getKurs().compareTo(second.getKurs());
        }
    }

}
