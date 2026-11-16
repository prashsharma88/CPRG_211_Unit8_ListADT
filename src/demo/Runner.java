package demo;

import array.MyArrayList;
import list.MySingleLinkedList;

import java.util.Iterator;
import java.util.Random;

public class Runner {

    public static void main(String[] args) {
        Runner obj = new Runner();
//        obj.TestArrayList();

//        obj.TestLinkedList();

        obj.ComparePerformance();
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


    private void TestLinkedList() {
        MySingleLinkedList<Integer> myList = new MySingleLinkedList<>();
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

    private void ComparePerformance () {
        System.out.println("Adding 1000 elements at the end of collection");
        MyArrayList<Integer> myArray = new MyArrayList<>();
        MySingleLinkedList<Integer> myList = new MySingleLinkedList<>();

        long endTime;
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < 1000; i++) {
            myArray.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Array took: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++) {
            myList.add(i);
        }
        endTime = System.currentTimeMillis();

        System.out.println("List took: " + (endTime - startTime) + " ms");


        System.out.println("Removing 800 Random element from the collection");

        Random random = new Random();

        startTime = System.currentTimeMillis();
        for(int i = 0; i < 800; i++) {
            int idx = random.nextInt(myArray.size());
            myArray.remove(idx);
        }
        endTime = System.currentTimeMillis();

        System.out.println("Array took: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        for(int i = 0; i < 800; i++) {
            int idx = random.nextInt(myList.size());
            myList.remove(idx);
        }
        endTime = System.currentTimeMillis();

        System.out.println("List took: " + (endTime - startTime) + " ms");
    }
}
