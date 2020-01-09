package com.jgupte.graph;

import com.jgupte.graph.v1.Graph;

import java.util.*;

/**
 * Below problem is based on Tarjan's algorithm to find the articulation points in the graph.
 * A critical connection is an edge in the graph that, if removed, will make some vertices unable to reach some other vertices.
 * i.e. increase the number of strongly connected components in the graph.
 */
public class CriticalConnections {
    Graph<Integer> g;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        g = new Graph<>();
        for (List<Integer> edge : connections) {
            g.addEdge(edge.get(0), edge.get(1), true);
        }

        List<List<Integer>> criticalEdges = new ArrayList<>();
        Set<Integer> visited = new HashSet<Integer>();

        Map<Integer, Integer> visitedTime = new HashMap<>();
        Map<Integer, Integer> lowTime = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        DFS(g.source, visited, criticalEdges, visitedTime, lowTime, parent, 0);
        return criticalEdges;
    }

    private void DFS(Integer source, Set<Integer> visited, List<List<Integer>> criticalEdges, Map<Integer, Integer> visitedTime, Map<Integer, Integer> lowTime, Map<Integer, Integer> parent, int time) {
        List<Integer> criticalEdge = new ArrayList<>();
        visited.add(source);
        visitedTime.put(source, time);
        lowTime.put(source, time);
        time++;
        for (Integer adj : g.getAdjacent(source)) {
            if (adj.equals(parent.get(source)))
                continue;

            if (!visited.contains(adj)) {
                parent.put(adj, source);
                DFS(adj, visited, criticalEdges, visitedTime, lowTime, parent, time);

                //update the low time
                if (parent.get(source) != null) {
                    lowTime.compute(source, (currentVertex, t) ->
                            Math.min(t, lowTime.get(adj))
                    );
                }
            } else {
                //update the low time
                if (parent.get(source) != null) {
                    lowTime.compute(source, (currentVertex, t) ->
                            Math.min(t, visitedTime.get(adj))
                    );
                }
            }
        }

        //If visited time of parent node is less than low time of the current node, then its a critical connection
        if (parent.get(source) != null && visitedTime.get(parent.get(source)) < lowTime.get(source)) {
            criticalEdge.add(parent.get(source));
            criticalEdge.add(source);
            criticalEdges.add(criticalEdge);
        }
    }

    public static void main(String[] args) {
        CriticalConnections criticalConnections = new CriticalConnections();
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> c1 = new ArrayList<>();
        c1.add(1);
        c1.add(0);
        connections.add(c1);

        List<Integer> c2 = new ArrayList<>();
        c2.add(2);
        c2.add(0);
        connections.add(c2);

        List<Integer> c3 = new ArrayList<>();
        c3.add(3);
        c3.add(2);
        connections.add(c3);

        List<Integer> c4 = new ArrayList<>();
        c4.add(4);
        c4.add(2);
        connections.add(c4);

        List<Integer> c5 = new ArrayList<>();
        c5.add(4);
        c5.add(3);
        connections.add(c5);

        List<Integer> c6 = new ArrayList<>();
        c6.add(3);
        c6.add(0);
        connections.add(c6);

        List<Integer> c7 = new ArrayList<>();
        c6.add(4);
        c6.add(0);
        connections.add(c6);

        System.out.println(criticalConnections.criticalConnections(connections.size(), connections));
    }
}