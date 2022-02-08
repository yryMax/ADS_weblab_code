package week1.Merge_two_sorted_arrays;
import java.util.*;
public class Solution {
    /**
     * Merges two sorted arrays such that the resulting array has all elements from both arrays and is
     * also sorted. Assumes that the elements in the given arrays are sorted in non-decreasing order.
     * If there are duplicate elements in the input arrays, these should also be present in the
     * resulting array. If both arrays are null the result should be null, or a copy of the non-null
     * array if only one is null.
     *
     * <p>Efficiency requirements: merge the two arrays in a single pass.
     *
     * @param arr1 first sorted array to be merged
     * @param arr2 second sorted array to be merged
     * @return sorted array containing all elements from both arrays
     */
    public static int[] merge(int[] arr1, int[] arr2) {
        // TODO
        if(arr1 == null & arr2 ==null)return null;
        if(arr1 == null)return Arrays.copyOf(arr2,arr2.length);
        if(arr2 == null)return Arrays.copyOf(arr1,arr1.length);
        int n = arr1.length + arr2.length;
        int i=0;
        int j=0;
        int[] ans = new int[n];
        for(int k=0;k<n; k++){
            if(i == arr1.length)ans[k] = arr2[j++];
            else if(j == arr2.length)ans[k] = arr1[i++];
            else if(arr1[i] < arr2[j])ans[k] = arr1[i++];
            else ans[k] = arr2[j++];
        }
        return ans;
    }
}
