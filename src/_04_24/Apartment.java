package _04_24;


import java.io.Serializable;

public class Apartment implements Serializable, Comparable<Apartment> {

    private double rent;
    private int rooms;
    private int size;
    private String district;

    public double getRent() {
        return rent;
    }

    public int getRooms() {
        return rooms;
    }

    public int getSize() {
        return size;
    }

    public String getDistrict() {
        return district;
    }


    public Apartment(double rent, int rooms, int size, String district) {
        this.rent = rent;
        this.rooms = rooms;
        this.size = size;
        this.district = district;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "rent=" + rent +
                ", rooms=" + rooms +
                ", size=" + size +
                ", district='" + district + '\'' +
                '}';
    }

    @Override
    public int compareTo(Apartment o) {
        if(this.getDistrict().equalsIgnoreCase(o.getDistrict())) return 1;
        return 0;
    }

}
