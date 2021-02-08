package Sorting;

public class QuickSort {
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int start, int end) {
        if (start >= end)
            return;
        var boundary = partition(array, start, end);
        sort(array, start, boundary - 1);
        sort(array, boundary + 1, end);
    }

    private int partition(int[] array, int start, int end) {
        var pivot = end;
        var boundary = start - 1;
        for (var i = start; i <= end; i++)
            if (array[i] <= array[pivot])
                swap(array, i, ++boundary);
        return boundary;
    }

    private void swap(int[] array, int a, int b) {
        var temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

// the idea behind quick sort is to take a pivot, generally the last element of
// the array, and create 2 partitions: left and right. The left contains all
// items less than the pivot while the right contains all items greater the
// pivot. Essentially, the pivot moves to it's correct position in the array
// after partition. We recursively partition the left and right partitions.