package week2.Array_based_stack_implementation;
class EmptyStackException extends java.util.EmptyStackException {

    static final long serialVersionUID = 1L;

    public EmptyStackException() {}
}
class ArrayStack {

    private Object[] elements;

    private int size;

    private int capacity;

    /** Creates an empty ArrayStack with capacity 1. */
    public ArrayStack() {
        // TODO
        elements = new Object[1];
        size = 0;
        capacity = 1;
    }

    /**
     * Returns the size of this ArrayStack.
     *
     * @return The size of this ArrayStack.
     */
    public int size() {
        // TODO
        return size;
    }

    /**
     * Returns whether the ArrayStack is empty.
     *
     * @return true if this ArrayStack is empty, false otherwise.
     */
    public boolean isEmpty() {
        // TODO
        return size == 0;
    }

    /**
     * Returns whether the ArrayStack is full.
     *
     * @return true if the size is equal to the capacity, false otherwise.
     */
    public boolean isFull() {
        // TODO
        return size == capacity;
    }

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the top element of the stack.
     */
    public Object peek() throws EmptyStackException {
        // TODO
        if(size == 0) throw new EmptyStackException();
        return elements[size - 1];
    }

    /**
     * Adds 'o' to the stack. If capacity of stack was too small, capacity is doubled and 'o' is
     * added.
     *
     * @param o the element to add to the stack.
     */
    public void push(Object o) {
        // TODO
        if(isFull()){
            Object[] tmp = new Object[capacity];
            tmp = elements;
            capacity *=2;
            elements = new Object[capacity];
            for(int i=0;i<size;i++)elements[i] = tmp[i];
        }
        elements[size++] = o;
    }

    /**
     * Removes the top element from the stack. If removing top would make the stack use less than 25%
     * of its capacity, then the capacity is halved.
     *
     * @return the element which was at the top of the stack.
     * @throws EmptyStackException iff the stack is empty
     */
    public Object pop() throws EmptyStackException {
        // TODO
        if(size == 0) throw new EmptyStackException();
        size--;
        Object ans = elements[size];
        if(4*size<capacity && capacity>1){
            Object[] tmp = new Object[capacity];
            tmp = elements;
            capacity /=2;
            elements = new Object[capacity];
            for(int i=0;i<size;i++)elements[i] = tmp[i];
        }
        return ans;
    }

    /**
     * @return a String representation of the ArrayStack Example output for ArrayStack with 2 elements
     *     and capacity 5: <ArrayStack[1,2]>(Size=2, Cap=5)
     */
    public String toString() {
        // TODO
        String ans = "<ArrayStack[";
        for(int i=0;i<size;i++){
            if(i>0)ans += ",";
            ans +=elements[i];
        }
        ans+="]>(Size=" + size + ", Cap=" + capacity + ")";
        return ans;
    }

    // For testing, do not remove or change.
    public Object[] getElements() {
        return elements;
    }
}