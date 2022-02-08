package week8.duiyouhuaDij;

import java.util.*;

class Solution {

    /**
     * Returns the list of vertices along the shortest path between vertex a and b in graph g.
     *
     * @param g
     *     Graph to consider.
     * @param a
     *     Vertex to start from.
     * @param b
     *     Vertex to go to.
     * @return The list of vertices along the shortest path between a and b, or null if no such path exists.
     */
    public static List<Vertex> shortestPath(Graph g, Vertex a, Vertex b) {
        // TODO
        List<Vertex>ans = new ArrayList();
        if(a == b){
            ans.add(a);
            return ans;
        }
        int n = g.getAllVertices().size();
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        Map<Vertex,Vertex> last = new TreeMap();
        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
            vis[i]=false;
        }
        dist[a.getId()]=0;
        AdaptablePQ pq = new AdaptablePQ();
        for(Vertex x: g.getAllVertices()){
            int u = x.getId();
            pq.insertOrReplace(x,dist[u]);
            last.put(x,null);
        }
        while(!pq.isEmpty()){
            Vertex u = pq.removeMin().getVertex();
            int id = u.getId();
            //  vis[id] = true;
            if(dist[id] == Integer.MAX_VALUE)continue;
            for(VertexNumPair v: u.getNeighbours()){
                Vertex vv = v.getVertex();

                //      if(vis[vv.getId()])continue;
                int weight = v.getNum();
                if(dist[vv.getId()]>dist[id]+weight){
                    dist[vv.getId()]=dist[id]+weight;
                    pq.insertOrReplace(vv,dist[vv.getId()]);
                    last.put(vv,u);
                }
            }
        }
        if(dist[b.getId()] == Integer.MAX_VALUE)return null;
        Vertex cur = b;
        while(cur!=null){
            ans.add(0,cur);
            cur = last.get(cur);
        }
        return ans;

    }
}
/**
 * Container class used to store a Vertex and an int.
 */
class VertexNumPair {

    private Vertex vertex;

    private int num;

    public VertexNumPair(Vertex vertex, int num) {
        this.vertex = vertex;
        this.num = num;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public int getNum() {
        return num;
    }
}

class Vertex implements Comparable<Vertex> {

    private int id;

    private Set<VertexNumPair> neighbours;

