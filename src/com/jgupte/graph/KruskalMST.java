package com.jgupte.graph;

import com.jgupte.graph.v2.Graph;

import java.util.*;

public class KruskalMST<T> {
    public class EdgeComparator implements Comparator<Graph.Edge<T>> {

        @Override
        public int compare(Graph.Edge<T> e1, Graph.Edge<T> e2) {
            if (e1.getWeight() <= e2.getWeight()) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public List<Graph.Edge<T>> getMinimumSpanningTree(Graph<T> g) {
        List<Graph.Edge<T>> mst = new ArrayList<>();
        List<Graph.Edge<T>> allEdges = new ArrayList<>(g.getEdgeList());
        DisjointSet<T> djSet = new DisjointSet<>();

        EdgeComparator comparator = new EdgeComparator();
        Collections.sort(allEdges, comparator);

        for (T edge : g.getAllVertices()) {
            djSet.createSet((T) edge);
        }

        for (Graph.Edge<T> edge : allEdges) {
            T set1 = djSet.findSet(edge.getVertex1());
            T set2 = djSet.findSet(edge.getVertex2());

            if (set1 == set2) {
                continue;
            } else {
                mst.add(edge);
                djSet.union(set1, set2);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(false);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 3);
        graph.addEdge(0, 3, 7);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 4, 1);
        graph.addEdge(3, 4, 3);

        KruskalMST<Integer> kruskalMST = new KruskalMST<>();
        List<Graph.Edge<Integer>> mst = kruskalMST.getMinimumSpanningTree(graph);
        int totalCost = 0;
        for (Graph.Edge<Integer> edge : mst) {
            System.out.println(edge.getVertex1() + " " + edge.getVertex2());
            totalCost += edge.getWeight();
        }

        System.out.println("Total Cost: " + totalCost);
    }
}
