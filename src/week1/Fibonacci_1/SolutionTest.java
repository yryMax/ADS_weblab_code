package week1.Fibonacci_1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void testExample() {
        assertEquals(5, Solution.fibonacci(5));
    }

    @Test
    public void baseZero() {
        assertEquals(0, Solution.fibonacci(0));
    }

    @Test
    public void baseOne() {
        assertEquals(1, Solution.fibonacci(1));
    }

    @Test
    public void small() {
        assertEquals(13, Solution.fibonacci(7));
    }

    @Test
    public void medium() {
        assertEquals(55, Solution.fibonacci(10));
    }

    @Test
    public void large2() {
        assertEquals(267914296, Solution.fibonacci(42));
    }

    @Test
    public void time() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 41, 42, 43, 44));
        for (int n : numbers) {
            runFibWithTime(n);
        }
    }

    public int runFibWithTime(int n) {
        long start = System.currentTimeMillis();
        int res = Solution.fibonacci(n);
        long end = System.currentTimeMillis();
        System.out.printf("Elapsed time for %d: %d ms%n", n, end - start);
        return res;
    }
}