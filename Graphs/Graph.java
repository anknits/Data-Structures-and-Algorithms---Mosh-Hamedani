package Graphs;

import Arrays.Array;

import java.util.*;

public class Graph{
    private class Node{
        private String label;

        public Node(String label){
            this.label = label;
        }
    }

    private int count;
    private HashSet<Node> nodes = new HashSet<>();
    private Map<Node, Integer> map = new HashMap<>();
    private List<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();

    public void addNode(String label){
        Node node = new Node(label);
        if(map.containsKey(node))
        return;
        map.put(node, count++);
    }

    public void removeNode(String label){
        Node node = new Node(label);
        if(!map.containsKey(node))
            return;
        map.remove(node);
    }

    public void addEdge(String from, String to){
        Node fromNode = new Node(from);
        Node toNode = new Node(to);
        if(!map.containsKey(fromNode))
            return;
        if(!map.containsKey(toNode))
            return;
        int index = map.get(fromNode);
        LinkedList<Node> ll = lists.get(index);
        if(ll.contains(toNode))
            return;
        else ll.add(toNode);
    }

    public void removeEdge(String from, String to){
        Node fromNode = new Node(from);
        Node toNode = new Node(to);
        if(!map.containsKey(fromNode))
            return;
        if(!map.containsKey(toNode))
            return;
        int index = map.get(fromNode);
        LinkedList<Node> ll = lists.get(index);
        if(!ll.contains(toNode))
            return;
        else ll.remove(toNode);
    }

    public void print(){
        for(Map.Entry<Node, Integer> entry : map.entrySet()){
            Node node = entry.getKey();
            String label = node.label;
            int index = entry.getValue();
            LinkedList<Node> ll = lists.get(index);
            if(ll.size() > 0){
                System.out.println(label+" is connected to ");
                String x = ll.iterator().next().label;
            }
        }
    }
}