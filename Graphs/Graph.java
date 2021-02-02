package Graphs;

import java.util.*;

public class Graph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = nodes.get(label);
        if (node != null)
            throw new IllegalArgumentException("Node already present with label" + label);
        node = new Node(label);
        nodes.put(label, node);
        adjacencyList.put(node, new ArrayList<>());
    }

    public void removeNode(String label) {
        Node node = nodes.get(label);
        if (node == null)
            throw new IllegalArgumentException("No node found with label" + label);
        for (var n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);
        adjacencyList.remove(node);
        nodes.remove(label, node);
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException("No node found with label" + from);
        Node toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException("No node found with label" + to);
        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException("No node found with label" + from);
        Node toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException("No node found with label" + to);
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void print() {
        for (var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }
}