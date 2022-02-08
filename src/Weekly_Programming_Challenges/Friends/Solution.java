package Weekly_Programming_Challenges.Friends;

import java.io.*;
import java.util.*;

class Solution {

    public static void run(InputStream in, PrintStream out) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        new Solution().solve(sc, out);
        sc.close();
    }
    public int[] fa;
    public int find(int x){
        if(fa[x] == x)return x;
        int newfa = find(fa[x]);
        fa[x] = newfa;
        return newfa;
    }
    public void solve(Scanner sc, PrintStream out) {
        // TODO
        int n,m,s;
        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.nextInt();
        fa = new int[n];
        for(int i=0;i<n;i++)fa[i] = i;
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            fa[find(a)] = find(b);
        }
        int root = find(s);
        for(int i=0;i<n;i++){
            if(find(i)!=root){
                out.println("no");
                return;
            }
        }
        out.println("yes");
    }
}

