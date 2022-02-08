package week2.Queue_from_stacks;

import java.util.*;

class Queue<T> {

    private LibraryStack<T> s1 = new LibraryStack<>();

    private LibraryStack<T> s2 = new LibraryStack<>();

    /**
     * Returns whether the queue is empty.
     *
     * @return true if there are no elements left, false otherwise.
     */
    public boolean isEmpty() {
        // TODO
        return s1.isEmpty();
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue.
     */
    public int size() {
        // TODO
        return s1.size();
    }

    /**
     * Adds an element to the queue.
     *
     * @param i element to enqueue.
     */
    public void enqueue(T i) {
        // TODO
        s1.push(i);
    }

    /**
     * Removes the first element from the queue.
     *
     * @return the first element from the queue.
     * @throws NoSuchElementException iff the queue is empty.
     */
    public T dequeue() throws NoSuchElementException {
        // TODO
        if(isEmpty())throw new NoSuchElementException();
        while(s1.isEmpty() == false)s2.push(s1.pop());
        T ans = s2.pop();
        while(s2.isEmpty() == false)s1.push(s2.pop());
        return ans;
    }

    /**
     * Returns the first element from the queue without removing it.
     *
     * @return the first element from the queue.
     * @throws NoSuchElementException iff the queue is empty.
     */
    public T first() throws NoSuchElementException {
        // TODO
        if(isEmpty())throw new NoSuchElementException();
        while(s1.isEmpty() == false)s2.push(s1.pop());
        T ans = s2.peek();
        while(s2.isEmpty() == false)s1.push(s2.pop());
        return ans;
    }
}
/**
 * Class for a Stack.
 *
 * @param <T> Type of elements the Stack can hold
 */
class LibraryStack<T> {

    private LinkedList<T> ll;

    public LibraryStack() {
        ll = new LinkedList<>();
    }

    /**
     * Returns whether the stack is empty.
     *
     * @return true if it contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack.
     */
    public int size() {
        return ll.size();
    }

    /**
     * Add an element to the top of the stack
     *
     * @param e element to push.
     */
    public void push(T e) {
        ll.offer(e);
    }

    /**
     * Removes the top element from the stack.
     *
     * @return the first element.
     * @throws NoSuchElementException iff the stack is empty
     */
    public T pop() throws NoSuchElementException {
        return ll.removeLast();
    }

    /**
     * @return the top element (does not pop it).
     * @throws NoSuchElementException iff the stack is empty
     */
    public T peek() throws NoSuchElementException {
        if (ll.peekLast() == null) {
            throw new NoSuchElementException();
        }
        return ll.peekLast();
    }
}