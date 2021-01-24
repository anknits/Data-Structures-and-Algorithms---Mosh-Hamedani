package HashTables;

public class Main {
    public static void main(String[] args) {
        var finder = new CharFinder();
        char ch = finder.FindFirstNonRepeatingCharacter("a green apple");
        System.out.println(ch);
        char c = finder.FindFirstRepeatingCharacter("green apple");
        System.out.println(c);
    }
}
