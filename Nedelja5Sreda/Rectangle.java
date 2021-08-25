package Domaci5Sreda;

public class Rectangle extends Shape{
    private double width;
    private double lenght;

    public Rectangle(String name, double width, double lenght) {
        super(name);
        this.width = width;
        this.lenght = lenght;
    }

    @Override
    public double circumference() {
        return 2 * (width + lenght);
    }

    @Override
    public double area() {
        return width * lenght;
    }

    @Override
    public String toString() {
        return " Shape: " + this.getClass().getSimpleName() + "\n" + " Circumference: " + circumference() + "\n" + " Area: "  + area() +  "\n" +  "___________________";
    }
}
