package Weekly_Programming_Challenges.Debug;

import java.io.*;
import java.util.*;

class Solution {

    public static void run(InputStream in, PrintStream out) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        new Solution().solve(sc, out);
        sc.close();
    }

    public void solve(Scanner sc, PrintStream out) {
        if (n(sc.nextInt()) == 1) out.println("yes");
        else out.println("no");
    }

    public int n(int n) {
        if (n == 1 || n == 0) return 0;
        for (int i = 2; i * i < n; i++){
            if (n % i == 0) return 0;
        }
        return 1;
    }
}

