package v.kiselev;

public interface MyList<T> {


    void add(Object item);

    void add(int index, Object item);

    int indexOf(T item);

    boolean remove(T item);

    int size();

    boolean isEmpty();


}
