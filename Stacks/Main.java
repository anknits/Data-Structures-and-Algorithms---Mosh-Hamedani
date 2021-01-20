package Stacks;

public class Main {
    public static void main(String[] args) {
        var reverseString = new ReverseString();
        var reversed = reverseString.reverse("abc");
        System.out.println(reversed);
        var balancedExpressions = new BalancedExpressions();
        var balanced = balancedExpressions.isBalanced("(str+12-/<>{[})");
        System.out.println(balanced);
        var stack = new Stack();
        stack.push(3);
        stack.push(3);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.toString());
        var twoStacks = new TwoStacks(5);
        twoStacks.push1(10);
        twoStacks.push1(11);
        twoStacks.push2(22);
        System.out.println(twoStacks.toString());
        System.out.println(twoStacks.peek1());
        System.out.println(twoStacks.pop2());
        System.out.println(twoStacks.toString());
    }
}