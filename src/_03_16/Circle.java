package _03_16;

public class Circle {

    private double radius;
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    private Point point;
    public Point getPoint() {
        return point;
    }
    public void setPoint(Point point) {
        this.point = point;
    }

    public Circle() {
        this.setRadius(5.0);
        this.setPoint(new Point(3.0, 4.0));
    }

    public Circle(double radius, Point point) {
        this.setRadius(radius);
        this.setPoint(point);
    }

    public void getCircleInfo() {
        System.out.println("Kreis(" + this.getRadius() + ", Punkt(" + this.getPoint() + "))");
    }

    public double getArea() {
        return Math.PI * this.getRadius() * this.getRadius();
    }

    public double getScope() {
        return 2*Math.PI * this.getRadius();
    }

    public boolean checkPointPosition(Point obj) {
        double dx = this.point.getX() - obj.getX();
        double dy = this.point.getY() - obj.getY();
        return (dx*dx + dy*dy <= this.getRadius() * this.getRadius());
    }

}
