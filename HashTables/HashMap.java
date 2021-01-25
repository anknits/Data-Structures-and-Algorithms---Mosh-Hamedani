package HashTables;

public class HashMap{
    private class Entry{
        private int key;
        private String value;

        public Entry(int key, String value){
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry> entries = new LinkedList[5];

    public void put(int key, String value){
        var position = hash(key);
        while(entries[position] != null) 
            position++;
        entries[position] = new Entry(key, value);
    }

    public String get(int key){
        var position = hash(key);
        while(entries[position] == null || (entries[position]).key != key) 
            position++;
        return (entries[position]).value;
    }

    public void remove(int key){
        var position = hash(key);
        while(entries[position] == null || (entries[position]).key != key) 
            position++;
        entries[position] = null;
    }

    private int hash(int key) {
        return key % entries.length;
    }
}