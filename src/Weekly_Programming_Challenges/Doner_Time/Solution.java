package Weekly_Programming_Challenges.Doner_Time;

import java.io.*;
import java.util.*;

class Solution {

    public static void run(InputStream in, PrintStream out) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        new Solution().solve(sc, out);
        sc.close();
    }
    public int[] nxt;
    public int[] head;
    public int[] v;
    public int[] cost;
    public int amount;
    public void add(int a,int b,int c){
        nxt[amount] = head[a];
        v[amount] = b;
        cost[amount] = c;
        head[a] = amount++;
    }
    public void solve(Scanner sc, PrintStream out) {
        // TODO
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        nxt = new int[2*m];
        head = new int[2*n];
        v = new int[2*m];
        amount = 0;
        cost = new int[2*m];
        boolean[] vis = new boolean[2*n];
        int[] dist = new int[2*n];
        for(int i=1;i<=n;i++){
            head[i] = -1;
            dist[i] = 2000000000;
            vis[i] = false;
        }
        while(m-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a,b,c);
            add(b,a,c);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        dist[1] = 0;
        while(!q.isEmpty()){
            int u = q.remove();
            vis[u] = false;
            for(int j=head[u];j!=-1;j=nxt[j]){
                int vv = v[j];
                if(dist[vv]>dist[u]+cost[j]){
                    dist[vv] = dist[u] + cost[j];
                    if(!vis[vv]){
                        vis[vv] = true;
                        q.add(vv);
                    }
                }
            }
        }
        m = sc.nextInt();
        int ans=-1;
        while(m-->0){
            int d = sc.nextInt();
            if(ans == -1)ans = d;
            else if(dist[d]<dist[ans])ans = d;
            else if (dist[d]==dist[ans]&&d<ans)ans = d;
        }
        out.println(ans+" "+dist[ans]);
    }
}
