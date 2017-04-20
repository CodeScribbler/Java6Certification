package _03_20;

public class PunktImRaum {

    private int x;
    private int y;
    private int z;

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }
    public void setZ(int z) {
        this.z = z;
    }


    public PunktImRaum() {}

    public PunktImRaum(int x, int y, int z) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }

    public PunktImRaum(int x, int z) {
        this.setX(x);
        this.setY(1);
        this.setZ(z);
    }

    public static void main(String[] args) {

        PunktImRaum p = new PunktImRaum();

    }


}
