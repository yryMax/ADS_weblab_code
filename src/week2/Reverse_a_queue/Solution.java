package week2.Reverse_a_queue;
import java.util.*;

class Solution {

    /** Reverses the queue itself. NB: This method should be recursive. */
    public static void reverse(LibraryQueue queue) {
        // TODO
        if(queue.isEmpty() || queue.size() == 1)return;
        int front = queue.dequeue();
        reverse(queue);
        queue.enqueue(front);
    }
}
class LibraryQueue {

    private LinkedList<Integer> ll;

    public LibraryQueue() {
        ll = new LinkedList<>();
    }

    /**
     * Returns whether the queue is empty.
     *
     * @return true iff it contains no elements.
     */
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue.
     */
    public int size() {
        return ll.size();
    }

    /**
     * Add an element to the end of the queue
     *
     * @param e element to add.
     */
    public void enqueue(int e) {
        ll.offer(e);
    }

    /**
     * Removes the first element from the queue.
     *
     * @return the first element.
     * @throws NoSuchElementException iff the queue is empty
     */
    public int dequeue() throws NoSuchElementException {
        return ll.remove();
    }

    /**
     * Returns the first element from the queue without removing it.
     *
     * @return the first element.
     * @throws NoSuchElementException iff the queue is empty
     */
    public int front() throws NoSuchElementException {
        if (ll.peek() == null) {
            throw new NoSuchElementException();
        }
        return ll.peek();
    }
}
