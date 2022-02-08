package week2.Array_based_stack_implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
    @Test
    public void testConstructor() {
        ArrayStack tmp = new ArrayStack();
        assertArrayEquals(tmp.getElements(), new Object[1]);
    }

    @Test
    public void testToStringTwo() {
        ArrayStack s = new ArrayStack();
        s.push(1);
        s.push(2);
        assertEquals("<ArrayStack[1,2]>(Size=2, Cap=2)", s.toString());
    }

    @Test
    public void testGrowShrink() {
        ArrayStack s = new ArrayStack();
        s.push(1);
        s.push(2);
        assertEquals("<ArrayStack[1,2]>(Size=2, Cap=2)", s.toString());
        s.push(3);
        assertEquals(4, s.getElements().length);
        s.pop();
        s.pop();
        s.pop();
        assertEquals(2, s.getElements().length);
    }
}