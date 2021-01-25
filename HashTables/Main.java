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

        HashMap map = new HashMap();
        map.put(6, "A");
        map.put(8, "B");
        map.put(11, "C");
        map.put(6, "A+");
        System.out.println(map.get(6));
        System.out.println(map.get(8));
        System.out.println(map.get(10));
        System.out.println(map.get(11));
        map.remove(8);
        System.out.println(map.get(8));
    }
}
