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

    public void depthFirstTraversal(String label) {
        Node node = nodes.get(label);
        if (node == null)
            throw new IllegalArgumentException("No node found with label" + label);
        var set = new HashSet<Node>();
        depthFirstTraversal(node, set);
    }

    private void depthFirstTraversal(Node node, HashSet<Node> set) {
        if (set.contains(node))
            return;
        set.add(node);
        System.out.println(node.label);
        for (var neighbour : adjacencyList.get(node))
            depthFirstTraversal(neighbour, set);
    }

    public void depthFirstTraversalIterative(String label) {
        Node node = nodes.get(label);
        if (node == null)
            throw new IllegalArgumentException("No node found with label" + label);
        var set = new HashSet<Node>();
        var stack = new Stack<Node>();
        stack.push(node);
        while (!stack.isEmpty()) {
            var current = stack.pop();
            set.add(current);
            System.out.println(current.label);
            for (var neighbour : adjacencyList.get(current))
                if (!set.contains(neighbour))
                    stack.push(neighbour);
        }
    }

    public void breadthFirstTraversal(String label) {
        Node node = nodes.get(label);
        if (node == null)
            throw new IllegalArgumentException("No node found with label" + label);
        var set = new HashSet<Node>();
        var queue = new ArrayDeque<Node>();
        queue.add(node);
        while (!queue.isEmpty()) {
            var current = queue.remove();
            set.add(current);
            System.out.println(current.label);
            for (var neighbour : adjacencyList.get(current))
                if (!set.contains(neighbour))
                    queue.add(neighbour);
        }
    }

    public List<String> topologicalSorting() {
        var order = new ArrayList<String>();
        var set = new HashSet<Node>();
        for (var source : nodes.values())
            topologicalSorting(source, set, order);
        Collections.reverse(order);
        return order;
    }

    private void topologicalSorting(Node node, Set<Node> set, List<String> order) {
        if (set.contains(node))
            return;
        set.add(node);
        for (var neighbour : adjacencyList.get(node))
            topologicalSorting(neighbour, set, order);
        order.add(node.label);
    }

    public boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        all.addAll(nodes.values());
        while (!all.isEmpty()) {
            if (hasCycle(all.iterator().next(), all, visiting, visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);
        for (var neighbour : adjacencyList.get(node)) {
            if (visited.contains(neighbour))
                continue;
            if (visiting.contains(neighbour))
                return true;
            if (hasCycle(neighbour, all, visiting, visited))
                return true;
        }
        visited.add(node);
        visiting.remove(node);
        return false;
    }
}
