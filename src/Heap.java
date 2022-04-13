import java.util.ArrayList;
import java.util.Collections;

/**
 * Name: Anjola Aina
 * Date: Sunday, March 13th, 2022
 *
 * Information:
 * This class contains the logic needed to run the heapsort algorithm on an unsorted array list.
 * It includes the following methods:
 *
 * isEmpty() -> boolean
 * makeEmpty(ArrayList<Integer>) -> void
 * heapMax(ArrayList<Integer>) -> int
 * parent(int) -> int
 * leftChild(int) -> int
 * rightChild(int) -> int
 * maxHeapify(ArrayList<Integer>, int) -> void
 * buildMaxHeapify(ArrayList<Integer>) -> void
 * extractMax(ArrayList<Integer>) -> int
 * deleteNode(ArrayList<Integer>, int) -> int
 * insertNode(ArrayList<Integer>,int) -> int
 * increaseNodeKey(ArrayList<Integer>, </Integer>int, int) -> void
 * decreaseHeapSize() -> int
 * setHeapSize(int) -> void
 * printHeap() -> void
 *
 * The isFull() method was not implemented as array lists can change their size dynamically. Therefore, the heap size
 * will also change dynamically.
 */
public class Heap {

    private int heapSize;

    /**
     * Initializes the heap object, by setting the capacity of the heap to be the array list size.
     * @param capacity the size of the array list to be sorted
     */
    public Heap(int capacity) {
        heapSize = capacity;
    } // Heap

    /**
     * Checks if the heap is empty.
     * @return - true if the heap is empty, false otherwise
     */
    public boolean isEmpty() {
        if (heapSize <= 0) {
            return true;
        }
        return false;
    } // isEmpty

    /**
     * Removes all the elements in the heap by clearing the array list. The heap will now be empty.
     */
    public void makeEmpty(ArrayList<Integer> arrayList) {
        arrayList.clear();
        heapSize = arrayList.size();
    } // makeEmpty

    /**
     * Gets the first element of the heap, the maximum element.
     * @return - the maximum element of the heap
     */
    public int heapMax(ArrayList<Integer> arrayList) {
        return arrayList.get(0);
    } // heapMax

    /**
     * Gets the index of the first element of the heap, the root node.
     * @param i the current node
     * @return - the root node
     */
    public int parent(int i) {
        return ((i - 1) / 2);
    } // parent

    /**
     * Gets the left child of a particular node.
     * @param i the current node
     * @return - the left child of a node
     */
    public int leftChild(int i) {
        return (2 * i) + 1;
    } // left

    /**
     * Gets the right child of a particular node.
     * @param i the current node
     * @return - the right child of a node
     */
    public int rightChild(int i) {
        return (2 * i) + 2;
    } // right

    /**
     * Max heapifies the subtree of the node i.
     * @param arrayList the current array list
     * @param i the current node
     */
    public void maxHeapify(ArrayList<Integer> arrayList, int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = 0;
        if (left < heapSize && arrayList.get(left) > arrayList.get(i)) {
            largest = left;
        } else {
            largest = i;
        }
        if (right < heapSize && arrayList.get(right) > arrayList.get(largest)) {
            largest = right;
        }
        if (largest != i) {
            Collections.swap(arrayList, i, largest);
            maxHeapify(arrayList, largest);
        }
    } // maxHeapify

    /**
     * Creates a max heap for an array list.
     * @param arrayList the array to become a max heap
     */
    public void buildMaxHeap(ArrayList<Integer> arrayList) {
        for (int i = (arrayList.size() / 2) - 1; i >= 0; i--) {
            maxHeapify(arrayList, i);
        }
    } // buildMaxHeap

    /**
     * Gets and removes the first element of the heap, the maximum element.
     * @param arrayList the current array list
     * @return - the maximum element of the heap, -1 if the heap is too small
     */
    public int extractMax(ArrayList<Integer> arrayList) {
        if (arrayList.size() < 1) {
            System.out.println("The heap is too small!");
            return -1;
        } else {
            Collections.swap(arrayList, arrayList.size() - 1, 0);
            int max = arrayList.remove(arrayList.size() - 1);
            heapSize = heapSize - 1;
            maxHeapify(arrayList, 0);
            return max;
        }
    } // extractMax

    /**
     * Returns the key of a node i and removes it from the heap.
     * @param arrayList the current array list
     * @param i the current node
     * @return - the key of a node i, -1 if the heap is empty or if the index is not in the current array list
     */
    public int deleteNode(ArrayList<Integer> arrayList, int i) {
        if (isEmpty()) {
            System.out.println("The heap is too small!");
            return -1;
        } else if (i > heapSize) {
            System.out.println("This index is not in the current array list!");
            return -1;
        } else {
            Collections.swap(arrayList, arrayList.size() - 1, i);
            int key = arrayList.remove(arrayList.size() - 1);
            heapSize--;
            maxHeapify(arrayList, i);
            return key;
        }
    } // deleteNode

    /**
     * Inserts a new node into the heap.
     * @param arrayList the current array list
     * @param key the value of the node
     */
    public void insertNode(ArrayList<Integer> arrayList, int key) {
        arrayList.add(key); // adds the key as the last element in the heap array
        heapSize++;
        increaseNodeKey(arrayList, heapSize - 1, key);
    } // insertNode

    /**
     * Increase the node's i key by given key.
     * @param arrayList the current array list
     * @param i the current index of the new node
     * @param key the value of the new node
     */
    private void increaseNodeKey(ArrayList<Integer> arrayList, int i, int key) {
        if (key < arrayList.get(i)) {
            System.out.println("New key is smaller than the current key ");
        }
        while (i > 0 && arrayList.get(parent(i)) <= arrayList.get(i)) {
            Collections.swap(arrayList, i, parent(i));
            i = parent(i);
        }
    } // increaseNodeKey

    /**
     * Decrements the heap size of an array list.
     */
    public void decreaseHeapSize() {
        heapSize--;
    } // decreaseHeapSize

    /**
     * Sets the heapSize to be the current size of the array. Should only be used if the array is initially empty, and
     * the add() method is used on the array list rather than the insertNode() method, to fix the heapSize of the array.
     * @param arrayListSize
     */
    public void setHeapSize(int arrayListSize) {
        heapSize = arrayListSize;
    } // setHeapSize

    /**
     * Prints the heap.
     * @param arrayList the current array
     */
    public void printHeap(ArrayList<Integer> arrayList) {
        System.out.println(arrayList.toString());
    } // printHeap

} // class
