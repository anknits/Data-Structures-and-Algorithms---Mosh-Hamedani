package Stacks;

public class MinStack {
    private Stack minStack = new Stack();
    private Stack stack = new Stack();

    public void push(int i) {
        stack.push(i);
        if (minStack.isEmpty() || minStack.peek() > i)
            minStack.push(i);
    }

    public int pop() {
        var top = stack.pop();
        if (minStack.peek() == top)
            minStack.pop();
        return top;
    }

    public int min() {
        return minStack.peek();
    }
}
