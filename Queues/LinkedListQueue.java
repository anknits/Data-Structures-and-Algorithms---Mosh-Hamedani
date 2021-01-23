package Queues;

public class LinkedListQueue {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private int count;
    private Node head;
    private Node tail;

    public void enqueue(int i) {
        var node = new Node(i);
        if (isEmpty())
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        int value;
        if (head == tail) {
            value = head.value;
            head = tail = null;
        } else {
            value = head.value;
            var next = head.next;
            head.next = null;
            head = next;
        }
        count--;
        return value;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return head.value;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}