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
}
