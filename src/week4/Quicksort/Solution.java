package week4.Quicksort;

class Solution {

    /**
     * @param elements
     *     Array of integers to be sorted.
     */
    public static void quickSort(int[] a) {
        // TODO
        if(a!=null)sort(a,0,a.length-1);
    }
    public static void swap(int[] a,int l,int r){
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }
    public static void sort(int[] a,int l,int r){
        if(r<=l)return;
        int pivot = a[r];
        int ll = l;
        int rr = r-1;
        while(ll<=rr){
            while(ll<=rr&&a[ll]<=pivot)ll++;
            while(ll<=rr&&a[rr]>=pivot)rr--;
            if(ll<=rr){
                swap(a,ll,rr);
                ll++;
                rr--;
            }
        }
        swap(a,ll,r);
        sort(a,l,ll-1);
        sort(a,ll+1,r);
    }
}

