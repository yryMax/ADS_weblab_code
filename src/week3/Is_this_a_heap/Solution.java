package week3.Is_this_a_heap;

class Solution {

    /**
     * Checks whether the given array is a max-heap.
     *
     * @param arr integer array to be checked (root at index 0)
     * @param n the size of the array to be checked
     * @return true if the array satisfied the heap property, false otherwise
     */
    public static boolean isHeap(int[] arr, int n) {
        // TODO
        if(arr == null)return false;
        for(int i=0;i<arr.length;i++){
            if(2*i+1>=arr.length)continue;
            if(2*i+2>=arr.length)continue;
            if(arr[i]<arr[2*i+1])return false;
            if(arr[i]<arr[2*i+2])return false;
        }
        return true;
    }

    /**
     * Gives the index of the parent of the node corresponding to the given index.
     *
     * @param arr array representation of a heap (you may assume it is a valid heap)
     * @param i index of node whose parent we're looking for (make no assumptions about its validity)
     * @return index of the parent of node i, or -1 if: (a) i is not a valid index, (b) i doesn't have
     *     a parent
     */
    public static int getParent(int[] arr, int i) {
        // TODO
        if(i == 0 || i>=arr.length)return -1;
        return (i-1)/2;
    }
}