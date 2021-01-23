package Queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        System.out.println("ReverseQueue");
        Queue<Integer> queue1 = new ArrayDeque<>();
        var reverseQueue = new ReverseQueue();
        queue1.add(10);
        queue1.add(20);
        queue1.add(30);
        reverseQueue.reverse(queue1);
        System.out.println(queue1);

        System.out.println("ArrayQueue");
        ArrayQueue queue2 = new ArrayQueue(5);
        queue2.enqueue(10);
        queue2.enqueue(20);
        queue2.enqueue(30);
        var front = queue2.dequeue();
        System.out.println(front);
        System.out.println(queue2);

        System.out.println("StackQueue");
        StackQueue queue3 = new StackQueue();
        queue3.enqueue(10);
        queue3.enqueue(20);
        queue3.enqueue(30);
        front = queue3.dequeue();
        System.out.println(front);
        System.out.println(queue3);

        System.out.println("ArrayPriorityQueue");
        ArrayPriorityQueue queue4 = new ArrayPriorityQueue(5);
        queue4.enqueue(7);
        queue4.enqueue(3);
        queue4.enqueue(10);
        front = queue4.dequeue();
        System.out.println(front);
        queue4.enqueue(6);
        System.out.println(queue4);
    }

}
