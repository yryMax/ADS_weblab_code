package week8.DFS_Graph;

import java.util.*;

/**
 * Implements a Depth first traversal of the Graph, starting at contructor vertex v. It
 * should return nodes at most once. If there is a choice between multiple next nodes,
 * always pick the lowest id node.
 */
class GraphIterator implements Iterator<Vertex> {

    private Graph g;

    private Vertex v;

    private Stack<Vertex> stack;

    private Set<Vertex> colored;

    private int graphSize;

    public GraphIterator(Graph g, Vertex v) {
        // TODO
        this.g = g;
        this.v = v;
        this.stack = new Stack();
        this.colored = new TreeSet();
        colored.add(v);
    }

    @Override
    public boolean hasNext() {
        // TODO
        return v != null;
    }

    @Override
    public Vertex next() {
        // TODO
        int index = -1;
        Vertex ans = v;
        Comparator<Vertex> QAQ = (Vertex o1, Vertex o2) -> o1.getId() - o2.getId();
        Collections.sort(g.getNeighbours(v),QAQ);
        for(int i=0;i<g.getNeighbours(v).size();i++){
            Vertex u =g.getNeighbours(v).get(i);
            if(!colored.contains(u)){
                colored.add(u);
                index = i;
                break;
            }
        }
        if(index == -1){
            if(stack.isEmpty())v = null;
            else v = stack.pop();
        }
        else{
            for(int i = g.getNeighbours(v).size()-1;i>index;i--){
                Vertex u =g.getNeighbours(v).get(i);
                if(!colored.contains(u)){
                    colored.add(u);
                    stack.push(u);
                }
            }
            v = g.getNeighbours(v).get(index);
        }
        //      System.out.println(v);
        return ans;
    }
}

interface Vertex extends Comparable<Vertex> {

    int getId();
}

/**
 * Interface for a generic graph. You may assume that our implementation is an
 * undirected graph.
 */
interface Graph {

    /**
     * Returns the neighbours in a sorted collection by id
     *
     * @param v
     *     node to get the neighbours of.
     * @return sorted collection of neighbours.
     */
    List<Vertex> getNeighbours(Vertex v);

    /**
     * @return an unsorted collection of all vertices in the graph.
     */
    Collection<Vertex> getAllVertices();
}

class VertexImpl implements Vertex {

    private int id;

    private Set<Vertex> neighbours;

    public VertexImpl(int id) {
        this.id = id;
        neighbours = new HashSet<>();
    }

    public void addNeighbour(Vertex v) {
        neighbours.add(v);
    }

    @Override
    public String toString() {
        return "<Vertex: " + getId() + ">";
    }

    @Override
    public int getId() {
        return id;
    }

    public Collection<Vertex> getNeighbours() {
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
        return (o instanceof Vertex) && (((Vertex) o).getId() == this.getId());
    }
}

class GraphImpl implements Graph {

    private Map<Integer, Vertex> vertices;

    public GraphImpl() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        this.vertices.put(v.getId(), v);
    }

    @Override
    public Collection<Vertex> getAllVertices() {
        return this.vertices.values();
    }

    @Override
    public List<Vertex> getNeighbours(Vertex v) {
        List<Vertex> neigh = new ArrayList<>(((VertexImpl) v).getNeighbours());
        Collections.sort(neigh);
        return neigh;
    }

    public void addEdge(Vertex v, Vertex w) {
        VertexImpl realV = (VertexImpl) v;
        VertexImpl realW = (VertexImpl) w;
        realV.addNeighbour(w);
        realW.addNeighbour(v);
    }
}

