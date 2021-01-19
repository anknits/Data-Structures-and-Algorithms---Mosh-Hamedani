package LinkedLists;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int number) {
            this.value = number;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public LinkedList() {
        this.first = this.last = null;
    }

    public void addFirst(int number) {
        var node = new Node(number);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(int number) {
        var node = new Node(number);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void deleteFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last)
            first = last = null;
        else {
            Node temp = first;
            first = first.next;
            temp.next = null;
        }
        size--;
    }

    public void deleteLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last)
            first = last = null;
        else {
            Node current = first;
            while (current.next != last)
                current = current.next;
            current.next = null;
            last = current;
        }
        size--;
    }

    public boolean contains(int number) {
        // Node current = first;
        // while (current != null && current.value != number)
        // current = current.next;
        // return current != null;
        return indexOf(number) != -1;
    }

    public int indexOf(int number) {
        int index = 0;
        Node current = first;
        while (current != null) {
            if (current.value == number)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public void print() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        var arr = new int[size];
        var current = first;
        int i = 0;
        while (current != null) {
            arr[i++] = current.value;
            current = current.next;
        }
        return arr;
    }

    public void reverse() {
        if (isEmpty())
            return;
        var current = first;
        Node previous = null;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        first = previous;
    }

    public int findKthNodeFromEnd(int k) {
        if (k <= 0 || k > size)
            throw new IllegalArgumentException();
        var current = first;
        for (int i = 0; i <= k - size + 1; i++) {
            current = current.next;
        }
        return current.value;
    }

    public int[] middleNode() {
        if (isEmpty())
            throw new NoSuchElementException();
        var slow = first;
        var fast = first;
        while (fast != last && fast.next != last) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == last) {
            int[] arr = { slow.value };
            return arr;
        } else {
            int[] arr = new int[2];
            arr[0] = slow.value;
            arr[1] = slow.next.value;
            return arr;
        }
    }

    public boolean hasLoop() {
        if (isEmpty())
            return false;
        var slow = first;
        var fast = first;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    private boolean isEmpty() {
        return first == null;
    }
}