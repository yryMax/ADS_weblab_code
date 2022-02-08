package week3.Snapshot_List_Iterator;

import java.util.*;

class SnapshotListIterator<V> implements Iterator<V> {

    // Modify this copied list to implement your iterator
    private List<V> copy;
    private int index;
    /**
     * Creates a copy of the argument to iterate over.
     *
     * @param input the list to iterate over
     */
    public SnapshotListIterator(List<V> input) {
        this.copy = new ArrayList<>(input);
        index = 0;
    }

    /**
     * Returns whether the iterator has another value it can return.
     *
     * @return true if there is another element to return, false otherwise
     */
    @Override
    public boolean hasNext() {
        // TODO
        return index < copy.size();
    }

    /**
     * Returns the next element in the list.
     *
     * @return the next element
     * @throws NoSuchElementException if there is no next element
     */
    @Override
    public V next() throws NoSuchElementException {
        // TODO
        if(!hasNext())throw new NoSuchElementException();
        return copy.get(index++);
    }

    /**
     * Skips over the element that would have been returned next.
     *
     * @throws NoSuchElementException if there are no elements to iterate over left
     */
    @Override
    public void remove() throws NoSuchElementException {
        // TODO
        if(!hasNext())throw new NoSuchElementException();
        next();
    }
}


