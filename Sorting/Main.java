package Sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = { 7, 6, 2, 9, 3, 8, 1, 3 };
        // var sorter = new BubbleSort();
        // var sorter = new SelectionSort();
        // var sorter = new InsertionSort();
        // var sorter = new MergeSort();
        // var sorter = new QuickSort();
        // var sorter = new CountSort();
        var sorter = new BucketSort();
        sorter.sort(numbers, 9);
        System.out.println(Arrays.toString(numbers));
    }
}