package _04_12;

import java.io.File;
import java.io.IOException;


public class Streams {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\pesch\\Desktop\\test.txt");

        try {

            file.createNewFile();

            int a = 1;

            switch (a) {
                case 1:
            }


        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

    }

}

