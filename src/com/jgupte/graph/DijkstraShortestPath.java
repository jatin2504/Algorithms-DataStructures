package com.jgupte.graph;

import com.jgupte.graph.v2.Graph;
import com.jgupte.heap.BinaryMinHeap;

import java.util.HashMap;
import java.util.Map;

public class DijkstraShortestPath<T> {
    public Map<T, Integer> shortestPath(Graph<T> graph, T source) {
        BinaryMinHeap<T> heap = new BinaryMinHeap<>();
        Map<T, Integer> distanceMap = new HashMap<>();
        Map<T, T> parentMap = new HashMap<>();

        for (T vertex : graph.getAllVertices()) {
            heap.add(Integer.MAX_VALUE, vertex);
        }

        heap.updateKey(source, 0);

        distanceMap.put(source, 0);

        parentMap.put(source, null);

        while (!heap.isEmpty()) {
            BinaryMinHeap<T>.Node<T> minNode = heap.extractMin();
            T currentVertex = minNode.item;

            distanceMap.put(currentVertex, minNode.key);

            for (Graph.Edge edge : graph.getEdges(currentVertex)) {
                T adjacentVertex = getVertexForEdge(currentVertex, edge);

                if (!heap.contains(adjacentVertex)) {
                    continue;
                }

                int newDistance = distanceMap.get(currentVertex) + edge.getWeight();

                if (heap.getWeight(adjacentVertex) > newDistance) {
                    heap.updateKey(adjacentVertex, newDistance);
                    parentMap.put(adjacentVertex, currentVertex);
                }

            }
        }

        return distanceMap;
    }

    private T getVertexForEdge(T v, Graph.Edge e) {
        return (T) (e.getVertex1().equals(v) ? e.getVertex2() : e.getVertex1());
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

        DijkstraShortestPath<Integer> dj = new DijkstraShortestPath<>();
        Map<Integer, Integer> distMap = dj.shortestPath(graph, 0);

        for (Map.Entry entry : distMap.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }
}
