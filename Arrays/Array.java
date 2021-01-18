package dsa.Arrays;

public class Array {
    private int[] arr;
    private int count;

    public Array(int length) {
        arr = new int[length];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
    }

    public void insert(int i) {
        if (count == arr.length) {
            int[] newArray = new int[count * 2];
            for (int j = 0; j < count; j++)
                newArray[j] = arr[j];
            arr = newArray;
        }
        arr[count++] = i;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            return;
        for (int i = index; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }
        count--;
    }

    public int indexOf(int number) {
        for (int i = 0; i < count; i++) {
            if (arr[i] == number)
                return i;
        }
        return -1;
    }
}