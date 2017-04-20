package _03_16;

public class Point {

    private double x;
    public double getX() {
        return this.x;
    }
    public void setX(double valueX) {
        this.x = valueX;
    }

    private double y;
    public double getY() {
        return this.y;
    }
    public void setY(double valueY) {
        this.y = valueY; }

    public Point(double valueX, double valueY) {
        this.setX(valueX);
        this.setY(valueY);
    }

    public byte getQuadrant() {
        if (this.getX() >= 0.0 && this.getY() > 0.0 || this.getX() > 0.0D && this.getY() >= 0.0) {
            return 1;
        }
        if (this.getX() <= 0.0 && this.getY() > 0.0 || this.getX() < 0.0D && this.getY() >= 0.0) {
            return 2;
        }
        if (this.getX() <= 0.0 && this.getY() < 0.0 || this.getX() < 0.0 && this.getY() <= 0.0) {
            return 3;
        }
        if (this.getX() >= 0.0 && this.getY() < 0.0 || this.getX() > 0.0 && this.getY() <= 0.0) {
            return 4;
        }
        return 0;
    }

    public void scale(double scaleValue) {
        System.out.println("Alte Position von X: " + this.getX());
        System.out.println("Alte Position von Y: " + this.getY());

        setX(scaleValue * this.getX());
        setY(scaleValue * this.getY());

        System.out.println("Neue Position von X: " + this.getX());
        System.out.println("Neue Position von Y: " + this.getY());
    }

    public double distance(Point obj) {
        double dx = obj.getX() - this.getX();
        double dy = obj.getY() - this.getY();
        double d1 = Math.pow(dx, 2.0);
        double d2 = Math.pow(dy, 2.0);
        double abstand = d1 + d2;
        return Math.sqrt(abstand);
    }

    public Point createPoint(Point pointOne, Point pointTwo) {
        Point obj = new Point(pointOne.getX() * 1.5, pointTwo.getY() * 1.5);
        return obj;
    }
}