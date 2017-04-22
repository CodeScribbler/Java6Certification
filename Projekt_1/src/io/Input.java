package io;

import model.Gender;
import model.Start;
import model.Person;
import util.Utility;

public class Input {

    private Input() {}

    public static Person createPerson() {

        String name = null;
        Gender gender = null;
        int height = 0;
        float weight = 0.0F;

        System.out.println("----- Start reading the personal data -----\n");

        while (gender == null) {
            gender = Utility.readGender("Input gender: male = M   -   female = F: ");
        }

        while (name == null){
            name = Utility.readString("Input name: ");
        }

        while (height <= 0) {
            height = Utility.readInt("Input height in cm: ");
        }

        while (weight <= 0.0F) {
            weight = Utility.readFloat("Input weight: ");
        }

        System.out.println("----- Read in the personal data completed -----\n\n");

        return new Person(name, gender, height, weight);
    }

}
