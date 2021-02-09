package Searching;

public class Search {
    public int linearSearch(int[] array, int target) {
        for (var i = 0; i < array.length; i++)
            if (array[i] == target)
                return i;
        return -1;
    }

    public int binarySearchRecursive(int[] array, int target) {
        return binarySearchRecursive(array, 0, array.length - 1, target);
    }

    private int binarySearchRecursive(int[] array, int start, int end, int target) {
        if (start >= end)
            return -1;
        var middle = (start + end) / 2;
        if (array[middle] == target)
            return middle;
        else if (array[middle] > target)
            return binarySearchRecursive(array, start, middle - 1, target);
        else
            return binarySearchRecursive(array, middle + 1, end, target);
    }

    public int binarySearchIterative(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (array[middle] > target)
                end = middle - 1;
            else if (array[middle] < target)
                start = middle + 1;
            else
                return middle;
        }
        return -1;
    }

    public int ternarySearch(int[] array, int target) {
        return ternarySearch(array, 0, array.length - 1, target);
    }

    private int ternarySearch(int[] array, int start, int end, int target) {
        if (start >= end)
            return -1;
        var partition = (end - start) / 3;
        var middle1 = start + partition;
        var middle2 = end - partition;
        if (array[middle1] == target)
            return middle1;
        else if (array[middle2] == target)
            return middle2;
        else if (array[middle1] > target)
            return ternarySearch(array, start, middle1 - 1, target);
        else if (array[middle2] < target)
            return ternarySearch(array, middle2 + 1, end, target);
        else
            return ternarySearch(array, middle1 + 1, middle2 - 1, target);
    }

    public int jumpSearch(int[] array, int target) {
        int len = array.length;
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int next = start + blockSize;
        while (start < len && array[next - 1] < target) {
            start = next;
            next += blockSize;
            if (next > len)
                next = len;
        }
        for (; start < next; start++)
            if (array[start] == target)
                return start;
        return -1;
    }

    public int exponentialSearch(int[] array, int target) {
        var bound = 1;
        while (bound < array.length && array[bound] < target)
            bound *= 2;
        var left = bound / 2;
        var right = Math.min(bound, array.length);
        return binarySearchRecursive(array, left, right, target);
    }
}
