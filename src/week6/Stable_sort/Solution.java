package week6.Stable_sort;
class Solution {
    public static boolean cmp(String a,String b){
        for(int i=0;i<Math.min(a.length(),b.length());i++){
            if(a.charAt(i)>b.charAt(i))return true;
            if(a.charAt(i)<b.charAt(i))return false;
        }
        if(a.length()>b.length())return true;
        return false;
    }
    public static void stableSort(String[][] table, int column) {
        // TODO
        if(table == null || table.length == 0)return;
        int n = table.length;
        int m = table[0].length;
        int[] a = new int[n];
        for(int i=0;i<n;i++)a[i] = i;
        for(int i=1;i<n;i++){
            for(int j = i;j>0;j--){
                if(table[a[j-1]][column].compareTo(table[a[j]][column])>0){
                    int tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                }
                else break;
            }

        }
        String[][] check = new String[n][m];
        for(int i=0;i<n;i++)for(int j=0;j<m;j++)check[i][j] = table[i][j];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)table[i][j] = check[a[i]][j];
        }
    }
}


