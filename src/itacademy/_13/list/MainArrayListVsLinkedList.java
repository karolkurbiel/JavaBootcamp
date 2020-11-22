package itacademy._13.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainArrayListVsLinkedList {

    private static ArrayList<Integer> firstTestList = new ArrayList<>();
    private static LinkedList<Integer> secondTestList = new LinkedList<>();


    public static void main(String[] args) {
        long arrayListDuration = listAddDuration(firstTestList, System.currentTimeMillis());
        long linkedListDuration = listAddDuration(secondTestList, System.currentTimeMillis());

        System.out.println("list.add() execution time:");
        System.out.println("\tArrayList: " + arrayListDuration);
        System.out.println("\tLinkedList: " + linkedListDuration);

        arrayListDuration = listGetDuration(firstTestList, System.currentTimeMillis());
        linkedListDuration = listGetDuration(secondTestList, System.currentTimeMillis());

        System.out.println("list.get() execution time:");
        System.out.println("\tArrayList: " + arrayListDuration);
        System.out.println("\tLinkedList: " + linkedListDuration);
    }

    private static long listAddDuration(List<Integer> inputList, long startPoint) {
        for(int i = 0; i < 100_001; i++) {
            inputList.add(0, i);
        }
        return System.currentTimeMillis() - startPoint;
    }

    private static long listGetDuration(List<Integer> inputList, long startPoint) {
        for(int i = 0; i < 100_001; i++) {
            inputList.get(i);
        }
        return System.currentTimeMillis() - startPoint;
    }

    /*
    Execution time differs because:
        - In the first case, when we add to an ArrayList, it has to constantly create a new array of different sizes and
        shift the indexes of the objects due to the constantly adding new ones at position [0], so it has to move every
        existing object indexes.
        In the case of LinkedList, when we add a new object to the list at position [0], the existing object at that
        position will get the left link referring to the new object that will appear before it in the list.

        - In the second case, when we're getting from an ArrayList by index, it is fast because each object in the array
        has it's index.
        For LinkedList this is long because every time we want to get something by index, the List has to iterate
        through itself to know required element index due to the lack of a direct index assignment.
     */
}
