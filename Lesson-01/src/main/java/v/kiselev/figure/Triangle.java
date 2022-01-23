package v.kiselev.figure;

public class Triangle  extends Figure{
    private int a;
    private int h;

    public Triangle(int a, int h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public double square() {
        return a*h/2;
    }
}
