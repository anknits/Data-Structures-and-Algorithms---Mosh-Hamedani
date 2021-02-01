package Tries;

public class Main {
    public static void main(String[] args) {
        var trie = new Trie();
        trie.insert("can");
        trie.insert("egg");
        trie.insert("cane");
        trie.insert("china");
        trie.insert("canada");
        trie.insert("cannot");
        trie.insert("canelong");
        trie.remove("cannot");
        System.out.println(trie.containsRecursive("can"));
        System.out.println(trie.containsRecursive("cana"));
        System.out.println(trie.containsRecursive("canada"));
        System.out.println(trie.contains(Character.toString(Character.MIN_VALUE)));
        System.out.println(trie.containsRecursive(Character.toString(Character.MIN_VALUE)));
        System.out.println(trie.autoComplete(null));
        System.out.println(trie.countWords());
        String[] words1 = { "card", "care" };
        System.out.println(trie.longestCommonPrefix(words1));
        String[] words2 = { "car", "care" };
        System.out.println(trie.longestCommonPrefix(words2));
        String[] words3 = { "card", "dog" };
        System.out.println(trie.longestCommonPrefix(words3));
        String[] words4 = { "car" };
        System.out.println(trie.longestCommonPrefix(words4));
    }
}
