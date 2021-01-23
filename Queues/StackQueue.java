package Queues;

import java.util.*;

public class StackQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int i) {
        stack1.push(i);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        if (stack2.empty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        return stack2.pop();
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        if (stack2.empty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.empty() && stack2.empty();
    }

    @Override
    public String toString() {
        String s = "";
        if (!stack2.isEmpty())
            s = stack2.toString();
        s += stack1.toString();
        return s;
    }
}
