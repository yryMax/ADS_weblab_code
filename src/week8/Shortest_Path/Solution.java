package week8.Shortest_Path;


import java.util.*;

class Solution {

    /**
     * Find the shortest path between v and u in the graph g.
     *
     * @param g
     *     graph to search in.
     * @param v
     *     node to start from.
     * @param u
     *     node to reach.
     * @return the nodes you that form the shortest path, including v and u. An
     * empty list iff there is no path between v and u.
     */
    public static List<Vertex> shortestPath(Graph g, Vertex v, Vertex u) {
        // TODO
        Map<Vertex, Vertex> predecessors = new TreeMap<>();
        List<Vertex>ans = new ArrayList();
        Iterator<Vertex>iterator = new GraphIterator(g, v);
        Vertex qwq = new VertexImpl(-1);
        predecessors.put(v,qwq);
        while(iterator.hasNext()){
            //    System.out.println("1");
            Vertex start = iterator.next();
            for(Vertex end: g.getNeighbours(start)){
                if(!predecessors.containsKey(end)){
                    predecessors.put(end, start);
                }
            }
        }

/*

        Queue<Vertex> q = new LinkedList();
        q.add(v);


        while(!q.isEmpty()){
            Vertex nxt = q.remove();
            Iterator<Vertex>iterator = new GraphIterator(g, nxt);
            while(iterator.hasNext()){
                Vertex nxtnxt = iterator.next();
                if(!predecessors.containsKey(nxtnxt)){
                    predecessors.put(nxtnxt, nxt);
                    if(nxtnxt == u){
                        break;
                        flag =
                    }
                    q.add(nxtnxt);
                }
            }
        }
        */
        if(!predecessors.containsKey(u)){
            return ans;
        }
        while(u!=qwq){
            ans.add(0,u);
            u = predecessors.get(u);
        }
        return ans;
    }
}

