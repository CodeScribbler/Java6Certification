package _03_21;

public class Produkt {

    private int price;
    private String name;
    static int mwst;

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static int getMwst() {
        return mwst;
    }
    public static void setMwst(int mwst) {
        Produkt.mwst = mwst;
    }

    public Produkt(int price, String name) {
        this.price = price;
        this.name = name;
    }

}
