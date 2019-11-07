package com.jgupte.tree;

import com.jgupte.stackqueue.Queue;

import java.util.Stack;

public class BinarySearchTree {
    private Node root;

    private Node getNewNode(int data) {
        Node newNode = new Node();
        newNode.setData(data);
        newNode.setLeft(null);
        newNode.setRight(null);
        return newNode;
    }

    private Node addNode(int data, Node root) {
        if (this.root == null) {
            this.root = getNewNode(data);
            return this.root;
        } else if (root == null) {
            root = getNewNode(data);
        } else if (root.getData() >= data) {
            root.setLeft(addNode(data, root.getLeft()));
        } else {
            root.setRight(addNode(data, root.getRight()));
        }
        return root;
    }

    private boolean searchNode(int data, Node root) {
        if (root == null)
            return false;
        else if (root.getData() == data)
            return true;
        else if (root.getData() > data)
            return searchNode(data, root.getLeft());
        else
            return searchNode(data, root.getRight());

    }

    private Node removeNode(int data, Node root) {
        if (root == null) {
            return null;
        } else if (root.getData() < data) {
            root.setRight(removeNode(data, root.getRight()));
        } else if (root.getData() > data) {
            root.setLeft(removeNode(data, root.getLeft()));
        } else {
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
            } else if (root.getLeft() == null) {
                root = root.getRight();
            } else if (root.getRight() == null) {
                root = root.getLeft();
            } else {
                Node temp = findMin(root.getRight());
                root.setData(temp.getData());
                root.setRight(removeNode(temp.getData(), root.getRight()));
            }
        }
        return root;
    }

    public static Node findMin(Node node) {
        while (node.getLeft() != null)
            node = node.getLeft();
        return node;
    }

    public void levelOrderTraversal() {
        if (this.root != null) {
            System.out.println(":::::: LEVEL ORDER TRAVERSAL ::::::");
            Queue<Node> queue = new Queue<>();
            queue.enqueue(this.root);
            while (!queue.isEmpty()) {
                Node first = queue.dequeue();
                System.out.print(first.getData() + " ");
                if (first.getLeft() != null) {
                    queue.enqueue(first.getLeft());
                }
                if (first.getRight() != null) {
                    queue.enqueue(first.getRight());
                }
            }
            System.out.println();
        } else {
            System.out.print(":::::: The tree is empty ::::::");
        }
    }

    public void inOrderIterative() {
        if (this.root != null) {
            System.out.println(":::::: IN-ORDER TRAVERSAL ITERATIVE::::::");
            //Stack<Node> stack = new Stack<>();
            Stack<Node> stack = new Stack<>();
            Node curr = this.root;
            stack.push(curr);
            while (true) {
                while (curr.getLeft() != null) {
                    stack.push(curr.getLeft());
                    curr = curr.getLeft();
                }

                while (!stack.isEmpty()) {
                    curr = stack.pop();
                    System.out.print(curr.getData() + " ");
                    if (curr.getRight() != null) {
                    	stack.push(curr.getRight());
                        curr = curr.getRight();
                        break;
                    }
                }
                if(stack.isEmpty()){
                    break;
                }
            }
            System.out.println();
        }
    }

    private void inOrder(Node root) {
        if (root != null) {
            if (root.getLeft() != null) {
                inOrder(root.getLeft());
            }
            System.out.print(root.getData() + " ");
            if (root.getRight() != null) {
                inOrder(root.getRight());
            }
        }
    }

    public void preOrder(Node root){
        if(root != null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root){
        if(root != null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public boolean search(int data) {
        if (this.root == null)
            return false;
        else
            return searchNode(data, this.root);
    }

    public void add(int data) {
        addNode(data, this.root);
    }

    public Node remove(int data) {
        return removeNode(data, this.root);
    }

    public static void main(String[] args) {
        BinarySearchTree bst1 = new BinarySearchTree();
        bst1.add(10);
        bst1.add(20);
        bst1.add(6);
        bst1.add(17);
        bst1.add(7);
        bst1.add(27);
        bst1.add(16);

//        System.out.println("values added" + bst1);
//        bst1.remove(6);
//        System.out.println("values added" + bst1);
//        System.out.println("search: " + bst1.search(20));

        bst1.levelOrderTraversal();
        bst1.inOrderIterative();
    }

    @Override
    public String toString() {
        return "BinarySearchTree [root=" + root + "]";
    }

    class Node {
        public int data;
        public Node left;
        public Node right;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public String toString() {
            return "{data:" + data ;
        }

    }

}
