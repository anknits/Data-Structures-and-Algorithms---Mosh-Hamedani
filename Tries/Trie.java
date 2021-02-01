package Tries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Trie {
    private class Node {
        private Character value;
        private HashMap<Character, Node> children;
        private boolean isEndOfWord;

        public Node(Character ch) {
            value = ch;
            children = new HashMap<>();
            isEndOfWord = false;
        }

        @Override
        public String toString() {
            return "value = " + value;
        }

        public boolean hasChild(Character ch) {
            return children.containsKey(ch);
        }

        public void addChild(Character ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(Character ch) {
            if (!hasChild(ch))
                return null;
            return children.get(ch);
        }

        public void markEndOfWord() {
            isEndOfWord = true;
        }

        public void removeEndOfWord() {
            isEndOfWord = false;
        }

        public Collection<Node> getChildren() {
            return children.values();
        }

        public void removeChild(Character ch) {
            children.remove(ch);
        }
    }

    private final Node root;

    public Trie() {
        root = new Node(Character.MIN_VALUE);
    }

    public void insert(String word) {
        var current = root;
        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.markEndOfWord();
    }

    public boolean contains(String word) {
        if (word == null)
            throw new IllegalArgumentException();
        var current = root;
        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node root) {
        for (var child : root.getChildren())
            traverse(child);
        System.out.println(root.value);
    }

    public void remove(String word) {
        if (word == null || !contains(word))
            throw new IllegalArgumentException();
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.removeEndOfWord();
            return;
        }
        var ch = word.charAt(index);
        var child = root.getChild(ch);
        remove(child, word, index + 1);

        if (child.getChildren().isEmpty() && !child.isEndOfWord)
            root.removeChild(ch);
    }

    public List<String> autoComplete(String prefix) {
        List<String> words = new ArrayList<>();
        var root = findLastNodeOf(prefix);
        autoComplete(prefix, root, words);
        return words;
    }

    private Node findLastNodeOf(String prefix) {
        if (prefix == null)
            return null;
        var current = root;
        for (var ch : prefix.toCharArray()) {
            if (!current.hasChild(ch))
                return null;
            current = current.getChild(ch);
        }
        return current;
    }

    private void autoComplete(String word, Node root, List<String> words) {
        if (root == null)
            return;
        if (root.isEndOfWord)
            words.add(word);
        for (var child : root.getChildren())
            autoComplete(word + child.value, child, words);
    }

    public boolean containsRecursive(String word) {
        if (word == null)
            throw new IllegalArgumentException();
        return containsRecursive(root, word, 0);
    }

    private boolean containsRecursive(Node root, String word, int index) {
        if (index == word.length())
            return root.isEndOfWord;
        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null)
            return false;
        return containsRecursive(child, word, index + 1);
    }

    public int countWords() {
        return countWords(root);
    }

    private int countWords(Node root) {
        int count = 0;
        if (root == null)
            return 0;
        if (root.isEndOfWord)
            count++;
        for (var child : root.getChildren())
            count += countWords(child);
        return count;
    }

    public String longestCommonPrefix(String[] words) {
        if (words == null || words.length == 0)
            return "";
        var trie = new Trie();
        for (var word : words)
            trie.insert(word);
        var longestCommonPrefix = new StringBuilder();
        var current = trie.root;
        while (current.getChildren().size() == 1 && !current.isEndOfWord) {
            longestCommonPrefix.append(current.value);
            current = current.getChildren().iterator().next();
        }
        longestCommonPrefix.append(current.value);
        return longestCommonPrefix.toString().substring(1);
    }
}
