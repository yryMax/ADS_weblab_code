package week2.Double_ended_queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {
    @Test
    public void testConstructor() {
        Deque<Integer> deq = new Deque<>();
        assertEquals(0, deq.size());
        assertTrue(deq.isEmpty());
    }

    @Test
    public void testAddFirstNoLongerEmpty() {
        Deque<Integer> deq = new Deque<>();
        deq.addFirst(42);
        assertEquals(1, deq.size());
        assertFalse(deq.isEmpty());
    }

    @Test
    public void testAddLastNoLongerEmpty() {
        Deque<Integer> deq = new Deque<>();
        deq.addFirst(42);
        assertEquals(1, deq.size());
        assertFalse(deq.isEmpty());
    }

    @Test
    public void testAddGetFirst() throws EmptyDequeException {
        Deque<Integer> deq = new Deque<>();
        deq.addFirst(42);
        assertEquals(Integer.valueOf(42), deq.getFirst());
    }

    @Test
    public void testAddGetLast() throws EmptyDequeException {
        Deque<Integer> deq = new Deque<>();
        deq.addLast(42);
        assertEquals(Integer.valueOf(42), deq.getFirst());
    }

    @Test
    public void testGetFirstEmptyList() {
        Deque<Integer> deq = new Deque<>();
        assertThrows(EmptyDequeException.class, deq::getFirst);
    }

    @Test
    public void testGetLastEmptyList() {
        Deque<Integer> deq = new Deque<>();
        assertThrows(EmptyDequeException.class, deq::getLast);
    }

    @Test
    public void testAddFirstEqualsLast() throws EmptyDequeException {
        Deque<Integer> deq = new Deque<>();
        deq.addFirst(42);
        assertSame(deq.getFirst(), deq.getLast());
    }

    @Test
    public void testAddLastEqualsFirst() throws EmptyDequeException {
        Deque<Integer> deq = new Deque<>();
        deq.addLast(42);
        assertSame(deq.getLast(), deq.getFirst());
    }

    @Test
    public void testRemoveFirst() throws EmptyDequeException {
        Deque<Integer> deq = new Deque<>();
        deq.addFirst(42);
        assertEquals(Integer.valueOf(42), deq.removeFirst());
        assertTrue(deq.isEmpty());
    }

    @Test
    public void testRemoveLast() throws EmptyDequeException {
        Deque<Integer> deq = new Deque<>();
        deq.addFirst(42);
        assertEquals(Integer.valueOf(42), deq.removeLast());
        assertTrue(deq.isEmpty());
    }

    @Test
    public void testRemoveFirstAddLast() throws EmptyDequeException {
        Deque<Integer> deq = new Deque<>();
        deq.addLast(42);
        assertEquals(Integer.valueOf(42), deq.removeFirst());
        assertTrue(deq.isEmpty());
    }

    @Test
    public void testRemoveFirstEmptyList() {
        Deque<Integer> deq = new Deque<>();
        assertThrows(EmptyDequeException.class, deq::removeFirst);
    }

    @Test
    public void testRemoveLastEmptyList() {
        Deque<Integer> deq = new Deque<>();
        assertThrows(EmptyDequeException.class, deq::removeLast);
    }
}