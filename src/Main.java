import java.util.ArrayList;
import java.util.Collections;

/**
 * Name: Anjola Aina
 * Date: Sunday, March 13th, 2022
 *
 * Information:
 * This class contains the main method, which will be used to run the heapsort algorithm on an unsorted array list.
 * It includes the following methods:
 *
 * heapSort(ArrayList<Integer>) -> void
 */
public class Main {

    public static void main (String[] main) {
    } // main

    /**
     * Creates a max heap array list, sorts the max heap, and prints the sorted array list.
     * @param arrayList the array list to be sorted
     */
    public static void heapSort(ArrayList<Integer> arrayList) {
        Heap aHeap = new Heap(arrayList.size());
        aHeap.buildMaxHeap(arrayList);
        for (int i = arrayList.size() - 1; i > 0; i--) {
            Collections.swap(arrayList, 0, i);
            aHeap.decreaseHeapSize();
            aHeap.maxHeapify(arrayList, 0);
        }
        aHeap.printHeap(arrayList);
    } // heapSort

} // class
