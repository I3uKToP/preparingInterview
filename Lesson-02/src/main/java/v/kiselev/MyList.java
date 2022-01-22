package v.kiselev;

public interface MyList<T> {


    int indexOf(T item);

    boolean remove(T item);

    int size();

    boolean isEmpty();

}
