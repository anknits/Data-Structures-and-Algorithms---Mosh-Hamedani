package Heaps;

public class MinPriorityQueue {
    private MinHeap heap;

    public MinPriorityQueue(int size) {
        heap = new MinHeap(size);
    }

    public void enqueue(int priority, String value) {
        heap.insert(priority, value);
    }

    public String dequeue() {
        return heap.remove();
    }

    public int peek() {
        return heap.min();
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
