package week1.Reverse_an_array;

public class Solution {
    /**
     * Reverses the order of the elements of the given array.
     *
     * @param arr the array to reverse
     */
    public static void reverse(int[] arr) {
        // TODO
        if(arr == null)return;
        for(int i=0;i<arr.length/2;i++){
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
    }
}
