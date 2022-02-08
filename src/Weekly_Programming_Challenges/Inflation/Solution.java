package Weekly_Programming_Challenges.Inflation;

import java.io.*;
import java.util.*;

class Solution {

    public static void run(InputStream in, PrintStream out) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        new Solution().solve(sc, out);
        sc.close();
    }

    public void solve(Scanner sc, PrintStream out) {
        // TODO
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)a[i] = sc.nextInt();
        Arrays.sort(a);
        boolean flag = true;
        double ans = Double.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]> i+1)flag = false;
            else ans = Math.min(ans,(double)a[i]/(i+1));
        }
        if(flag == false)out.println("impossible");
        else out.println(ans);
    }
}


