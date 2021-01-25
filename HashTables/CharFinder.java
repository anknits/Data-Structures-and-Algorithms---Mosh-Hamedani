package HashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public char FindFirstNonRepeatingCharacter(String str) {
        Map<Character, Integer> map = new HashMap<>();
        var chars = str.toCharArray();
        for (char ch : chars) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }
        for (char c : chars)
            if (map.get(c) == 1)
                return c;
        return Character.MIN_VALUE;
    }

    public char FindFirstRepeatingCharacter(String str) {
        Set<Character> set = new HashSet<>();
        var chars = str.toCharArray();
        for (char ch : chars) {
            if (set.contains(ch))
                return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }

    public char FindMostFrequentCharacter(String str) {
        Character mostFrequentChar = Character.MIN_VALUE;
        int mostFrequentCount = -1;
        Map<Character, Integer> map = new HashMap<>();
        var chars = str.toCharArray();
        for (char ch : chars) {
            var count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
            if (count > mostFrequentCount) {
                mostFrequentCount = count;
                mostFrequentChar = ch;
            }
        }
        return mostFrequentChar;
    }

    public int CountPairsWithDifference(int[] numbers, int difference) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (var number : numbers) {
            set.add(number);
        }
        for (var number : numbers) {
            if (set.contains(number + difference))
                count++;
            if (set.contains(number - difference))
                count++;
            set.remove(number);
        }
        return count;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for (var number : numbers) {
            set.add(number);
        }
        // if we want to return indices, we can use something like this but
        // we need to write a method to find the index of complement
        // for (var i = 0; i < numbers.length; i++) {
        // int complement = target - numbers[i];
        // if (set.contains(complement)) {
        // arr[0] = i;
        // var list = java.util.Arrays.asList(numbers);
        // arr[1] = java.util.Arrays.asList(numbers).indexOf(complement);
        // return arr;
        // }
        // }
        // if we want to return the numbers
        for (var number : numbers) {
            if (set.contains(target - number)) {
                arr[0] = number;
                arr[1] = target - number;
                return arr;
            }
        }
        return null;
    }
}
