package _04_27;

/*
 * Ergänze die Klasse Teilnehmer folgendermaße:
 *
 * 				-Mit Attribut Note (Soll ein Enum sein ...)
 * 				-Der Konstruktor, hascode und equals  sollen entsprechend angepasst werden
 * 				-Teilnehmer Objekte sollten in einem Treeset verwaltet werden können (automatisch nach id sortiert)
 * 				-Jeder Teilnehmer soll eindeutiger Id haben...
 *
 * Test.Java
 * 			-Arbeite mit TreeSet von Teilnehmern
 *
 * 	-retun: ein Treeset mit Teilnehmer mit eindeutigen Note aufsteigend sortiert (1,0 1,3 1,7 ...)
 * private static TreeSet<Teilnehmer> sampleTeilnehmer(TreeSet<Teilnehmer> teilnehmerliste){
 *
 * }
 *
 * 		Holger 1,0 Daniel 1,0 wissem 1,0 .... Stefan 1,3 Torsten 1,3
 *
 * [Holger 1,0 Torsten 1,3]
 */


public class Teilnehmer implements Comparable {

    static int ID = 100000;

    String name;    //Stefan Wege
    String kurs;    //OCPJP
    int id;         //123
    Note note;      //Note: 1,0 1,3 1,7 2,0 .... 5,0


    public Teilnehmer(String name, String kurs, Note note) {
        super();
        this.name = name;
        this.kurs = kurs;
        this.id = ID++;
        this.note = note;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teilnehmer that = (Teilnehmer) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (kurs != null ? !kurs.equals(that.kurs) : that.kurs != null) return false;
        return note == that.note;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (kurs != null ? kurs.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}