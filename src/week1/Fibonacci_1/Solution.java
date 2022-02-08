package week1.Fibonacci_1;

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
        if(n == 1 || n == 2)return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
