package week1.Fibonacci_2;

public class Solution {
    /**
     * Computes the nth number in the Fibonacci sequence.
     *
     * @param n - the index of the number in the Fibonacci sequence.
     * @return nth number in the Fibonacci sequence
     */
    public static int fibonacci(int n) {
        // TODO
        if(n == 0)return 0;
        return fibonacci_helper(n,1,1);
    }

    /**
     * Helper function for computing the nth number in the Fibonacci sequence.
     *
     * @param n - the index of the number in the Fibonacci sequence.
     * @param acc1 - accumulator for the previous number in the Fibonacci sequence.
     * @param acc2 - accumulator for the number before the previous one in the Fibonacci sequence.
     * @return
     */
    public static int fibonacci_helper(int n, int acc1, int acc2) {
        // TODO

        if(n == 1| n==2)return acc1;
        return fibonacci_helper(n-1,acc1 + acc2,acc1);

    }
}
