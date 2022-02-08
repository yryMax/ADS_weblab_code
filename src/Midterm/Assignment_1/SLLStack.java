package Midterm.Assignment_1;

import java.util.*;

class SLLStack<T> {

    // Do not change these two fields, they are used by tests
    Node<T> head;

    int size = 0;

    /**
     * Adds an element to the stack.
     *
     * @param e Element to add to the stack.
     */
    public void push(T e) {
        // TODO
        head = new Node(e,head);
        size++;
        //System.out.println(head.getElement());
    }

    /**
     * Returns and removes the top element from the stack.
     *
     * @return The top element from the stack.
     * @throws NoSuchElementException iff the stack is empty.
     */
    public T pop() throws NoSuchElementException {
        // TODO
        if(head == null)throw new NoSuchElementException();
        Node ans = head;
        head = head.getNext();
        size--;
        return (T)ans.getElement();
    }

    /**
     * Only returns (i.e. does not remove) the top element from the stack.
     *
     * @return The top element from the stack.
     * @throws NoSuchElementException iff the stack is empty.
     */
    public T peek() throws NoSuchElementException {
        // TODO
        if(head == null)throw new NoSuchElementException();
        return head.getElement();
    }

    /**
     * @return True iff there are no elements left.
     */
    public boolean isEmpty() {
        // TODO
        return size == 0;
    }

    /**
     * @return The number of elements in the stack.
     */
    public int size() {
        // TODO
        return size;
    }
}

class Node<T> {

    // Each Node object has these two fields
    private T element;

    private Node<T> next;

    // Constructor: Creates a Node object with element = e and next = n
    Node(T e, Node<T> n) {
        element = e;
        next = n;
    }

    // This function gets T e as input and sets e as the element of the Node
    public void setElement(T e) {
        element = e;
    }

    // This function returns the element variable of the Node
    public T getElement() {
        return element;
    }

    // This function gets Node n as input and sets the next variable of the current Node object as
    // n.
    public void setNext(Node<T> n) {
        next = n;
    }

    // This function returns the next Node
    public Node<T> getNext() {
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(element, node.element) && Objects.equals(next, node.next);
    }
}
