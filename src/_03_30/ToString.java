package _03_30;

public class ToString {

    public static void main(String[] args) {
        Person obj = new Person("Esch", "Philipp", 29);
        System.out.println(obj);
        System.out.println(obj.hashCode());
    }



}


class Person {

    private String name;
    private String vorname;
    private int alter;

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public int getAlter() {
        return alter;
    }


    public Person(String name, String vorname, int alter) {
        this.name = name;
        this.vorname = vorname;
        this.alter = alter;
    }

    @Override
    public String toString() {
        return "Person{ name='" + name + '\'' + ", vorname='" + vorname + '\'' + ", alter=" + alter + '}';
    }
}