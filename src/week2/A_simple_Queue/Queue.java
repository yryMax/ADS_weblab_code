package week2.A_simple_Queue;
import java.util.LinkedList;
import java.io.*;
class EmptyQueueException extends RuntimeException {

    @Serial private static final long serialVersionUID = 42L;
}
public class Queue<T>{
    private LinkedList<T> list;

    public Queue() {
        // TODO
        list = new LinkedList();
    }

    /**
     * Returns whether the queue is empty.
     *
     * @return true if the queue contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        // TODO
        return list.isEmpty();
    }

    /**
     * Adds an element to the front of the queue.
     *
     * @param element to add.
     */
    public void enqueue(T element) {
        // TODO
        list.addFirst(element);
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the dequeue
     * @throws EmptyQueueException iff the queue is empty
     */
    public T dequeue() throws EmptyQueueException {
        if(isEmpty())throw new EmptyQueueException();
        return list.removeLast();
    }
}
