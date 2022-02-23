package Endterm.Assignment_4;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class GraphCheckerTest {
    Graph exampleGraph() {
        Graph g = new Graph();
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        g.addVertex(v0);
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addEdge(v0, v1);
        g.addEdge(v1, v2);
        g.addEdge(v2, v3);
        g.addEdge(v3, v2);
        g.addEdge(v0, v3);
        g.addEdge(v0, v4);
        g.addEdge(v4, v5);
        g.addEdge(v5, v4);
        g.addEdge(v5, v3);
        g.addEdge(v3, v5);
        return g;
    }

    @Test
    void exampleDFS() {
        Graph g = exampleGraph();
        assertEquals(
                List.of(0, 1, 2, 3, 5, 4),
                new GraphChecker().traverseDepthFirst(g, g.getVertex(0)));
    }

    @Test
    void exampleTranspose() {
        // See a graphical representation of the expected outcome at the bottom of the description
        Graph g = new Graph();
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        g.addVertex(v0);
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addEdge(v1, v0);
        g.addEdge(v2, v1);
        g.addEdge(v2, v3);
        g.addEdge(v3, v2);
        g.addEdge(v3, v0);
        g.addEdge(v4, v0);
        g.addEdge(v4, v5);
        g.addEdge(v5, v4);
        g.addEdge(v3, v5);
        g.addEdge(v5, v3);
        Graph t = new GraphChecker().transpose(exampleGraph());
        assertEquals(g, t);
    }

    @Test
    void exampleConnected() {
        Graph g = exampleGraph();
        assertFalse(new GraphChecker().isStronglyConnected(g));
        g.addEdge(g.getVertex(4), g.getVertex(0));
        assertTrue(new GraphChecker().isStronglyConnected(g));
    }
}