package week2.Double_ended_queue;
public class Deque<T>{

    /** Position-based list to keep the elements of the queue */
    private final CLList<T> list;

    /**
     * Constructs a new queue. Chooses a circular linked list as an implementation of a position-based
     * list.
     */
    public Deque() {
        this.list = new CLList<>();
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue.
     */
    public int size() {
        // TODO
        return list.size();
    }

    /**
     * Return whether the queue is empty.
     *
     * @return true if the queue contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        // TODO
        return list.isEmpty();
    }

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws EmptyDequeException iff the queue is empty
     */
    public T getFirst() throws EmptyDequeException {
        // TODO
        if(list.getFirst() == null)throw new EmptyDequeException();
        return list.getFirst().getElement();
    }

    /**
     * Returns the element at the end of the queue without removing it.
     *
     * @return the element at the end of the queue
     * @throws EmptyDequeException iff the queue is empty
     */
    public T getLast() throws EmptyDequeException {
        // TODO
        if(list.getLast() == null)throw new EmptyDequeException();
        return list.getLast().getElement();
    }

    /**
     * Adds an element to the front of the queue.
     *
     * @param element to add.
     */
    public void addFirst(T element) {
        // TODO
        list.addFirst(element);
    }

    /**
     * Adds an element to the back of the queue.
     *
     * @param element to add.
     */
    public void addLast(T element) {
        // TODO
        list.addLast(element);
    }

    /**
     * Removes and return the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws EmptyDequeException iff the queue is empty
     */
    public T removeFirst() throws EmptyDequeException {
        // TODO
        if(list.getFirst() == null)throw new EmptyDequeException();
        return list.remove(list.getFirst());
    }

    /**
     * Removes and return the element at the end of the queue.
     *
     * @return the element at the end of the queue
     * @throws EmptyDequeException iff the queue is empty
     */
    public T removeLast() throws EmptyDequeException {
        // TODO
        if(list.getLast() == null)throw new EmptyDequeException();
        return list.remove(list.getLast());
    }
}
class EmptyDequeException extends Exception {

    static final long serialVersionUID = 42L;

    public EmptyDequeException() {
        super("Deque is empty");
    }

    public EmptyDequeException(String msg) {
        super(msg);
    }
}

/**
 * Implementation of the node interface that can be used in a circular list.
 *
 * @param <T> Type of element the list holds
 */
class CNode<T> {

    private T element;

    private CNode<T> next;

    /**
     * Constructor.
     *
     * @param el Element to hold
     * @param nx Next node (next == this iff nx == null)
     */
    public CNode(T el, CNode<T> nx) {
        setElement(el);
        setNext(nx);
        if (nx == null) {
            this.next = this;
        }
    }

    public void setElement(T el) {
        element = el;
    }

    public void setNext(CNode<T> nx) {
        next = nx;
    }

    public T getElement() {
        return element;
    }

    public CNode<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "<CNode(" + element + ")>";
    }
}

class CLList<T> {

    private CNode<T> cursor;

    private int size;

    public CLList() {
        cursor = null;
        size = 0;
    }

    /**
     * Returns the number of nodes/elements in the list.
     *
     * @return the number of nodes/elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns whether the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the first node in the list.
     *
     * @return the first node in the list or null if no such node exists.
     */
    public CNode<T> getFirst() {
        return cursor;
    }

    /**
     * Returns the last node in the list.
     *
     * @return the last node in the list or null if no such node exists.
     */
    public CNode<T> getLast() {
        CNode<T> first = getFirst();
        if (first == null) {
            return null;
        }
        CNode<T> finger = first;
        while (finger.getNext() != first) {
            finger = finger.getNext();
        }
        return finger;
    }

    /**
     * Finds the next element in the list given a node.
     *
     * @param c node to find the next element of.
     * @return the next element of p.
     */
    public CNode<T> getNext(CNode<T> c) {
        return c.getNext();
    }

    /**
     * Finds the previous element in the list given a node.
     *
     * @param c node to find the previous element of.
     * @return the previous element of p.
     */
    public CNode<T> getPrev(CNode<T> c) {
        CNode<T> finger = getFirst();
        if (finger == null) {
            return null;
        }
        int cnt = 0;
        while (finger.getNext() != c && cnt++ < size) {
            finger = finger.getNext();
        }
        return finger;
    }

    /**
     * Adds an element to the front of the list.
     *
     * @param o element to add.
     */
    public void addFirst(T o) {
        CNode<T> newNode = new CNode<>(o, null);
        if (this.cursor == null) {
            newNode.setNext(newNode);
        } else {
            newNode.setNext(cursor);
            CNode<T> last = getLast();
            last.setNext(newNode);
        }
        cursor = newNode;
        size++;
    }

    /**
     * Adds an element to th end of the list.
     *
     * @param o element to add.
     */
    public void addLast(T o) {
        CNode<T> last = getLast();
        if (last == null) {
            addFirst(o);
        } else {
            CNode<T> newNode = new CNode<>(o, getFirst());
            last.setNext(newNode);
            size++;
        }
    }

    /**
     * Adds an element after a specified node.
     *
     * @param c node to place element after.
     * @param o element to insert.
     */
    public void addAfter(CNode<T> c, T o) {
        CNode<T> newNode = new CNode<>(o, c.getNext());
        c.setNext(newNode);
        size++;
    }

    /**
     * Adds an element before a specified node.
     *
     * @param c CNode that the element should be placed in front of.
     * @param o element to insert.
     */
    public void addBefore(CNode<T> c, T o) {
        CNode<T> finger = c;
        CNode<T> newNode = new CNode<>(o, finger);
        while (finger.getNext() != c) {
            finger = finger.getNext();
        }
        finger.setNext(newNode);
        size++;
    }

    /**
     * Removes a node from the list.
     *
     * @param c CNode to remove.
     * @return the element of c.
     */
    public T remove(CNode<T> c) {
        CNode<T> prev = getPrev(c);
        CNode<T> next = getNext(c);
        if (c == cursor) {
            cursor = next;
        }
        prev.setNext(next);
        c.setNext(null);
        size--;
        return c.getElement();
    }

    /**
     * Changes the value of the given node to the given element.
     *
     * @param c node to change the value of.
     * @param o the new element for c.
     * @return the old element of c.
     */
    public T set(CNode<T> c, T o) {
        T prev = c.getElement();
        c.setElement(o);
        return prev;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<CLList[");
        CNode<T> first = getFirst();
        CNode<T> finger = first;
        if (finger != null) {
            sb.append(finger);
            if (finger.getNext() != first) {
                sb.append(",");
            }
            finger = finger.getNext();
            while (finger != first) {
                sb.append(finger.toString());
                if (finger.getNext() != first) {
                    sb.append(",");
                }
                finger = finger.getNext();
            }
        }
        sb.append("]>");
        return sb.toString();
    }
}