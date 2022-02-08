package Weekly_Programming_Challenges.BINGO;

import java.io.*;
import java.util.*;

class Solution {

    public static void run(InputStream in, PrintStream out) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        new Solution().solve(sc, out);
        sc.close();
    }
    class Pair{
        public int r;
        public int c;
        public Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    public void solve(Scanner sc, PrintStream out) {
        // TODO
        int n,m,d1=0,d2=0;
        n = sc.nextInt();
        m = sc.nextInt();
        String event;
        int[] col = new int[n];
        int[] row = new int[n];
        col[n/2]++;
        row[n/2]++;
        d1++;
        d2++;
        Hashtable<String,Pair> table = new Hashtable<String,Pair>();
        for(int i=0;i<n;i++){
            col[i] = 0;
            row[i] = 0;
            for(int j=0;j<n;j++){
                event = sc.next();
                table.put(event,new Pair(i,j));
            }
        }
        boolean flag = false;
        for(int i=1;i<=m;i++){
            event = sc.next();
            if(!table.containsKey(event))continue;
            Pair val = table.get(event);
            if(val.c == n/2 && val.r == n/2)continue;
            col[val.c]++;
            row[val.r]++;
            if(val.c == val.r)d1++;
            if(val.c + val.r == n-1)d2++;
            if(d1==n||d2==n||col[val.c]==n||row[val.r]==n){
                out.println(i);
                flag = true;
                break;
            }
        }
        if(n == 1)out.println("0");
        else if(!flag)out.println(":-(");
    }

}

