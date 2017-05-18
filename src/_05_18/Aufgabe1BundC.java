package _05_18;



public class Aufgabe1BundC {

    public static double[] zeilenSumme(double[][] val) {
        double[] field = new double[val.length];

        for (int i = 0; i <val.length ; i++) {
            for (int j = 0; j <i; j++) {
                field[j] = val[i][j];
            }
        }
        return field;
    }

    public double[] delete(double k, double[] field) {
        double[] copy = new double[field.length];

        for (int i = 0; i <field.length ; i++) {
            if (i != k)
                copy[i] = field[i];
            if (k < 0)
                copy[i] = 0.0;
            if (k >= field.length)
                field[field.length] = 0.0;
        }
        return copy;
    }

}



class Medium {

    private String titel;


    public void ausgeben() {
        System.out.println("Titel: " + this.titel);
    }


    public Medium(String titel) {
        this.titel = titel;
    }

}

class Buch  extends Medium {

    private String autor;

    public void ausgeben() {
        super.ausgeben();
        System.out.println("Autor: " + this.autor);
    }


    public Buch(String titel, String autor) {
        super(titel);
        this.autor = autor;
    }

}

class Film extends Medium {

    private int spieldauer;

    public void ausgeben() {
        super.ausgeben();
        System.out.println("Spieldauer: " + this.spieldauer);
    }

    public Film(String titel, int spieldauer) {
        super(titel);
        this.spieldauer = spieldauer;
    }
}



class Result { // Spielergebnisse

    public String team1, team2; // Manschaften

    public int tore1, tore2; // erzielte Tore

    public Result(String team1, String team2, int tore1, int tore2) {
        this.team1 = team1;
        this.team2 = team2;
        this.tore1 = tore1;
        this.tore2 = tore2;
    }

    public Result() {}

}


class ResultException extends Exception {

    private String team1;
    private String team2;

    // Konstruktor
    ResultException (String team1, String team2) { // Message-String des Exception-Objekts festlegen
        super("fuer das Spiel " + team1 + " gegen " + team2);
        this.team1 = team1;
        this.team2 = team2;
    }

    @Override
    public String getMessage() {
        return "Text Fehlerhafte Daten für das Spiel" + this.team1 + " gegen " + this.team2;
    }
}


class LigaToreSummierer {

    public static int summeIn (String land, Result result) throws ResultException {
        int summe = 0;
        LigaTicker lTicker = new LigaTicker(land);

        if (result.tore1 < 0) throw new ResultException(result.team1, result.team2);
        summe += result.tore1;
        if (result.tore2 < 0) throw new ResultException(result.team1, result.team2);
        summe += result.tore2;

        return summe;
    }
}


class LigaToreIn {

    public static void main(String[] args) {
        int value = 0;
        LigaTicker lt;

        if (args[0] != null)
            lt = new LigaTicker(args[0]);
        else
            lt = new LigaTicker("Italien");

        try {

            value = LigaToreSummierer.summeIn(lt.getLand(), new Result("Team-1", "Team-2", 23, 23));
            System.out.println("Die Summe aller Tore der Liga in " + lt.getLand() + " ist " + value);

        } catch (ResultException e) {
            System.err.println(e.getMessage());
        }

    }
}


class LigaTicker {

    private String land;


    public String getLand() {
        return land;
    }


    public boolean resultAvailable(Result obj) {
        return obj.tore1 > 0 || obj.tore2 > 0;
    }


    public Result nextResult() {
        return new Result();        // k.A
    }


    public LigaTicker (String land) {
        this.land = land;
    }

}