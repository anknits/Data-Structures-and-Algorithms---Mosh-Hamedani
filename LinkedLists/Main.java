package dsa.LinkedLists;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addLast(40);
        list.addLast(50);
        list.deleteFirst();
        list.deleteLast();
        list.print();
        System.out.println(list.indexOf(20));
        System.out.println(list.indexOf(50));
        System.out.println(list.contains(20));
        System.out.println(list.contains(50));
        System.out.println(list.size());
        System.out.println(Arrays.toString(list.toArray()));
        list.reverse();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.findKthNodeFromEnd(3));
        int[] arr = list.middleNode();
        System.out.println(arr[0]);
        System.out.println(list.hasLoop());
    }
}