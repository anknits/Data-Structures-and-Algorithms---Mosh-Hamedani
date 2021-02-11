package StringManipulation;

import java.util.*;

public class StringUtils {
    public static int countVowels(String str) {
        if (str == null)
            return 0;
        int count = 0;
        String vowels = "aeiou";
        for (char c : str.toLowerCase().toCharArray())
            if (vowels.indexOf(c) != -1)
                count++;
        return count;
    }

    public static String reverse(String str) {
        if (str == null)
            return "";
        var sb = new StringBuilder();
        for (var i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static String reverseWords(String str) {
        if (str == null)
            return "";
        var words = str.trim().split(" ");
        var sb = new StringBuilder();
        for (var i = words.length - 1; i >= 0; i--)
            sb.append(words[i] + " ");
        return sb.toString().trim();
    }

    public static String reverseWords2(String str) {
        if (str == null)
            return "";
        var words = str.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static boolean rotation(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;
        if (str1.length() != str2.length())
            return false;
        // return (str1+str1).contains(str2);
        for (var i = 0; i < str1.length(); i++)
            if (str1.equals(rotate(str2, i)))
                return true;
        return false;
    }

    private static String rotate(String str, int n) {
        var sb = new StringBuilder();
        for (var i = 0; i < str.length(); i++)
            sb.append(str.charAt((i + n) % str.length()));
        return sb.toString();
    }

    public static String removeDuplicates(String str) {
        if (str == null)
            return "";
        Set<Character> set = new HashSet<>();
        var sb = new StringBuilder();
        for (var ch : str.toCharArray()) {
            if (!set.contains(Character.toLowerCase(ch))) {
                set.add(Character.toLowerCase(ch));
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static Character findMostRepeatedCharacter(String str) {
        if (str == null)
            return ' ';
        Map<Character, Integer> frequencies = new HashMap<>();
        int max = 0;
        char maxChar = Character.MIN_VALUE;
        for (var ch : str.toCharArray()) {
            var c = Character.toLowerCase(ch);
            if (frequencies.get(c) != null)
                frequencies.put(c, frequencies.get(c) + 1);
            else
                frequencies.put(c, 1);
            if (frequencies.get(c) > max) {
                max = frequencies.get(c);
                maxChar = c;
            }
        }
        return maxChar;
    }

    public static Character findMostRepeatedCharacterUsingArray(String str) {
        if (str == null)
            return ' ';
        int[] frequencies = new int[256];
        int max = 0;
        char maxChar = Character.MIN_VALUE;
        for (var ch : str.toCharArray()) {
            ch = Character.toLowerCase(ch);
            frequencies[ch]++;
            if (frequencies[ch] > max) {
                max = frequencies[ch];
                maxChar = ch;
            }
        }
        return maxChar;
    }

    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.trim().isEmpty())
            return "";
        var words = str.trim().replaceAll(" +", " ").split(" ");
        for (var i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        return String.join(" ", words);
    }

    public static boolean areAnagrams(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;
        Map<Character, Integer> frequencies = new HashMap<>();
        for (var ch : str1.toLowerCase().toCharArray()) {
            if (frequencies.get(ch) == null)
                frequencies.put(ch, 1);
            else
                frequencies.put(ch, frequencies.get(ch) + 1);
        }
        for (var ch : str2.toLowerCase().toCharArray()) {
            if (frequencies.get(ch) == null || frequencies.get(ch) == 0)
                return false;
            else
                frequencies.put(ch, frequencies.get(ch) - 1);
        }
        for (var fr : frequencies.values())
            if (fr != 0)
                return false;
        return true;
    }

    public static boolean areAnagramsUsingSorting(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;
        var first = str1.toLowerCase().toCharArray();
        Arrays.sort(first);
        var second = str2.toLowerCase().toCharArray();
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }

    public static boolean isPalindrome(String str) {
        if (str == null)
            return false;
        int i = 0, j = str.length() - 1;
        while (i < j)
            if (str.toLowerCase().charAt(i) != str.toLowerCase().charAt(j))
                return false;
        return true;
    }
}
