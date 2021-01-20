package Stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpressions {
    private List<Character> leftBrackets = Arrays.asList('(', '{', '[', '<');
    private List<Character> rightBrackets = Arrays.asList(')', '}', ']', '>');

    public boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (var ch : str.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);
            else if (isRightBracket(ch)) {
                if (stack.empty())
                    return false;
                if (!doBracketsMatch(stack.pop(), ch))
                    return false;
            }
        }
        return true;
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean doBracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
