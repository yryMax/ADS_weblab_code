package Endterm.Assignment_4;

import java.util.*;

class GraphChecker {

    /**
     * Traverses the given graph depth first and returns the IDs of visited vertices in order, starting from the given vertex.
     * In case multiple choices are possible for a next vertex, they are visited in increasing order of ID.
     * Runs in O(V+E) time. Does not modify the input graph.
     * @param g Graph to traverse.
     * @param v Vertex to start the traversal from.
     * @return List of IDs of vertices found using DFS traversal.
     */
    public List<Integer> traverseDepthFirst(Graph g, Vertex v) {
        // TODO
        int n = g.getAllVertices().size();
        boolean[] vis = new boolean[n];
        List<Integer>ans = new ArrayList();
        dfs(g,v,ans,vis);
        return ans;
    }
    void dfs(Graph g,Vertex v,List<Integer>ans,boolean[] vis){
        int id = v.getId();
        vis[id] = true;
        ans.add(id);
        for(Vertex u: v.getNeighbours()){
            if(vis[u.getId()])continue;
            dfs(g,u,ans,vis);
        }

    }

    /**
     * Returns the transpose of the given graph, i.e. a graph with all edges reversed.
     * Runs in O(V+E) time. Does not modify the input graph.
     * @param g Graph to create the transpose of.
     * @return Transpose of the given graph.
     */
    public Graph transpose(Graph g) {
        // TODO
        int n = g.getAllVertices().size();
        Vertex[] vis = new Vertex[n];
        Graph newg = new Graph();
        for(Vertex v:g.getAllVertices()){
            Vertex myvertex = new Vertex(v.getId());
            newg.addVertex(myvertex);
            vis[v.getId()] = myvertex;
        }
        for(Vertex v:g.getAllVertices()){
            for(Vertex u: v.getNeighbours()){
                Vertex myv = vis[v.getId()];
                Vertex myu = vis[u.getId()];
                newg.addEdge(myu,myv);
            }
        }
        return newg;
    }

    /**
     * Returns true if the given graph is strongly connected, false otherwise.
     * Runs in O(V+E) time. Does not modify the input graph.
     * @param g Graph to check for strong connectedness.
     * @return True if the graph is strongly connected, false otherwise.
     */
    public boolean isStronglyConnected(Graph g) {
        // TODO
        int n = g.getAllVertices().size();
        if(n == 0)return true;
        Vertex v = g.getAllVertices().get(0);
        Graph newg = transpose(g);
        Vertex newv = newg.getAllVertices().get(0);
        return traverseDepthFirst(g,v).size() == n && traverseDepthFirst(newg,newv).size() == n;

    }
}
class Vertex {

    private final int id;

    private final Set<Vertex> neighbours;

    public Vertex(int id) {
        this.id = id;
        neighbours = new TreeSet<>(Comparator.comparing(Vertex::getId));
    }

    public int getId() {
        return id;
    }

    public void addNeighbour(Vertex v) {
        neighbours.add(v);
    }

    public List<Vertex> getNeighbours() {
        // Sorted in ascending order of ID
        return new ArrayList<>(this.neighbours);
    }

    @Override
    public String toString() {
        return "V" + id;
    }

    @Override
    public int hashCode() {
        return this.getId();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Vertex v && this.id == v.id && this.neighbours.equals(v.neighbours);
    }
}

class Graph {

    private final Map<Integer, Vertex> vertices = new HashMap<>();

    public void addVertex(Vertex v) {
        this.vertices.put(v.getId(), v);
    }

    public Vertex getVertex(int id) {
        return this.vertices.get(id);
    }

    public List<Vertex> getAllVertices() {
        return new ArrayList<>(this.vertices.values());
    }

    public void addEdge(Vertex v, Vertex w) {
        v.addNeighbour(w);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<Graph");
        for (Vertex v : vertices.values()) {
            sb.append(" <V").append(v.getId());
            if (v.getNeighbours().size() > 0) {
                sb.append(", neighbours:");
                for (Vertex n : v.getNeighbours()) {
                    sb.append(" ").append(n.getId());
                }
            }
            sb.append(">");
        }
        sb.append(">");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Graph g && this.vertices.equals(g.vertices);
    }
}
