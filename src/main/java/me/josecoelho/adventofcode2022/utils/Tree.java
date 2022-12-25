package me.josecoelho.adventofcode2022.utils;

import java.util.LinkedList;
import java.util.List;

public class Tree<T> {

    private final Node<T> root;

    public Tree(T rootData) {
        this.root = new Node<>(rootData, null);
    }

    public Node<T> getRoot() {
        return root;
    }

    public static class Node<T> {
        private final T data;
        private final Node<T> parent;
        private final List<Node<T>> children;

        public Node(T data, Node<T> parent) {
            this.data = data;
            this.parent = parent;
            this.children = new LinkedList<>();
        }

        public void appendChild(T child) {
            children.add(new Node<>(child, this));
        }

        public T getData() {
            return data;
        }

        public Node<T> getParent() {
            return parent;
        }

        public List<Node<T>> getChildren() {
            return children;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
