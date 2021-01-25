package HashTables;

import java.util.Arrays;

public class HashMap {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    private Entry[] entries = new Entry[5];
    private int count;

    public void put(int key, String value) {
        int i = 0;
        while (i < entries.length) {
            var position = index(key, i);
            if (entries[position] == null) {
                entries[position] = new Entry(key, value);
                count++;
                return;
            } else if ((entries[position]).key == key) {
                (entries[position]).value = value;
                return;
            }
            i++;
        }
        if (isFull())
            throw new IllegalStateException();
    }

    public String get(int key) {
        int i = 0;
        while (i < entries.length) {
            var position = index(key, i);
            if (entries[position] != null && (entries[position]).key == key) {
                return (entries[position]).value;
            }
            i++;
        }
        return null;
    }

    public void remove(int key) {

        int i = 0;
        while (i < entries.length) {
            var position = index(key, i);
            if (entries[position] != null && (entries[position]).key == key) {
                entries[position] = null;
                return;
            }
            i++;
        }
        throw new IllegalStateException();
    }

    public int size() {
        return count;
    }

    private boolean isFull() {
        return count == entries.length;
    }

    private int index(int key, int i) {
        return (hash(key) + i) % entries.length;
    }

    private int hash(int key) {
        return key % entries.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(entries);
    }

}