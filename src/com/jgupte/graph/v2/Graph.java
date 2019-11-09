package com.jgupte.graph.v2;

import java.util.*;

public class Graph<T> {
    private HashMap<T, LinkedList<Edge<T>>> graphMap = new HashMap<>();
    private Set<Edge<T>> edgeList = new HashSet<>();

    boolean directed = false;

    public Graph(boolean directed) {
        this.directed = directed;
    }

    // This function adds a new vertex to the graph
    public void addVertex(T s) {
        graphMap.put(s, new LinkedList<Edge<T>>());
    }

    public void addEdge(T vertex1, T vertex2, int weight) {
        Edge edge = new Edge(vertex1, vertex2, weight);

        if (graphMap.containsKey(vertex1)) {
            graphMap.get(vertex1).addLast(edge);
        } else {
            LinkedList<Edge<T>> edgeList = new LinkedList<>();
            edgeList.addLast(edge);
            graphMap.put(vertex1, edgeList);
        }

        if (graphMap.containsKey(vertex2)) {
            if (!this.directed) {
                graphMap.get(vertex2).addLast(edge);
            }
        } else {
            LinkedList<Edge<T>> edgeList = new LinkedList<>();
            if (!this.directed)
                edgeList.addLast(edge);
            graphMap.put(vertex2, edgeList);
        }

        if (!edgeList.contains(edge)) {
            edgeList.add(edge);
        }
    }

    public Set<Edge<T>> getEdgeList() {
        return edgeList;
    }

    public int getVertexCount() {
        return graphMap.keySet().size();
    }

    public boolean hasVertex(T s) {
        return graphMap.containsKey(s);
    }

    public boolean hasEdge(T vertex1, T vertex2) {
        if (graphMap.containsKey(vertex1)) {
            LinkedList<Edge<T>> edgeList = graphMap.get(vertex1);
            for (Edge<T> edge : edgeList) {
                if (edge.equals(vertex2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Set<T> getAllVertices() {
        return graphMap.keySet();
    }

    public LinkedList<Edge<T>> getEdges(T node) {
        return graphMap.get(node);
    }

    public void printGraph() {
        for (Map.Entry entry : graphMap.entrySet()) {
            LinkedList<Edge<T>> list = (LinkedList<Edge<T>>) entry.getValue();
            //for (Edge<T> edge : list) {
            System.out.print((entry.getKey()) + "->" + entry.getValue() + " ");
            //}
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>(true);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 4, 3);
        g.addEdge(1, 2, 7);
        g.addEdge(1, 3, 1);
        g.addEdge(1, 4, 3);
        g.addEdge(2, 3, 5);
        g.addEdge(3, 4, 8);

        g.printGraph();
    }

    public static class Edge<T> {
        T vertex1;
        T vertex2;
        int weight;

        public Edge(T vertex1, T vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        public T getVertex1() {
            return vertex1;
        }

        public void setVertex1(T vertex1) {
            this.vertex1 = vertex1;
        }

        public T getVertex2() {
            return vertex2;
        }

        public void setVertex2(T vertex2) {
            this.vertex2 = vertex2;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "vertex1=" + vertex1 +
                    ", vertex2=" + vertex2 +
                    ", weight=" + weight +
                    '}';
        }
    }
}
