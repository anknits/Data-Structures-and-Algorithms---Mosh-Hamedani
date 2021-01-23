package Queues;

import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    public void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());
    }

    public void reverse(Queue<Integer> queue, int k) {
        if (k < 0 || k > queue.size())
            throw new IllegalArgumentException();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.remove());
        }
        for (int i = 0; i < k; i++) {
            queue.add(stack.pop());
        }
        for (int i = k; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }
}
