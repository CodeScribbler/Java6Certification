package model;

public class Bmi {

    private Bmi() {}

    private static final float MALE = 0.9F;
    private static final float FEMALE = 0.85F;


    public static float getNormalgWeight(Person obj) {
        return obj.getHeight() - 100;
    }

    public static float getIdealgewicht(Person obj) {
        if (obj.getGender() == Gender.MALE) {
            return getNormalgWeight(obj) * MALE;
        } else {
            return getNormalgWeight(obj) * FEMALE;
        }
    }

    public static float getBmi(Person obj) {
        return (float) (obj.getWeight() / (Math.pow((double) obj.getHeight() / 100.0, 2)));
    }

}
