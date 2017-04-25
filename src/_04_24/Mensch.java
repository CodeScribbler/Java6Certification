package _04_24;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Mensch implements Comparable<Mensch> {

    enum Gender {
        MALE, FEMALE
    }

    private int age;
    private String name;
    private double size;
    private Gender gender;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public Gender getGender() {
        return gender;
    }


    public Mensch(int age, String name, double size, Gender gender) {
        this.age = age;
        this.name = name;
        this.size = size;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mensch mensch = (Mensch) o;

        if (age != mensch.age) return false;
        if (Double.compare(mensch.size, size) != 0) return false;
        if (name != null ? !name.equals(mensch.name) : mensch.name != null) return false;
        return gender == mensch.gender;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(size);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mensch{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", gender=" + gender +
                '}';
    }

    @Override
    public int compareTo(Mensch o) {
        return 0;
    }

}

class Test {

    public static void main(String[] args) {

        System.out.println(MenschControl.menschList);


        Collections.sort(MenschControl.menschList, new Comparator<Mensch>() {
            @Override
            public int compare(Mensch o1, Mensch o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println(MenschControl.menschList);


    }

}

class MenschControl {

    static List<Mensch> menschList = new ArrayList<Mensch>();

    static {
        menschList.add(new Mensch(16, "Dave", 1.80, Mensch.Gender.MALE));
        menschList.add(new Mensch(17, "Chris", 1.82, Mensch.Gender.MALE));
        menschList.add(new Mensch(18, "Steffi", 1.65, Mensch.Gender.FEMALE));
    }
}
