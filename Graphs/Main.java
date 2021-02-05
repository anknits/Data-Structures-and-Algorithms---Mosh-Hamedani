package Graphs;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "B");
        // graph.addEdge("C", "D");
        // graph.addEdge("D", "C");
        // graph.removeEdge("A", "C");
        // graph.removeNode("B");
        // graph.depthFirstTraversal("A");
        graph.print();
        // graph.depthFirstTraversalIterative("A");
        // graph.breadthFirstTraversal("A");
        // System.out.println(graph.topologicalSorting());
        // graph.addEdge("D", "C"); // hasCycle: true
        System.out.println(graph.hasCycle());
    }
}
