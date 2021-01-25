package HashTables;

public class Main {
    public static void main(String[] args) {
        var finder = new CharFinder();
        char ch = finder.FindFirstNonRepeatingCharacter("a green apple");
        System.out.println(ch);
        char c = finder.FindFirstRepeatingCharacter("green apple");
        System.out.println(c);
        char cmax = finder.FindMostFrequentCharacter("green apple");
        System.out.println(cmax);

        HashTable table = new HashTable();
        table.put(6, "A");
        table.put(8, "B");
        table.put(11, "C");
        table.put(6, "A+");
        System.out.println(table.get(6));
        System.out.println(table.get(8));
        System.out.println(table.get(10));
        System.out.println(table.get(11));
        table.remove(8);
        System.out.println(table.get(8));
    }
}
