package Heaps;

public class PriorityQueue {
    private Heap heap;

    public PriorityQueue(int size) {
        heap = new Heap(size);
    }

    public void enqueue(int value) {
        heap.insert(value);
    }

    public int dequeue() {
        return heap.remove();
    }

    public int peek() {
        return heap.max();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public boolean isFull() {
        return heap.isFull();
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
