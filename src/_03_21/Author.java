package _03_21;

public class Author {

    private final String name;
    private final String nachname;
    private final String mittelName;


    public String getName() {
        return name;
    }

    public String getNachname() {
        return nachname;
    }

    public String getMittelName() {
        return mittelName;
    }


    public Author(String name, String nachname, String mittelName) {
        this.name = name;
        this.nachname = nachname;
        this.mittelName = mittelName;
    }

}