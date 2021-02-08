package Sorting;

import java.util.*;

public class BucketSort {
    public void sort(int[] array, int numberOfBuckets) {
        var i = 0;
        for (var bucket : createBuckets(array, numberOfBuckets)) {
            Collections.sort(bucket);
            for (var item : bucket)
                array[i++] = item;
        }
    }

    private List<List<Integer>> createBuckets(int[] array, int numberOfBuckets) {
        if (numberOfBuckets <= 0)
            throw new IllegalArgumentException();
        List<List<Integer>> buckets = new ArrayList<>();
        for (var i = 0; i <= numberOfBuckets; i++)
            buckets.add(new ArrayList<>());
        for (var item : array) {
            var index = (item / numberOfBuckets > numberOfBuckets) ? numberOfBuckets : item / numberOfBuckets;
            buckets.get(index).add(item);
        }
        return buckets;
    }
}