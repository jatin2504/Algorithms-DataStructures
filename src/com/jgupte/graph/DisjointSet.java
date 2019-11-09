package com.jgupte.graph;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet<T> {
    private Map<T, Node> setMap = new HashMap<>();

    class Node<T> {
        int rank;
        T data;
        Node parent;
    }

    public void createSet(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        node.rank = 0;
        node.parent = node;
        setMap.put(data, node);
    }

    public void union(T data1, T data2) {
        Node parent1 = findSet(setMap.get(data1));
        Node parent2 = findSet(setMap.get(data2));

        if (parent1 == parent2) {
            return;
        }

        if (parent1.rank >= parent2.rank) {
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
    }

    public T findSet(T data) {
        return (T) findSet(setMap.get(data)).data;
    }

    private Node<T> findSet(Node<T> node) {
        Node parent = node.parent;
        if (parent == node) {
            return node;
        }
        node.parent = findSet(parent);
        return node.parent;
    }

    public static void main(String[] args) {
        DisjointSet<Integer> ds = new DisjointSet<>();
        ds.createSet(1);
        ds.createSet(2);
        ds.createSet(3);
        ds.createSet(4);
        ds.createSet(5);
        ds.createSet(6);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(5, 6);
        ds.union(1, 6);

        System.out.println("set 1 " + ds.findSet(1));
        System.out.println("set 2 " + ds.findSet(2));
        System.out.println("set 3 " + ds.findSet(3));
        System.out.println("set 4 " + ds.findSet(4));
        System.out.println("set 5 " + ds.findSet(5));
        System.out.println("set 6 " + ds.findSet(6));
    }
}
