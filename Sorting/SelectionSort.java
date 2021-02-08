package Sorting;

public class SelectionSort {
    public void sort(int[] array) {
        for (var i = 0; i < array.length; i++) {
            var minIndex = findIndexOfMinimum(array, i);
            swap(array, i, minIndex);
        }
    }

    private int findIndexOfMinimum(int[] array, int startIndex) {
        int minIndex = startIndex;
        for (var i = startIndex; i < array.length; i++) {
            if (array[i] < array[minIndex])
                minIndex = i;
        }
        return minIndex;
    }

    private void swap(int[] array, int a, int b) {
        var temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}