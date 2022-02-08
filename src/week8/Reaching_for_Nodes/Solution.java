package week8.Reaching_for_Nodes;

import java.util.*;

class Solution {

    /**
     * Checks if vertex b is reachable from vertex a.
     *
     * @param a
     *     Vertex to start from.
     * @param b
     *     Vertex to reach.
     * @return true if vertex b is reachable.
     */
    public static boolean solve(Vertex a, Vertex b) {
        // TODO
        if(a.equals(b))return true;
        List<Vertex> vis = new ArrayList();
        Queue<Vertex> q = new LinkedList();
        q.add(a);
        vis.add(a);
        while(!q.isEmpty()){
            Vertex u = q.remove();
            for(Vertex v: u.getNeighbours()){
                if(v.equals(b))return true;
                if(!vis.contains(v)){
                    vis.add(v);
                    q.add(v);
                }
            }
        }
        return false;

    }
}

class Vertex {

    private int id;

    private Set<Vertex> neighbours;

    public Vertex(int id) {
        this.id = id;
        neighbours = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void addNeighbour(Vertex v) {
        neighbours.add(v);
    }

    @Override
    public String toString() {
        return "<vertex: " + id + ">";
    }

    public Collection<Vertex> getNeighbours() {
        return new ArrayList<>(this.neighbours);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Vertex && ((Vertex) o).getId() == this.getId();
    }
}

class Graph {

    private Map<Integer, Vertex> vertices = new HashMap<>();

    /**
     * Creates a new graph with n vertices.
     *
     * @param n
     *     Amount of vertices in the graph.
     */
    public Graph(int n) {
        for (int i = 0; i < n; i++) vertices.put(i, new Vertex(i));
    }

    /**
     * Returns the vertex with the given ID.
     *
     * @param id
     *     The ID for the vertex to get.
     * @return The vertex with the given ID.
     * @throws IllegalArgumentException
     *     if no vertex with the given ID is in the graph.
     */
    public Vertex getVertex(int id) throws IllegalArgumentException {
        if (!vertices.containsKey(id)) throw new IllegalArgumentException("Vertex not in graph");
        return vertices.get(id);
    }

    public Collection<Vertex> getAllVertices() {
        return new ArrayList<>(this.vertices.values());
    }

    /**
     * Adds an edge between vertex u and v with the given weight.
     *
     * @param u
     *     First vertex.
     * @param v
     *     Second vertex.
     */
    public void addEdge(Vertex u, Vertex v) {
        u.addNeighbour(v);
        v.addNeighbour(u);
    }

    /**
     * Adds an edge between the vertices with IDs u and v with the given weight.
     *
     * @param u
     *     ID of the first vertex.
     * @param v
     *     ID of the second vertex.
     * @throws IllegalArgumentException
     *     if no vertex with the given ID is in the graph.
     */
    public void addEdge(int u, int v) throws IllegalArgumentException {
        addEdge(getVertex(u), getVertex(v));
    }
}
