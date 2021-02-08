package Sorting;

public class CountSort {
    public void sort(int[] array, int max) {
        var counts = new int[max + 1];
        for (var i = 0; i < array.length; i++) {
            if (array[i] > max)
                throw new IllegalArgumentException();
            counts[array[i]]++;
        }
        int k = 0;
        for (var i = 0; i < counts.length; i++)
            for (var j = 0; j < counts[i]; j++)
                array[k++] = i;
    }
}