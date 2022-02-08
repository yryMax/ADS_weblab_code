package week6.Bucket_sort;

import java.util.*;

class Solution {

    @SuppressWarnings("unchecked")
    public static Queue<Integer>[] fillBuckets(int[] array) {
        // TODO
        if(array == null)return null;
        if(array.length == 0)return new Queue[0];
        int vmin = Integer.MAX_VALUE;
        // TODO
        int vmax = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(array[i]<vmin)vmin = array[i];
            if(array[i]>vmax)vmax = array[i];
        }
        Queue<Integer>[] buckets = new Queue[vmax - vmin + 1];
        for(int i=0;i<vmax-vmin+1;i++){
            buckets[i] = new LinkedList();
        }
        // TODO
        for(int i=0;i<array.length;i++){
            buckets[array[i]-vmin].add(array[i]);
        }
        return buckets;
    }

    public static int[] readBuckets(Queue<Integer>[] buckets) {
        // TODO
        if(buckets == null)return null;
        int size = 0;
        for(int i=0;i<buckets.length;i++){
            size += buckets[i].size();
        }
        int[] ans = new int[size];
        int idx = 0;
        for(int i=0;i<buckets.length;i++){
            while(!buckets[i].isEmpty())ans[idx++] = buckets[i].remove();
        }
        return ans;
    }
}