package Weekly_Programming_Challenges.Gardening;

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
        boolean[][] vis = new boolean[1001][1001];
        while(n-- > 0)vis[sc.nextInt()][sc.nextInt()] = true;
        for(int j=0;j <=1000; j++){ //for every column
            boolean check = false;
            for(int i=0; i<= 1000;i++){ //for every row
                if(vis[i][j])check = !check;
                vis[i][j] = check;
            }
        }
        int ans = 0;
        for(int i=0;i<=1000;i++){
            boolean check = false;
            for(int j=0;j<=1000;j++){
                if(vis[i][j])check = !check;
                if(check == true)ans++;
            }
        }
        out.println(ans);
    }
}

