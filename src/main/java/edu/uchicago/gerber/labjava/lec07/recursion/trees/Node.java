package edu.uchicago.gerber.labjava.lec07.recursion.trees;

public class Node <T extends Comparable<T>> {
    Node<T> left = null;
    Node<T> right = null;
    Node<T> parent = null;

    T data = null;
    static int nodeCount = 0;
    int nodeID;

    public Node(T data) {
        this.data = data;
        int nodeID = nodeCount++;
        System.out.println("creating nodeID: " + nodeID + " data: " + data);
    }

    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
        int nodeID = nodeCount++;
        System.out.println("creating nodeID: " + nodeID + " data: " + data);
    }

    public Node(T data, Node<T> left, Node<T> right, Node<T> parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
        int nodeID = nodeCount++;
        System.out.println("creating nodeID: " + nodeID + " data: " + data);
    }

    public T getData() {
        return data;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getLeft() {
        return left;
    }
    public Node<T> getRight() {
        return right;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public boolean contains(T data) {
        System.out.println("Examining Node " + nodeID + " with data " + this.data + " for " + data);
        if (this.data.compareTo(data) == 0) {
            return true;
        }

        boolean contains = false;

        if (this.right != null) {
            contains = this.right.contains(data);
        }

        if (this.left != null) {
            contains = contains || this.left.contains(data);
        }

        return contains;
    }

    public void add(T data) {
        System.out.println("Examining Node " + nodeID + " with data " + this.data + " to add " + data);
        if (this.data.compareTo(data) == 0 || this.data.compareTo(data) == -1) {
            if (this.right == null) {
                this.right = new Node<>(data);
                this.right.parent = this;
                return;
            }

            this.right.add(data);

            return;
        }

        if (this.left == null) {
            this.left = new Node<>(data);
            this.left.parent = this;
            return;
        }

        this.left.add(data);
    }

    public String getInOrderString() {
        String n = "";
        if (this.left != null) {
            n += this.left.getInOrderString() + " ";
        }

        n += this.data.toString();

        if (this.right != null) {
            n += " ";
            n += this.right.getInOrderString();
        }

        return n;
    }
}
