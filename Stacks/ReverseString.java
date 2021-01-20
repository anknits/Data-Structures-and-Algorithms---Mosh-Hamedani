package Stacks;

import java.util.Stack;

public class ReverseString {
    public String reverse(String input) {
        if (input == null)
            throw new IllegalArgumentException();
        Stack<Character> stack = new Stack<>();
        for (var ch : input.toCharArray())
            stack.push(ch);
        StringBuffer reversed = new StringBuffer();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
}