package com.jg.datastructures.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BFS<T> {
    public void BFSTraversal(Graph<T> graph) {
        System.out.println("::: BFS Traversal :::");
        Set<T> visited = new HashSet<>();
        LinkedList<T> q = null;
        for (T v : graph.getAllVertices()) {
            if (q == null) {
                q = new LinkedList<>();
                q.add(v);
                visited.add(v);
            } else {
                while (!q.isEmpty()) {
                    T u = q.removeFirst();
                    visited.add(u);
                    LinkedList<T> adjList = graph.getAdjacent(u);
                    for (T adj : adjList) {
                        if (!visited.contains(adj)) {
                            q.addLast(adj);
                            visited.add(adj);
                        }
                    }
                    System.out.print(u + " ");
                }
            }
        }
        System.out.println();
    }
}
