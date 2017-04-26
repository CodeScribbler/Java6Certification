package io;

import model.*;

public class Output {

    public static String printPerson(Person obj) {
        return "  Person: \n --------- \n   Name: " + obj.getName() +
                "\n Gender: " + ((obj.getGender() == Gender.MALE) ? "Male" : "Female") +
                "\n Height: " + obj.getHeight() + "\n Weight: " + obj.getWeight() + "\n";
    }

    public static String printPersonWithWeight(Person obj) {
        return printPerson(obj) + " Normal weight: " + obj.getNormalWeight() + "\n Ideal body weight: " + obj.getIdealWeight() + "\n";
    }

    public static String printPersonWithWeightAndBmi(Person obj) {
        return printPersonWithWeight(obj) + " BMI-value: " + obj.getBmiValue();
    }

}
