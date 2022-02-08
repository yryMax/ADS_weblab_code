package Weekly_Programming_Challenges.Forest_Run;

import java.io.*;
import java.util.*;

class Solution {

    public static void run(InputStream in, PrintStream out) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        new Solution().solve(sc, out);
        sc.close();
    }
    public long ans;
    public int[] nxt;
    public int[] head;
    public int[] v;
    public boolean[] vis;
    public void dfs(int cur){
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(cur);
        vis[cur] = true;
        while(!stk.isEmpty()){
            int c = stk.peek();
            //    System.out.println(c);
            if(head[c] == -1){
                stk.pop();
                ans += (long)(stk.size()*2);
                continue;
            }
            boolean flag = false;
            for(int i = head[c];i!=-1;i = nxt[i]){
                int son = v[i];
                if(!vis[son]){
                    vis[son] = true;
                    flag = true;
                    stk.push(son);
                    break;
                }
            }
            if(!flag)stk.pop();
        }
    }
    public void solve(Scanner sc, PrintStream out) {
        // TODO
        int n = sc.nextInt();
        int rootn = sc.nextInt();
        int[] roots = new int[rootn];
        for(int i=0;i<rootn;i++)roots[i] = sc.nextInt();
        nxt = new int[2000000];
        head = new int[2000000];
        v = new int[2000000];
        vis = new boolean[2000000];
        int amount = 0;
        head[0] = -1;
        for(int i=1;i<=n;i++){
            head[i] = -1;
            int num = sc.nextInt();
            for(int j=0;j<num;j++){
                int vv = sc.nextInt();
                nxt[amount] = head[i];
                v[amount] = vv;
                head[i] = amount++;
            }
        }
        ans = 0;
        for(int i=0;i<rootn;i++)dfs(roots[i]);
        out.println(ans);
    }
}


