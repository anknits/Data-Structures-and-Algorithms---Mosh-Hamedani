package Graphs;

import java.util.*;

public class WeightedGraph {
    private class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("Edge from %s to %s, weight: %d", from, to, weight);
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException("No node found with label" + from);
        Node toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException("No node found with label" + to);

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for (var node : nodes.values()) {
            var edges = node.getEdges();
            if (!edges.isEmpty())
                System.out.println(node + " : " + edges);
        }
    }

    private class NodePriority {
        private Node node;
        private int priority;

        public NodePriority(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public int getShortestDistance(String from, String to) {
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException("No node found with label" + from);
        Node toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException("No node found with label" + to);

        Set<Node> visited = new HashSet<>();
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> previousNodes = new HashMap<>();
        for (var node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);
        distances.put(fromNode, 0);

        PriorityQueue<NodePriority> queue = new PriorityQueue<>(Comparator.comparingInt(np -> np.priority));
        queue.add(new NodePriority(fromNode, 0));

        while (!queue.isEmpty()) {
            var current = queue.remove().node;
            var currentDistance = distances.get(current);
            visited.add(current);
            for (var edge : current.getEdges()) {
                var neighbour = edge.to;
                if (visited.contains(neighbour))
                    continue;
                var newDistance = currentDistance + edge.weight;
                if (distances.get(neighbour) > newDistance) {
                    distances.put(neighbour, newDistance);
                    previousNodes.put(neighbour, current);
                    queue.add(new NodePriority(neighbour, newDistance));
                }
            }
        }
        List<String> path = new ArrayList<>();
        while (toNode != null) {
            path.add(toNode.label);
            toNode = previousNodes.get(toNode);
        }
        Collections.reverse(path);
        System.out.println("Shortest path: " + path);
        return distances.get(nodes.get(to));
    }

    public boolean hasCycle() {
        HashSet<Node> visited = new HashSet<>();
        HashSet<Node> all = new HashSet<>();
        all.addAll(nodes.values());
        for (var node : nodes.values()) {
            if (!visited.contains(node) && hasCycle(node, null, visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node current, Node parent, HashSet<Node> visited) {
        visited.add(current);
        for (var edge : current.getEdges()) {
            var toNode = edge.to;
            if (toNode == parent)
                continue;
            if (visited.contains(toNode) || hasCycle(toNode, current, visited))
                return true;
        }
        return false;
    }

    public WeightedGraph minimumSpanningTree() {
        var tree = new WeightedGraph();
        if (nodes.isEmpty())
            return tree;
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<Node> visited = new HashSet<>();
        var node = nodes.values().iterator().next();
        queue.addAll(node.getEdges());
        tree.addNode(node.label);
        visited.add(node);
        if (queue.isEmpty())
            return tree;
        while (!queue.isEmpty()) {
            var edge = queue.remove();
            if (visited.contains(edge.to))
                continue;
            visited.add(edge.to);
            tree.addNode(edge.to.label);
            tree.addEdge(edge.from.label, edge.to.label, edge.weight);
            queue.addAll(edge.to.getEdges());
        }
        return tree;
    }
}