package Weekly_Programming_Challenges.Efficient_Printing;

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
        PrintWriter writer =  new PrintWriter(out);
        long n = sc.nextLong();

        long ans = 0;
        long tmp = 5;
        while(tmp <= n){
            ans += n/tmp;
            //   System.out.println(ans);
            tmp *=5;
        }
        writer.print(ans);
        writer.flush();
    }
}