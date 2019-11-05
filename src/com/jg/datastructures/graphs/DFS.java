package com.jg.datastructures.graphs;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DFS<T> {
    Set<T> visited = new HashSet<>();
    Graph<T> g;

    public void DFTraversal(Graph<T> g) {
        System.out.println("::: DFS Traversal :::");
        this.g = g;
        for (T v : g.getAllVertices()) {
            if (!visited.contains(v)) {
                System.out.print(v + " ");
                visited.add(v);
                DFVisit(v);
            }
        }

        System.out.println();
    }

    private void DFVisit(T node) {
        LinkedList<T> adjList = g.getAdjacent(node);
        for (T adj : adjList) {
            if (!visited.contains(adj)) {
                System.out.print(adj + " ");
                visited.add(adj);
                DFVisit(adj);
            }
        }
    }
}
