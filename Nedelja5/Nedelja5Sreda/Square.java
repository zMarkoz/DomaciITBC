package Domaci5Sreda;

public class Square extends Shape{
    private double a;

    public Square(String name, double a) {
        super(name);
        this.a = a;
    }

    @Override
    public double circumference() {
        return 4 * a;
    }

    @Override
    public double area() {
        return a * a;
    }

    @Override
    public String toString() {
        return " Shape: " + this.getClass().getSimpleName() + "\n" + " Circumference: " + circumference() + "\n" + " Area: " + area() +  "\n" + "___________________";
    }
}
