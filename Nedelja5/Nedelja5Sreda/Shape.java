package Domaci5Sreda;

public abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }
    /*Constructor*/
    // TODO: Implement me

    /*Methods*/
    public abstract double circumference();

    public abstract double area();

    //Shape: {name}
    //Circumference: {circumference()}
    //Area: {area()}
    //-----------------
    @Override
    public String toString() {
        return  "Shape: " + name + "\n" + " Circumference: " + circumference() + "\n" + " Area: " + area();
    }


}