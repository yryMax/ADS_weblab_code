package Midterm.Assignment_2;
import java.util.*;
class MaxHeap extends AbstractMaxHeap {

    /**
     * Creates a new MaxHeap with an initial capacity of 4 elements.
     */
    public MaxHeap() {
        // TODO
        size = 0;
        arr = new int[4];
    }

    /**
     * Inserts the specified element into this heap.
     * If the heap is at full capacity, the capacity is doubled.
     *
     * @param elem The element to add.
     */
    public void add(int elem) {
        // TODO
        if( arr.length == size){
            int[] tmp = new int[size*2];
            for(int i=0;i<size;i++)tmp[i] = arr[i];
            arr = tmp;
        }
        arr[size++] = elem;
        upHeap(size-1);
    }

    /**
     * Restores the heap property in a heap represented as an array
     * by performing downheap on a certain item.
     * This method takes O(log n) time.
     * Ties may be broken arbitrarily.
     *
     * @param index Index of the item to perform downheap on.
     *              You can assume the index given is always valid.
     */
    void downHeap(int index) {
        // TODO
        while(index<size){

            int p = index;
            if(index*2+1<size && arr[p]<arr[index*2+1])p=index*2+1;
            if(index*2+2<size && arr[p]<arr[index*2+2])p=index*2+2;
            if(index == p)break;
            swap(index,p);
            index = p;
        }
    }

    /**
     * Merge another heap into this heap (add its elements to ours).
     * The new capacity of the current heap increases by the capacity of the other heap.
     * The other heap remains intact, i.e. its elements stay the same. // other onchange
     * If the other heap is null, the method throws an IllegalArgumentException.
     *
     * The other heap will always be an instance of MaxHeap.
     *
     * Merging two heaps should take linear time in terms of the number of elements in both heaps combined, i.e.
     * it takes O(n + m) time for n = number of elements in current heap, m = number of elements in other heap.
     *
     * @param other Heap to merge into the current one.
     * @throws IllegalArgumentException if the other heap is null.
     */
    public void mergeWith(AbstractMaxHeap other) throws IllegalArgumentException {
        // TODO
        if(other == null)throw new IllegalArgumentException();
        int[] tmp = new int[arr.length + other.arr.length];
        for(int i=0;i<size;i++)tmp[i] = arr[i];
        for(int i=0;i<other.size();i++)tmp[size+i] = other.arr[i];
        arr = tmp;
        size += other.size();
        heapify();
    }
}
class NoSuchElementException extends Exception {

    private static final long serialVersionUID = -8010862139713793774L;

    public NoSuchElementException(String string) {
        super(string);
    }
}
abstract class AbstractMaxHeap {

    int[] arr;

    protected int size;

    // You need to implement these three methods in your solution
    public abstract void add(int elem);

    abstract void downHeap(int index);

    public abstract void mergeWith(AbstractMaxHeap other);

    // All methods below are available to use in your solution
    /**
     * Returns the number of elements in the heap.
     *
     * @return the current number of elements in the heap
     */
    public int size() {
        return this.size;
    }

    /**
     * Retrieves and removes the first element of this heap.
     *
     * @return The first element of the heap.
     */
    public int poll() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Cannot poll empty heap!");
        }
        int res = arr[0];
        swap(0, --size);
        arr[size] = 0;
        downHeap(0);
        return res;
    }

    @Override
    public String toString() {
        return "MaxHeap{" + "heap=" + Arrays.toString(arr) + '}';
    }

    /**
     * Turns the array of integers into a heap.
     * This is an in-place algorithm, the heap is built in the array itself.
     *
     * On return, this heap's array represents a valid heap.
     */
    protected void heapify() {
        int n = this.arr.length - 1;
        for (int i = (n - 1) / 2; i >= 0; i--) downHeap(i);
    }

    /**
     * Restores the heap property in a heap represented as an array
     * by performing upheap on a certain item.
     *
     * @param index Index of the node to perform upheap on.
     */
    protected void upHeap(int index) {
        while (index >= 1) {
            int j = (index - 1) / 2;
            if (arr[j] >= arr[index]) break;
            swap(j, index);
            index = j;
        }
    }

    /**
     * Swaps two elements in the array.
     *
     * @param i Position of element to swap.
     * @param j Position of element to swap.
     */
    protected void swap(int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
