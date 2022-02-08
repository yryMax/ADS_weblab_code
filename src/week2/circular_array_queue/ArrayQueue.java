package week2.circular_array_queue;
import java.io.*;
class ArrayQueue {

    private int[] arr;

    private int head;
    private int tail;
    private int size;

    /**
     * Creates a new ArrayQueue with the given capacity.
     *
     * @param capacity the capacity for this queue
     */
    public ArrayQueue(int capacity) {
        // TODO
        head = 0;
        size = 0;
        tail = 0;
        arr = new int[capacity];
    }

    /**
     * Adds the given element to the queue.
     *
     * @param e the element to add to the queue
     * @throws FullQueueException if the queue is full
     */
    public void enqueue(int e) throws FullQueueException {
        // TODO
        if(size == arr.length)throw new FullQueueException();
        arr[tail] = e;
        size++;
        tail = (tail+1)%arr.length;
    }

    /**
     * Removes an element from the queue and returns it.
     *
     * @return the first element in the queue
     * @throws EmptyQueueException if the queue is empty
     */
    public int dequeue() throws EmptyQueueException {
        // TODO
        if(size == 0)throw new EmptyQueueException();
        int ans = arr[head];
        head = (head + 1)%arr.length;
        size--;
        return ans;
    }
}


class EmptyQueueException extends RuntimeException {

    @Serial private static final long serialVersionUID = 42L;
}

class FullQueueException extends RuntimeException {

    @Serial private static final long serialVersionUID = 42L;
}
