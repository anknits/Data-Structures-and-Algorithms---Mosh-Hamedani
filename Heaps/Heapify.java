package Heaps;

public class Heapify {

    public int[] heapify(int[] numbers) {
        for (var i = numbers.length; i >= 0; i--) {
            heapify(numbers, i);
        }
        return numbers;
    }

    private void heapify(int[] numbers, int index) {
        var largerIndex = index;

        var leftIndex = index * 2 + 1;
        if (leftIndex < numbers.length && numbers[leftIndex] > numbers[largerIndex])
            largerIndex = leftIndex;

        var rightIndex = index * 2 + 2;
        if (rightIndex < numbers.length && numbers[rightIndex] > numbers[largerIndex])
            largerIndex = rightIndex;

        if (index == largerIndex)
            return;

        swap(numbers, index, largerIndex);
        heapify(numbers, largerIndex);
    }

    private void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
