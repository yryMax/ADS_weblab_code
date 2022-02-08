package week4.Selection_sort;

class Solution {

    /**
     * @param a
     *     Array of integers to be sorted.
     */
    public static void selectionSort(int[] a) {
        // TODO
        for(int i = 0;i<a.length;i++){
            int p = i;
            for(int j=i+1;j<a.length;j++)if(a[j]<a[p])p = j;
            int tmp = a[p];
            a[p] = a[i];
            a[i] = tmp;
        }
    }
}