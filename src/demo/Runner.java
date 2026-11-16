package demo;

import array.MyArrayList;

import java.util.Iterator;
import java.util.Random;

public class Runner {

    public static void main(String[] args) {
        Runner obj = new Runner();
        obj.TestArrayList();
    }


    private void TestArrayList() {
        // creating array of default size = 10
        MyArrayList<Integer> myList = new MyArrayList<>();
        Random random = new Random();

        // adding 20 elements, it will trigger resize after adding 7 elements
        for(int i = 0; i < 20; i++) {
            myList.add(random.nextInt());
        }

        System.out.println("Size of my List: " + myList.size());

        System.out.println("Item at index 4: " + myList.get(4));

        System.out.println("Removing item at index 4: " + myList.remove(4));

        System.out.println("Size of my List after removing element: " + myList.size());


        System.out.println("Printing the ArrayList...");
        Iterator<Integer> it = myList.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
