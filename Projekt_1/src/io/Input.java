package io;

import model.Gender;
import util.IOTools;
import model.Person;

public class Input {

    private Input() {}

    public static Person createPerson() {

        String tmpStr;

        String name;
        Gender gender;
        int height;
        float weight;

        System.out.println("----- Start reading the personal data -----\n");
        do {
            System.out.print("\nInput gender: male = M   -   female = F: ");
            tmpStr = IOTools.readLine();
        } while (!(tmpStr.equalsIgnoreCase("M") || tmpStr.equalsIgnoreCase("F")));
        if(tmpStr.equalsIgnoreCase("M")) gender = Gender.MALE;
        else gender = Gender.FEMALE;

        do {
            System.out.print("\nInput name:");
            name = IOTools.readLine();
        } while (name.isEmpty());

        do {
            System.out.print("\nInput height in cm: ");
            height = IOTools.readInt();
        } while (height == 0);

        do {
            System.out.print("\nInput weight: ");
            weight = IOTools.readFloat();
        } while (weight == 0);

        System.out.println("----- Read in the personal data completed -----\n\n");

        return new Person(name, gender, height, weight);
    }

}
