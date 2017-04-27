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


public class Teilnehmer {
    String name;    //Stefan Wege
    String kurs;    //OCPJP
    int id;         //123
    Note note;      //Note: 1,0 1,3 1,7 2,0 .... 5,0


    public Teilnehmer(String name, String kurs, int id, Note note) {
        super();
        this.name = name;
        this.kurs = kurs;
        this.id = id;
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teilnehmer that = (Teilnehmer) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        if (!kurs.equals(that.kurs)) return false;
        return note == that.note;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + kurs.hashCode();
        result = 31 * result + id;
        result = 31 * result + note.hashCode();
        return result;
    }
}