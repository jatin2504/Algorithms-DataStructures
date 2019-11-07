package com.jgupte.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class BinaryMinHeap<T> {

    List<Node> nodeList;
    HashMap<T, Integer> position;

    public BinaryMinHeap() {
        nodeList = new ArrayList<>();
        position = new HashMap<>();

        Node dummy = new Node();
        nodeList.add(dummy);
    }

    public void add(int key, T item) {
        Node node = new Node(key, item);
        position.put(item, nodeList.size());
        nodeList.add(node);
        upHeap(nodeList.size() - 1);
    }



    public T extractMin() {
        Node minNode = new Node();
        minNode.key = nodeList.get(1).key;
        minNode.item = nodeList.get(1).item;
        int lastNodeKey = nodeList.get(nodeList.size() - 1).key;
        T lastNodeItem = nodeList.get(nodeList.size() - 1).item;

        nodeList.get(1).item = lastNodeItem;
        nodeList.get(1).key = lastNodeKey;
        nodeList.remove(nodeList.size() - 1);

        position.remove(minNode.item);
        if (!isEmpty())
            position.put(nodeList.get(1).item, 1);

        downHeap(1);

        return minNode.item;
    }

    public boolean isEmpty() {
        return (nodeList.size() == 1);
    }

    public void updateKey(T item, int key) {
        Integer itemPosition = position.get(item);
        if (itemPosition == null) {
            System.out.println("No such element found");
            return;
        }

        int nodeKey = nodeList.get(itemPosition).key;
        nodeList.get(itemPosition).key = key;
        if (key < nodeKey) {
            upHeap(itemPosition);
        } else if (key > nodeKey) {
            downHeap(itemPosition);
        }
    }

    private void upHeap(int current) {
        while (current > 1 && (nodeList.get(current / 2).key > nodeList.get(current).key)) {
            swap(nodeList.get(current / 2), nodeList.get(current));
            updatePosition(nodeList.get(current / 2).item, nodeList.get(current).item, current / 2, current);
            current = current / 2;
        }
    }

    private void downHeap(int current) {
        int parent = current;

        while (parent < nodeList.size()) {
            int child1 = 2 * parent;
            int child2 = 2 * parent + 1;
            if (child2 < nodeList.size()) { //the node has two children
                if (nodeList.get(parent).key <= nodeList.get(child1).key && nodeList.get(parent).key <= nodeList.get(child2).key) {
                    break;
                } else {
                    if (nodeList.get(child1).key < nodeList.get(child2).key) {
                        swap(nodeList.get(parent), nodeList.get(child1));
                        updatePosition(nodeList.get(parent).item, nodeList.get(child1).item, parent, child1);
                        parent = child1;
                    } else {
                        swap(nodeList.get(parent), nodeList.get(child2));
                        updatePosition(nodeList.get(parent).item, nodeList.get(child2).item, parent, child2);
                        parent = child2;
                    }
                }
            } else {
                if (child1 < nodeList.size() && nodeList.get(child1).key < nodeList.get(parent).key) { //check if node has one child
                    swap(nodeList.get(parent), nodeList.get(child1));
                    updatePosition(nodeList.get(parent).item, nodeList.get(child1).item, parent, child1);
                    parent = child1;
                }
                parent++;
            }
        }
    }

    private void swap(Node node1, Node node2) {
        int tempKey = node1.key;
        T tempItem = node1.item;

        node1.key = node2.key;
        node1.item = node2.item;

        node2.key = tempKey;
        node2.item = tempItem;

    }

    private void updatePosition(T item1, T item2, int pos1, int pos2) {
        position.remove(item1);
        position.remove(item2);
        position.put(item1, pos1);
        position.put(item2, pos2);
    }

    public void printHeap() {
        for (Node n : nodeList) {
            System.out.println(n.key + " " + n.item);
        }
    }

    private void printPositionMap() {
        System.out.println(position);
    }

    public static void main(String args[]) {
        BinaryMinHeap<String> heap = new BinaryMinHeap<String>();
        heap.add(3, "Tushar");
        heap.add(4, "Ani");
        heap.add(8, "Vijay");
        heap.add(10, "Pramila");
        heap.add(5, "Roy");
        heap.add(6, "NTF");
        heap.add(2, "AFR");
        // heap.decrease("Pramila", 1);
        heap.printHeap();
        heap.printPositionMap();
        System.out.println(heap.extractMin());
        heap.updateKey("Tushar", 12);
        System.out.println(heap.extractMin());
        System.out.println(heap.extractMin());
        System.out.println(heap.extractMin());
        System.out.println(heap.extractMin());
        System.out.println(heap.extractMin());
        System.out.println(heap.extractMin());
    }

    class Node {
        int key;
        T item;

        public Node() {
        }

        public Node(int key, T item) {
            this.key = key;
            this.item = item;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key &&
                    Objects.equals(item, node.item);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, item);
        }
    }
}

