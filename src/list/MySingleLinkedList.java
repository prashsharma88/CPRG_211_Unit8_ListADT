package list;

import java.util.Iterator;

public class MySingleLinkedList<T> implements Iterable<T> {

    static class ListItem<T> {
        T data;
        ListItem<T> next;

        ListItem(T element) {
            data = element;
            next = null;
        }
    }

    private ListItem<T> head;
    private int size = 0;

    public MySingleLinkedList() {
        head = new ListItem<T>(null);   // dummy element for head pointer
        size = 0;
    }

    /***
     * Add the element (T) at the end of the list.
     * @param element: Item to add
     */
    public void add(T element) {
        ListItem<T> curr = head;
        ListItem<T> newElement = new ListItem<T>(element);
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = newElement;
        size ++;
    }

    /***
     * Return the element at given index.
     * @param index '0' base index of element.
     * @return Element at the given index
     * @exception IndexOutOfBoundsException if index is out of range of size.
     */
    public T get(int index) {
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        }
        ListItem<T> curr = head.next;
        ListItem<T> returnItem = null;
        int i = 0;
        while(curr != null) {
            if(i == index) {
                return curr.data;
            }
            i++;
            curr = curr.next;
        }
        return null;
    }


    public T remove(int index) {
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        }

        ListItem<T> curr = head.next;
        ListItem<T> prev = head;
        int i = 0;
        ListItem<T> removedItem = null;
        while(curr != null) {
            if(i == index) {
                removedItem = curr;
                prev.next = curr.next;
                curr.next = null;
                break;
            }
            i++;
            prev = curr;
            curr = curr.next;
        }
        if(removedItem != null) {
            size--;
            return removedItem.data;
        }
        return null;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<T> {
        ListItem<T> cursor = head.next;
        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            T data = cursor.data;
            cursor = cursor.next;
            return data;
        }
    }
}
