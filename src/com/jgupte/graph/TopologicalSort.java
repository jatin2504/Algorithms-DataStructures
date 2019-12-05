package com.jgupte.graph;

import com.jgupte.graph.v1.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class TopologicalSort<T> {
    LinkedList<T> sort(Graph<T> g) {
        LinkedList<T> sortedList = new LinkedList<>();
        Set<T> visited = new HashSet<>();

        for (T vertex : g.getAllVertices()) {
            if (!visited.contains(vertex)) {
                sortUtil(vertex, sortedList, visited, g);
            }
        }

        return sortedList;
    }

    private void sortUtil(T vertex, LinkedList<T> sortedList, Set<T> visited, Graph<T> g) {
        visited.add(vertex);
        for (T v : g.getAdjacent(vertex)) {
            if (!visited.contains(v)) {
                sortUtil(v, sortedList, visited, g);
            }
        }
        sortedList.addFirst(vertex);
    }


    public static void main(String[] args) {
        Graph<Character> graph = new Graph<>();
        graph.addEdge('a', 'd', false);
        graph.addEdge('b', 'd', false);
        graph.addEdge('d', 'h', false);
        graph.addEdge('b', 'c', false);
        graph.addEdge('c', 'f', false);
        graph.addEdge('c', 'e', false);
        graph.addEdge('e', 'b', false);
        graph.addEdge('f', 'g', false);
        graph.addEdge('i', 'j', false);

        TopologicalSort<Character> topologicalSort = new TopologicalSort<>();
        LinkedList<Character> sortedList = topologicalSort.sort(graph);
        while (!sortedList.isEmpty()) {
            System.out.print(sortedList.getFirst() + " ");
            sortedList.removeFirst();
        }
    }
}
