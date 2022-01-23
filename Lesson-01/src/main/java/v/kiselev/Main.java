package v.kiselev;

import v.kiselev.figure.Circle;
import v.kiselev.figure.Figure;
import v.kiselev.figure.Square;
import v.kiselev.figure.Triangle;

public class Main {

    public static void main(String[] args) {
        Person person = Person.createPerson()
                .firstName("Viktor")
                .lastName("Kiselev")
                .age(29)
                .build();

        System.out.println(person.getFirstName());

        Figure circle = new Circle(10);
        Figure square = new Square(10);
        Figure triangle = new Triangle(10,10);
        System.out.println(circle.square());
        System.out.println(square.square());
        System.out.println(triangle.square());

    }
}
