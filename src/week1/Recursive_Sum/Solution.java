package week1.Recursive_Sum;

public class Solution {
    /**
     * Returns the sum of all elements in the array up to (and including) the `n`th element
     *
     * @param arr the array of integers that needs to be summed
     * @param n the index of the last item to consider
     */
    public static int sumElementsUpTo(int[] arr, int n) {
        // TODO
        if(n == 0)return arr[0];
        return arr[n] + sumElementsUpTo(arr,n-1);
    }
}
