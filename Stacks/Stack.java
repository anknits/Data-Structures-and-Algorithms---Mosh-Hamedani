package Stacks;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Stack {
    private int[] arr;
    private int count;

    public Stack() {
        count = 0;
        arr = new int[1];
    }

    public void push(int i) {
        if (count == arr.length) {
            int[] newArray = new int[count * 2];
            for (int j = 0; j < count; j++)
                newArray[j] = arr[j];
            arr = newArray;
        }
        arr[count++] = i;
    }

    public int pop() {
        if (count <= 0)
            throw new NoSuchElementException();
        return arr[count--];
    }

    public int peek() {
        if (count <= 0)
            throw new NoSuchElementException();
        return arr[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        var newArr = Arrays.copyOfRange(arr, 0, count);
        return Arrays.toString(newArr);
    }

}
