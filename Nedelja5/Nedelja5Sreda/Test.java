package Domaci5Sreda;

public class Test {

    public static void main(String[] args) {

        Rectangle r = new Rectangle("Rectangle", 5, 4);
        Square s = new Square("Square",5);
       Circle c = new Circle("Circle", 5);
        Triangle t = new Triangle("Triangle", 3, 3, 3);
        System.out.println(s);
        System.out.println(r);
        System.out.println(s);
        System.out.println(c);
        System.out.println(t);

    }
}