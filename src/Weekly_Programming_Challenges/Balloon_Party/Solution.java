package Weekly_Programming_Challenges.Balloon_Party;

import java.io.*;
import java.util.*;
class node{
    int x;
    int y;
    int h;
    public node(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }

    public int getH() {
        return h;
    }
}
class Solution {

    public static void run(InputStream in, PrintStream out) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        new Solution().solve(sc, out);
        sc.close();
    }
    int n;
    int m;
    int[][] tent;
    int[][] toxic;
    public void solve(Scanner sc, PrintStream out) {
        // TODO
        m = sc.nextInt();
        n = sc.nextInt();
        tent = new int[n][m];
        toxic = new int[n][m];
        for(int i=0;i<n;i++)for(int j=0;j<m;j++)tent[i][j] = sc.nextInt();
        List<node>nodeList = new ArrayList<>();
        for(int i=0;i<n;i++){nodeList.add(new node(i,0,tent[i][0]));nodeList.add(new node(i,m-1,tent[i][m-1]));toxic[i][0] = tent[i][0];toxic[i][m-1] = tent[i][m-1];}
        for(int i=0;i<m;i++){nodeList.add(new node(0,i,tent[0][i]));nodeList.add(new node(n-1,i,tent[n-1][i]));toxic[0][i] = tent[0][i];toxic[n-1][i] = tent[n-1][i];}
        nodeList.sort(Comparator.comparing(node::getH).reversed());
        for(node edge: nodeList){
            Queue<node> q = new LinkedList<>();
            q.add(edge);
            while(!q.isEmpty()){
                node cur = q.poll();
                if(cur.x>1 && toxic[cur.x-1][cur.y]!=tent[cur.x-1][cur.y] && toxic[cur.x][cur.y]>toxic[cur.x-1][cur.y]){
                    toxic[cur.x-1][cur.y] = Math.min(toxic[cur.x][cur.y],tent[cur.x-1][cur.y]);
                    q.add(new node(cur.x-1,cur.y,0));
                }
                if(cur.x<n-2 && toxic[cur.x+1][cur.y]!=tent[cur.x+1][cur.y] && toxic[cur.x][cur.y]>toxic[cur.x+1][cur.y]){
                    toxic[cur.x+1][cur.y] = Math.min(toxic[cur.x][cur.y],tent[cur.x+1][cur.y]);
                    q.add(new node(cur.x+1,cur.y,0));
                }
                if(cur.y>1 && toxic[cur.x][cur.y-1]!=tent[cur.x][cur.y-1] && toxic[cur.x][cur.y]>toxic[cur.x][cur.y-1]){
                    toxic[cur.x][cur.y-1] = Math.min(toxic[cur.x][cur.y],tent[cur.x][cur.y-1]);
                    q.add(new node(cur.x,cur.y-1,0));
                }
                if(cur.y<m-2 && toxic[cur.x][cur.y+1]!=tent[cur.x][cur.y+1] && toxic[cur.x][cur.y]>toxic[cur.x][cur.y+1]){
                    toxic[cur.x][cur.y+1] = Math.min(toxic[cur.x][cur.y],tent[cur.x][cur.y+1]);
                    q.add(new node(cur.x,cur.y+1,0));
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++)for(int j=0;j<m;j++)ans += tent[i][j]-toxic[i][j];
        out.println(ans);
    }
}

