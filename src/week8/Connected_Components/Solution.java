package week8.Connected_Components;

import java.util.*;

class Solution {

    public static int numberOfConnectedComponents(Graph g) {
        // TODO
        int ans = 0;
        Collection<Vertex>unexplored = g.getAllVertices();
        for(Vertex x: g.getAllVertices()){
            if(!unexplored.contains(x))continue;
            else {
                ans++;
                Iterator<Vertex>i = new GraphIterator(g, x);
                while(i.hasNext()){
                    Vertex u = i.next();
                    if(unexplored.contains(u))unexplored.remove(u);
                }
            }
        }
        return ans;
    }
}