package Endterm.Assignment_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionHashTableTest {
    public void assertDefunct(SolutionHashTable table, int index) {
        Entry e = table.table[index];
        assertNotNull(e);
        assertNull(e.getKey());
        assertNull(e.getValue());
    }

    @Test
    public void testExample() {
        SolutionHashTable tab = new SolutionHashTable(1);
        assertTrue(tab.put(new String("apple"), new String("juice")));
        assertEquals(new String("juice"), tab.get(new String("apple")));
        assertTrue(tab.remove(new String("apple")));
        assertDefunct(tab, 0);
        assertNull(tab.get(new String("apple")));
    }

    @Test
    public void testNullRemove() {
        SolutionHashTable tab = new SolutionHashTable(1);
        tab.table[0] = new Entry(null, new String("something"));
        assertFalse(tab.remove(null));
    }
}