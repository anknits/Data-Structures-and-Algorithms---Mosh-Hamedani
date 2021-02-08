package Sorting;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] array) {
        if (array.length < 2)
            return;
        var middle = array.length / 2;
        var left = Arrays.copyOfRange(array, 0, middle);
        var right = Arrays.copyOfRange(array, middle, array.length);
        sort(left);
        sort(right);
        merge(left, right, array);
    }

    private void merge(int[] left, int[] right, int[] array) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                array[k++] = left[i++];
            else
                array[k++] = right[j++];
        }
        while (i < left.length)
            array[k++] = left[i++];
        while (j < right.length)
            array[k++] = right[j++];
    }
}