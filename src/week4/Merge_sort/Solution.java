package week4.Merge_sort;
class Solution {

    /**
     * @param a
     *     Array of integers to be sorted.
     * @return
     *     New array of sorted integers.
     */
    public static int[] mergeSort(int[] a) {
        // TODO
        for(int i=1;i<=a.length;i*=2){
            for(int j=0;j<a.length;j+=2*i){
                merge(a,j,i);//左闭右开
            }
        }
        return a;
    }
    public static void merge(int[] a, int start, int len){
        if(start+len>=a.length)return;
        int end1 = start+len;
        int end2 = Math.min(start+len*2,a.length);
        int[] tmp = new int[end2 - start];
        int k = 0;
        int i = start;
        int j = end1;
        //  System.out.println(l + "," + mid + "," + r);
        while(k<end2 - start){
            if(i == end1)tmp[k++] = a[j++];
            else if(j == end2)tmp[k++] = a[i++];
            else if(a[i]<a[j])tmp[k++] = a[i++];
            else tmp[k++] = a[j++];
        }
        for(i=start;i<end2;i++){
            a[i] = tmp[i-start];
        }
        System.out.println();
    }
}