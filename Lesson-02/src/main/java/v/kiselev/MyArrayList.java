package v.kiselev;

public class MyArrayList<T> implements MyList{
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        this.capacity = capacity;
        list = (T[]) new Comparable[capacity];
    }

    public MyArrayList() {
        capacity = DEFAULT_CAPACITY;
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    @Override
    public void add(Object item) {
        if (size==capacity) {
            increaseArray();
        }
        list[size] = (T) item;
        size++;
    }

    @Override
    public void add(int index, Object item) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(size==capacity) {
            increaseArray();
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = (T) item;
        size++;
    }

    private int index(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i] != null && list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int indexOf(Object item) {
        return index((T) item);
    }

    public void remove(int index) {
        //check index
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
    }

    @Override
    public boolean remove(Object item) {
        int i = index((T) item);
        if (i == -1) {
            return false;
        }
        remove(i);
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        //check index
        return list[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append(", ");
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    private void increaseArray() {
        int newSize = (int) (capacity*1.5+1);
        T[] temp = (T[]) new Object[newSize];
        System.arraycopy(list, 0, temp, 0, size);
        list = temp;
    }
}
