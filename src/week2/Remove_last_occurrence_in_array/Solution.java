package week2.Remove_last_occurrence_in_array;
import java.util.*;
public class Solution {

    /**
     * Takes the array and the last occurring element x, shifting the rest of the elements left. I.e.
     * [1, 4, 7, 9], with x=7 would result in: [1, 4, 9].
     *
     * @param x the entry to remove from the array
     * @param arr to remove an entry from
     * @return the updated array, without the last occurrence of x
     */
    public static int[] removeLastOccurrence(int x, int[] arr) {
        // TODO
        if(arr == null)return null;
        int i = arr.length - 1;
        if(i<0)return Arrays.copyOf(arr,arr.length);
        int[] ans = new int[arr.length - 1];
        while(i>=0 && arr[i]!=x)i--;
        if(i<0)return Arrays.copyOf(arr,arr.length);
        for(int j=0;j<i;j++)ans[j] = arr[j];
        for(int j=i;j<arr.length-1;j++)ans[j] = arr[j+1];
        return ans;

    }
}

