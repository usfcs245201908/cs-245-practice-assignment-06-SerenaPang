import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack {
    private int size ;
    private T [] arr;
    public ArrayStack() {
        arr = (T[]) (new Object[10]);
        size = 0;
    }

    @Override
    public void push(Object item) {
        if (size == arr.length) {
            DoubleSize();
        }
        arr[size] = (T)item;
        size++;
    }
    @Override
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        T top = arr[size - 1];
        arr[size - 1] = null;
        size--;
        return top;
    }

    @Override
    public Object peek() {
        if (size == 0) {
            return new EmptyStackException();
        }
        return arr[size - 1];
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    private void DoubleSize() {
        T[] newElements = (T[]) (new Object[2 * arr.length]);
        for (int i = 0; i < size; i++) {
            newElements[i] = arr[i];
        }
        arr = newElements;
    }
}
