package Queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingTwoQueues {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();
    private int top;

    public void push(int i) {
        queue1.add(i);
        top = i;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();
        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }
        var value = queue1.remove();
        while (!queue2.isEmpty())
            queue1.add(queue2.remove());
        return value;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return top;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public int size() {
        return queue1.size();
    }

    @Override
    public String toString() {
        return queue1.toString();
    }
}
