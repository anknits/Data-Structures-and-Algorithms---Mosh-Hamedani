package Stacks;

import java.util.*;

public class TwoStacks {
    public int[] arr;
    int count1;
    int count2;

    public TwoStacks(int capacity) {
        arr = new int[capacity];
        count1 = 0;
        count2 = capacity - 1;
    }

    public void push1(int i) {
        if (isArrayFull())
            throw new IllegalStateException();
        arr[count1++] = i;
    }

    public void push2(int i) {
        if (isArrayFull())
            throw new IllegalStateException();
        arr[count2--] = i;
    }

    public int pop1() {
        if (isEmpty1())
            throw new NoSuchElementException();
        return arr[--count1];
    }

    public int pop2() {
        if (isEmpty2())
            throw new NoSuchElementException();
        return arr[++count2];
    }

    public int peek1() {
        if (isEmpty1())
            throw new NoSuchElementException();
        return arr[count1 - 1];
    }

    public int peek2() {
        if (isEmpty2())
            throw new NoSuchElementException();
        return arr[count2 + 1];
    }

    public boolean isEmpty1() {
        return count1 == 0;
    }

    public boolean isEmpty2() {
        return count2 == arr.length;
    }

    public boolean isFull1() {
        return isArrayFull();
    }

    public boolean isFull2() {
        return isArrayFull();
    }

    private boolean isArrayFull() {
        return count2 - count1 == 1;
    }

    @Override
    public String toString() {
        var newArr1 = Arrays.copyOfRange(arr, 0, count1);
        var newArr2 = Arrays.copyOfRange(arr, count2, arr.length);
        return Arrays.toString(newArr1) + Arrays.toString(newArr2);
    }
}
