package v.kiselev.figure;

public class Circle extends Figure{
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double square() {
        return Math.PI*Math.pow(radius, 2);
    }
}
