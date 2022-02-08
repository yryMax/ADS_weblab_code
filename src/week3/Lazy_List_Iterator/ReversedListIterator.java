package week3.Lazy_List_Iterator;

import java.util.*;

/**
 * Iterates lazily over lists in reversed order. For instance, the list [1,2,3,4] should be iterated
 * as follows: 4 -> 3 -> 2 -> 1.
 */
class ReversedListIterator<V> implements Iterator<V> {

    List<V> list;
    Integer index;

    /**
     * Constructor. Should reset on a new List.
     *
     * @param list takes the list
     */
    public ReversedListIterator(List<V> list) {
        // TODO
        index = list.size();
        this.list = list;
    }

    /**
     * Indicates whether there is an element to return left.
     *
     * @return True if there is a next element in the iterator, else False
     */
    @Override
    public boolean hasNext() {
        // TODO
        return index > 0;
    }

    /**
     * Get the next element of the iterator and shift iterator by one.
     *
     * @return current element value
     * @post iterator is moved to next element
     * @throws NoSuchElementException iff there is no next element
     */
    @Override
    public V next() throws NoSuchElementException {
        // TODO
        if(!hasNext())throw new NoSuchElementException();
        return list.get(--index);
    }

    /**
     * Skip a single element of the iterator.
     *
     * @post iterator is moved to next element
     * @throws NoSuchElementException iff there is no elemented to be removed
     */
    @Override
    public void remove() throws NoSuchElementException {
        // TODO
        if(!hasNext())throw new NoSuchElementException();
        next();
    }
}

