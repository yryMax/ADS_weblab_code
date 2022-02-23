package Endterm.Assignment_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void example() {
        int[] input = {4, 2, 5, 1, 3};
        int[] sorted = Solution.mergeSortBottomUp(input);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, sorted);
    }

    @Test
    public void testEmpty() {
        int[] arr = new int[0];
        int[] result = arr.clone();
        int[] sorted = Solution.mergeSortBottomUp(arr);
        assertArrayEquals(result, sorted);
    }

    @Test
    public void exampleMergeStep() {
        // merge([4, 2, 5, 1, 3], [0, 0, 0, 0, 0], 0, 1) -> Updated Out: [2, 4, 0, 0, 0]
        int[] out = new int[] {0, 0, 0, 0, 0};
        Solution.merge(new int[] {4, 2, 5, 1, 3}, out, 0, 1);
        assertArrayEquals(new int[] {2, 4, 0, 0, 0}, out);
        // merge([4, 2, 5, 1, 3], [2, 4, 0, 0, 0], 2, 1) -> Updated Out: [2, 4, 1, 5, 0]
        Solution.merge(new int[] {4, 2, 5, 1, 3}, out, 2, 1);
        assertArrayEquals(new int[] {2, 4, 1, 5, 0}, out);
        // merge([4, 2, 5, 1, 3], [2, 4, 1, 5, 0], 4, 1) -> Updated Out: [2, 4, 1, 5, 3]
        Solution.merge(new int[] {4, 2, 5, 1, 3}, out, 4, 1);
        assertArrayEquals(new int[] {2, 4, 1, 5, 3}, out);
        // merge([2, 4, 1, 5, 3], [2, 4, 1, 5, 3], 0, 2) -> Updated Out: [1, 2, 4, 5, 3]
        Solution.merge(new int[] {2, 4, 1, 5, 3}, out, 0, 2);
        assertArrayEquals(new int[] {1, 2, 4, 5, 3}, out);
        // merge([2, 4, 1, 5, 3], [1, 2, 4, 5, 3], 4, 2) -> Updated Out: [1, 2, 4, 5, 3]
        Solution.merge(new int[] {2, 4, 1, 5, 3}, out, 4, 2);
        assertArrayEquals(new int[] {1, 2, 4, 5, 3}, out);
        // merge([1, 2, 4, 5, 3], [1, 2, 4, 5, 3], 0, 4) -> Updated Out: [1, 2, 3, 4, 5]
        Solution.merge(new int[] {1, 2, 4, 5, 3}, out, 0, 4);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, out);
    }
}