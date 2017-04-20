package model;

public class Bmi {

    private float normalgewicht;
    private float idealgewicht;
    private float bmiwert;

    private static final float MALE = 0.9F;
    private static final float FEMALE = 0.85F;

    Bmi() {

    }

    public static float getNormalgewicht(Person obj) {
        return obj.getKoerpergroesse() - 100;
    }

    public static float getIdealgewicht(Person obj) {
        float tmp = getNormalgewicht(obj);
        if (obj.getGeschlecht()) {                  // Männlich
            return tmp * MALE;
        } else {                                      // Weiblich
            return tmp * FEMALE;
        }
    }

    public static float getBmi(Person obj) {
        return (float) (obj.getGewicht() / (Math.pow((double) obj.getKoerpergroesse() / 100.0, 2)));
    }

}
