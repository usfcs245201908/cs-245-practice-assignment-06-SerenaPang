import java.lang.Exception;

public class ArrayQueue<T> implements Queue {
    private int default_size =10;
    private int size;
    private T [] arr;
    public  ArrayQueue(){
    
        size = 0;
        arr = (T[]) new Object[default_size];
    }
    @Override
    public Object dequeue() {
        if (empty()){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        T result = arr[0];

        size--;

        for (int i=0; i < size; i++)
            arr[i] = arr[i+1];
        arr[size] = null;

        return result;
    }

    @Override
    public void enqueue(Object item) {
        if (size() == arr.length) {
            DoubleSize();
        }
        arr[size] = (T)item;
        size++;

    }
    public int size()
    {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    private void DoubleSize()
   {
      T[] larger = (T[])(new Object[arr.length*2]);

      for (int scan=0; scan < arr.length; scan++)
         larger[scan] = arr[scan];

      arr = larger;
   }
}
