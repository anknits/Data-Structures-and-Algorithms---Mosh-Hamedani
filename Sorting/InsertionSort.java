package Sorting;

public class InsertionSort {
    public void sort(int[] array) {
        for (var i = 1; i < array.length; i++) {
            var current = array[i];
            var position = i;
            for (var j = i - 1; j >= 0; j--) {
                if (array[j] > current)
                    swap(array, j, position--);
            }
        }
    }

    private void swap(int[] array, int a, int b) {
        var temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}