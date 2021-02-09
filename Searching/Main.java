package Searching;

public class Main {
    public static void main(String[] args) {
        Search search = new Search();
        // int[] numbers = { 7, 6, 2, 9, 3, 8, 1, 3 };
        // var index = search.linearSearch(numbers, 10);
        int[] numbers = { 1, 2, 3, 3, 6, 7, 8, 9 };
        // var index = search.binarySearchRecursive(numbers, 5);
        // var index = search.binarySearchIterative(numbers, 7);
        // var index = search.ternarySearch(numbers, 5);
        // var index = search.jumpSearch(numbers, 2);
        var index = search.exponentialSearch(numbers, 7);
        System.out.println(index);
    }
}
