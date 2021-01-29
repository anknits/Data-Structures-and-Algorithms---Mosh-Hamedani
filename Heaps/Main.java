package Heaps;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        createHeap();
        heapSort();
        priorityQueue();
    }

    public static void createHeap() {
        System.out.println("createHeap");
        var heap = new Heap();
        heap.insert(15);
        heap.insert(10);
        heap.insert(3);
        heap.insert(8);
        heap.insert(12);
        heap.insert(9);
        heap.insert(4);
        heap.insert(1);
        heap.insert(24);
        heap.remove();
        System.out.println(heap);
    }

    public static void heapSort() {
        System.out.println("heapSort");
        int[] numbers = { 5, 3, 10, 1, 4, 2 };
        var heap = new Heap();
        for (var number : numbers)
            heap.insert(number);
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = heap.remove();
        System.out.println(Arrays.toString(numbers));
    }

    public static void priorityQueue() {
        System.out.println("PriorityQueue");
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue(7);
        queue.enqueue(3);
        queue.enqueue(10);
        var front = queue.dequeue();
        System.out.println(front);
        queue.enqueue(6);
        System.out.println(queue);
    }
}
