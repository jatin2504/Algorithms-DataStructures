package com.jgupte.graph.v1;

import com.jgupte.graph.BFS;
import com.jgupte.graph.DFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph<T> {
    public HashMap<T, LinkedList<T>> gMap = new HashMap<>();
    public T source;

    // This function adds a new vertex to the graph
    public void addVertex(T s) {
        gMap.put(s, new LinkedList<T>());
    }

    public void addEdge(T src, T dest, boolean biDir) {
        if (this.source == null) {
            this.source = src;
        }

        if (!gMap.containsKey(src))
            addVertex(src);

        if (!gMap.containsKey(dest))
            addVertex(dest);

        gMap.get(src).add(dest);
        if (biDir == true) {
            gMap.get(dest).add(src);
        }
    }

    public int getVertexCount() {
        return gMap.keySet().size();
    }

    public boolean hasVertex(T s) {
        return gMap.containsKey(s);
    }

    public boolean hasEdge(T s, T d) {
        return (gMap.containsKey(s) && gMap.get(s).contains(d));
    }

    public Set<T> getAllVertices() {
        return gMap.keySet();
    }

    public LinkedList<T> getAdjacent(T node) {
        return gMap.get(node);
    }

    public void printGraph() {
        for (Map.Entry entry : gMap.entrySet()) {
            LinkedList<T> list = (LinkedList<T>) entry.getValue();
            for (T node : list) {
                System.out.print((entry.getKey()) + "->" + node + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Graph<Integer> g = new Graph<Integer>();

        g.addEdge(0, 1, false);
        g.addEdge(0, 4, false);
        g.addEdge(1, 2, false);
        g.addEdge(1, 3, false);
        g.addEdge(1, 4, false);
        g.addEdge(2, 3, false);
        g.addEdge(3, 4, false);

        g.printGraph();

        BFS<Integer> bfs = new BFS<>();
        bfs.BFSTraversal(g);

        DFS<Integer> dfs = new DFS<>();
        dfs.DFTraversal(g);

    }
}