    public Vertex(int id) {
        this.id = id;
        neighbours = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void addNeighbour(Vertex v, int weight) {
        neighbours.add(new VertexNumPair(v, weight));
    }

    @Override
    public String toString() {
        return "<vertex: " + id + ">";
    }

    public Collection<VertexNumPair> getNeighbours() {
        return new ArrayList<>(this.neighbours);
    }

    @Override
    public int compareTo(Vertex o) {
        return this.getId() - o.getId();
    }

    @Override
    public int hashCode() {
        return this.getId();
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
     * Returns all neighbours of the given vertex sorted by their ID.
     *
     * @param v
     *     The vertex to get the neighbours from.
     * @return A sorted list of all neighbouring vertices.
     */
    public List<VertexNumPair> getNeighbours(Vertex v) {
        List<VertexNumPair> neighbours = new ArrayList<>(v.getNeighbours());
        neighbours.sort(Comparator.comparingInt(a -> a.getVertex().getId()));
        return neighbours;
    }

    /**
     * Adds an edge between vertex u and v with the given weight.
     *
     * @param u
     *     First vertex.
     * @param v
     *     Second vertex.
     * @param weight
     *     Weight of the edge between a and b.
     */
    public void addEdge(Vertex u, Vertex v, int weight) {
        u.addNeighbour(v, weight);
        v.addNeighbour(u, weight);
    }

    /**
     * Adds an edge between the vertices with IDs u and v with the given weight.
     *
     * @param u
     *     ID of the first vertex.
     * @param v
     *     ID of the second vertex.
     * @param weight
     *     Weight of the edge between a and b.
     * @throws IllegalArgumentException
     *     if no vertex with the given ID is in the graph.
     */
    public void addEdge(int u, int v, int weight) throws IllegalArgumentException {
        addEdge(getVertex(u), getVertex(v), weight);
    }
}

class AdaptablePQ {

    private static class PQEntry implements Comparable<PQEntry> {

        private int key;

        private Vertex value;

        private int index;

        public PQEntry(int key, Vertex value, int index) {
            this.key = key;
            this.value = value;
            this.index = index;
        }

        protected int getKey() {
            return key;
        }

        protected void setKey(int key) {
            this.key = key;
        }

        protected Vertex getValue() {
            return value;
        }

        protected int getIndex() {
            return index;
        }

        protected void setIndex(int index) {
            this.index = index;
        }

        @Override
        public int compareTo(PQEntry o) {
            return Integer.compare(this.getKey(), o.getKey());
        }
    }

    private ArrayList<PQEntry> heap = new ArrayList<>();

    private Map<Vertex, PQEntry> entries = new HashMap<>();

    private int parent(int j) {
        return (j - 1) / 2;
    }

    private int left(int j) {
        return 2 * j + 1;
    }

    private int right(int j) {
        return 2 * j + 2;
    }

    private boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    private boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    /**
     * Exchanges the entries at indices i and j of the array list.
     *
     * @param i
     *     First index to swap.
     * @param j
     *     Second index to swap.
     */
    private void swap(int i, int j) {
        PQEntry temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
        heap.get(i).setIndex(i);
        heap.get(j).setIndex(j);
    }

    /**
     * Moves the entry at index j higher, if necessary, to restore the heap property.
     *
     * @param j
     *     Index to start from.
     */
    private void upheap(int j) {
        while (j > 0) {
            int p = parent(j);
            if (heap.get(j).compareTo(heap.get(p)) >= 0) break;
            swap(j, p);
            j = p;
        }
    }

    /**
     * Moves the entry at index j lower, if necessary, to restore the heap property.
     *
     * @param j
     *     Index to start from.
     */
    private void downheap(int j) {
        while (hasLeft(j)) {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (heap.get(leftIndex).compareTo(heap.get(rightIndex)) > 0)
                    smallChildIndex = rightIndex;
            }
            if (heap.get(smallChildIndex).compareTo(heap.get(j)) >= 0) break;
            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }

    /**
     * Restores the heap property by moving the entry at index j upward/downward.
     *
     * @param j
     *     Index to start restoring the heap from.
     */
    private void bubble(int j) {
        if (j > 0 && heap.get(j).compareTo(heap.get(parent(j))) < 0) upheap(j);
        else downheap(j);
    }

    /**
     * Adds a new vertex to the PriorityQueue with the given key.
     *
     * @param vertex
     *     Vertex to add to the queue.
     * @param key
     *     Key for the vertex in the queue.
     */
    private void insert(Vertex vertex, int key) {
        PQEntry newest = new PQEntry(key, vertex, heap.size());
        heap.add(newest);
        upheap(heap.size() - 1);
        entries.put(vertex, newest);
    }

    // ------- PUBLIC METHODS -----------------------------------------------------
    /**
     * Returns the number of items in the priority queue.
     *
     * @return number of items.
     */
    public int size() {
        return heap.size();
    }

    /**
     * Replaces the key of a given vertex and reorders it in the PriorityQueue.
     * If the key was not in the PriorityQueue yet, it is added.
     *
     * @param vertex
     *     Vertex to change the key from.
     * @param key
     *     New key for the given vertex.
     */
    public void insertOrReplace(Vertex vertex, int key) {
        if (!entries.containsKey(vertex)) {
            this.insert(vertex, key);
        } else {
            PQEntry entry = entries.get(vertex);
            entry.setKey(key);
            bubble(entry.getIndex());
        }
    }

    /**
     * Removes and returns an entry with minimal key.
     *
     * @return the removed entry's Vertex and its key (or null if the PQ is empty).
     */
    public VertexNumPair removeMin() {
        if (isEmpty()) return null;
        PQEntry entry = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downheap(0);
        entries.remove(entry.getValue());
        return new VertexNumPair(entry.getValue(), entry.getKey());
    }

    /**
     * Returns whether the PriorityQueue is empty or not.
     *
     * @return True when the PQ is empty, false otherwise.
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
