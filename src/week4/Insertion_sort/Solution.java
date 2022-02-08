package week4.Insertion_sort;

class Solution {

    /**
     * @param a
     *     - array of integers to be sorted.
     */
    public static void insertionSort(int[] a) {
        // TODO
        for(int i=1;i<a.length;i++){
            for(int j=0;j<i;j++){
                if(a[i] < a[j]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
}