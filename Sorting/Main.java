package Sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = { 7, 6, 2, 9, 3, 8, 1, 3 };
        // var sorter = new BubbleSort();
        // var sorter = new SelectionSort();
        var sorter = new InsertionSort();
        sorter.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
