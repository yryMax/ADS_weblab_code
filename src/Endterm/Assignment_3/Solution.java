package Endterm.Assignment_3;
import java.util.*;
public class Solution {
    /**
     * Sorts and merges `in[start, ..., start + inc - 1]` and `in[start + inc, ..., start + 2*inc - 1]` into `out`.
     *
     * @param in The input array, sorted in their intervals `in[start, ..., start + inc - 1]` and `in[start + inc, ..., start + 2*inc - 1]`.
     * @param out The output array that should be updated to have `in[start, ..., start + inc - 1]` and `in[start + inc, ..., start + 2*inc - 1]`
     *            in sorted fashion at `out[start, start + 2*inc - 1]`.
     * @param start The index of the first element to be merged into out.
     * @param inc The size of each of the intervals to be merged into out.
     */
    public static void merge(int[] in, int[] out, int start, int inc) {
        // TODO
        int l = start;
        int endl = start+inc;
        int r = start+inc;
        r = Math.min(r,out.length);
        int endr = Math.min(start+inc*2,out.length);
        //System.out.println(l + " " + r + " " + endl + " " + endr);
        for(int k=start;k<Math.min(start+2*inc,out.length);k++){
            //     System.out.println(in[l] + " "+in[r] + " "+ k + " " + out[k]);
            if(l == endl)out[k] = in[r++];
            else if(r == endr)out[k] = in[l++];
            else if(in[l]<=in[r])out[k] = in[l++];
            else out[k] = in[r++];
        }
    }

    /**
     * Sorts the input array using bottom-up merge sort.
     *
     * @param array The array to be sorted.
     * @return The resulting sorted array.
     */
    public static int[] mergeSortBottomUp(int[] array) {
        // TODO
        int n = array.length;

        for(int inc = 1;inc<n;inc*=2){
            int[] copy = Arrays.copyOf(array,array.length);
            for(int start = 0;start<n;start+=2*inc){
                //       System.out.println(start + " " + inc);
                merge(copy,array,start,inc);
            }
        }
        return array;
    }
}
