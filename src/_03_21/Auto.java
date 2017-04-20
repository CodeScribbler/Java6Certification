package _03_21;

public class Auto {

    private int maxSpeed;
    private int minSpeed;
    private String model;

    public int getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMinSpeed() {
        return minSpeed;
    }
    public void setMinSpeed(int minSpeed) {
        this.minSpeed = minSpeed;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public Auto(int maxSpeed) {
        this(maxSpeed, 0, "xyz");
    }

    public Auto(int maxSpeed, int minSpeed) {
        this.maxSpeed = maxSpeed;
        this.minSpeed = minSpeed;
        this.model = "xyz";
    }

    public Auto(int maxSpeed, int minSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.minSpeed = minSpeed;
        this.model = model;
    }

    public void go() {
        foo();
    }

    public void foo() {

    }

}
