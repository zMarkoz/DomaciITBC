package Domaci5Sreda;

public class Triangle extends Shape {
    private double a, b, c;

    public Triangle(String name, double a, double b, double c) {
        super(name);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double circumference() {
        return a + b + c;
    }

    @Override
    public double area() {
        double x = (a + b + c) / 2;
        return Math.sqrt(x * (x - a) * (x - b) * (x - c));
    }

    @Override
    public String toString() {
        return " Shape: " + this.getClass().getSimpleName() + "\n" + " Circumference: " + circumference() + "\n" + " Area: " + area() + "\n" + "___________________";
    }
}
