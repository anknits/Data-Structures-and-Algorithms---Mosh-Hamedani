package Graphs;

public class Main {
    public static void main(String[] args) {
        // #region
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
        // graph.print();
        // graph.depthFirstTraversalIterative("A");
        // graph.breadthFirstTraversal("A");
        // System.out.println(graph.topologicalSorting());
        // graph.addEdge("D", "C"); // hasCycle: true
        // System.out.println(graph.hasCycle());
        // #endregion

        var weightedGraph = new WeightedGraph();
        weightedGraph.addNode("A");
        weightedGraph.addNode("B");
        weightedGraph.addNode("C");
        weightedGraph.addEdge("A", "B", 3);
        weightedGraph.addEdge("B", "C", 5);
        weightedGraph.addEdge("C", "A", 16);
        weightedGraph.print();
        var shortestDistance = weightedGraph.getShortestDistance("A", "C");
        System.out.println("Shortest distance: " + shortestDistance);
        System.out.println("hasCycle: " + weightedGraph.hasCycle());
        var mst = weightedGraph.minimumSpanningTree();
        mst.print();
    }
}
