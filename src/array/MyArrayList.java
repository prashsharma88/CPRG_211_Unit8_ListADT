package array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T> {
    private Object[] data;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private int THRESHOLD;

    public MyArrayList() {
        data = new  Object[DEFAULT_CAPACITY];
        THRESHOLD = 7;
        System.out.println("Creating default array of: " + DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialSize) {
        data = new Object[initialSize];
        THRESHOLD = (int) (0.7 * initialSize);
        System.out.println("Creating array of: " + initialSize);
    }


    /***
     * Add the element (T) at the end of the array.
     * Internally resize the data array if it exceeds the threshold value
     * @param element: Item to add
     */
    public void add(T element) {
        if(size >= THRESHOLD) {
            resize();
        }
        data[size] = element;
        size++;
    }

    /***
     * Resize the internal data array if threshold is reached.
     * New data array will be twice the size of original data array
     */
    public void resize() {
        int newCapacity = data.length * 2;
        System.out.println("Resizing the internal data array from " + data.length + " to " + newCapacity);
        Object[] newData = new Object[newCapacity];
        for(int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
        THRESHOLD = (int) (0.7 * newCapacity);
    }

    /***
     * Return the element at given index.
     * @param index of element.
     * @return Element at the given index
     * @exception IndexOutOfBoundsException if index is out of range of size.
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if( index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        return (T) data[index];
    }


    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        }
        Object removedItem = data[index];

        // shift elements to left
        for(int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size --;
        return (T) removedItem;
    }


    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<T> {

        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            if (!hasNext() ) {
                throw new NoSuchElementException("No element left to return");
            }
            return (T) data[cursor++];
        }
    }
}
