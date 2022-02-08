package week8.Cycles_in_Directed_Graphs;

import java.util.*;

class Solution {

    /**
     * Detects cycles in a connected component.
     *
     * @param s starting vertex in our connected component.
     * @param vertices the vertex that belong to our graph.
     * @return true iff there is a cycle in the connected component the source belongs to.
     */
    public static List colored;
    public static boolean dfs(Vertex s, Vertex u){
        boolean ans = false;
        for(Vertex v:u.getOutgoingEdges()){
            //         System.out.println(v);
            if(!colored.contains(v)){
                colored.add(v);
                ans = ans | dfs(s,v);
                colored.remove(v);
            }
            else {
                ans = true;
                break;
            }
        }
        return ans;
    }
    public static boolean detectCycle(Vertex s, List<Vertex> vertices) {
        // TODO
        colored = new ArrayList();
        colored.add(s);
        return dfs(s,s);
    }
}

class Vertex {

    List<Vertex> outgoingEdges;

    int id;

    public Vertex(int id) {
        this.outgoingEdges = new ArrayList<>();
        this.id = id;
    }

    public List<Vertex> getOutgoingEdges() {
        return outgoingEdges;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return Integer.toString(id);
    }

    @Override
    public int hashCode() {
        return id;
    }
}
