package v.kiselev.figure;

public class Square extends Figure{
    private int a;

    public Square(int a) {
        this.a = a;
    }


    @Override
    public double square() {
        return a*a;
    }
}
