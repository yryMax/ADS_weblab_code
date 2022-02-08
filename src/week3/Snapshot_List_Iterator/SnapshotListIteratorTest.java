package week3.Snapshot_List_Iterator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class SnapshotListIteratorTest {
    @Test
    void testSimpleList() {
        List<Integer> list = new ArrayList<>(List.of(1, 2));
        Iterator<Integer> it = new SnapshotListIterator<>(list);
        assertEquals(1, it.next());
        assertTrue(it.hasNext());
        assertEquals(2, it.next());
        assertFalse(it.hasNext());
    }
}