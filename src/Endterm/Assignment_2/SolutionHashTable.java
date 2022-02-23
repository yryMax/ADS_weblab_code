package Endterm.Assignment_2;
import java.util.*;

class Entry {

    private final String key;

    private final String value;

    public Entry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(key, entry.key) && Objects.equals(value, entry.value);
    }
}

abstract class HashTable {

    public Entry[] table;

    public int capacity;

    /**
     * Constructs a new HashTable.
     *
     * Capacity of the hash table can not be 0 or negative.
     *
     * @param capacity
     *     to be used as capacity of the table.
     * @throws IllegalArgumentException
     *     if the input capacity is invalid.
     */
    public HashTable(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity needs to be positive.");
        }
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }

    public Entry[] getTable() {
        return table;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * Add a new Entry to the hash table,
     * uses linear probing to deal with collisions.
     *
     * Returns false, if the key is null or the table is full.
     *
     * @param key
     *     String representing the key of the entry.
     * @param value
     *     String representing the value of the entry.
     * @return true iff entry has been added successfully, else false.
     */
    public boolean put(String key, String value) {
        if (key == null) {
            return false;
        }
        int h = hash(key);
        for (int i = 0; i < capacity; i++) {
            Entry e = table[(h + i) % capacity];
            if (e != null && e.getKey() == null) {
                // If a defunct value is found, we need to make sure the key doesn't exist elsewhere
                for (int j = 0; j < capacity - i; j++) {
                    Entry t = table[(h + i + j) % capacity];
                    if (t == null) {
                        // Key not found, no duplicate
                        break;
                    }
                    if (t.getKey() != null) {
                        if (t.getKey().equals(key)) {
                            // Found the key after some defunct values, replace
                            table[(h + i + j) % capacity] = new Entry(key, value);
                            return true;
                        } else {
                            // Found another key instead, so no duplicate
                            break;
                        }
                    }
                }
                // We only get here if we had no duplicate, so take the originally found defunct
                // spot
                table[(h + i) % capacity] = new Entry(key, value);
                return true;
            }
            if (e == null || e.getKey().equals(key)) {
                // Take the empty spot or replace the entry that was already there
                table[(h + i) % capacity] = new Entry(key, value);
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieve the value of the entry associated with this key.
     *
     * Returns null, if the key is null.
     *
     * @param key
     *     String representing the key of the entry to look for.
     * @return value of the entry as String iff the entry with this key is found in the hash table, else null.
     */
    public String get(String key) {
        if (key == null) {
            return null;
        }
        int h = hash(key);
        for (int i = 0; i < capacity; i++) {
            Entry e = table[(h + i) % capacity];
            if (e == null) {
                return null;
            } else if (e.getKey() == null) {
                continue;
            } else if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return null;
    }

    /**
     * Remove the entry associated with this key from the hash table.
     *
     * Returns false, if the key is null.
     *
     * @param key
     *     String representing the key of the entry to remove.
     * @return true iff the entry has been successfully removed, else false.
     */
    public abstract boolean remove(String key);

    /**
     * Takes as input an index and sets the entry in that location as defunct.
     *
     * @param index
     *     The index of the spot that is defunct.
     */
    public void setDefunct(int index) {
        this.table[index] = new Entry(null, null);
    }

    /**
     * Hashes a string representing a key.
     *
     * @param key
     *     String that needs to be hashed.
     * @return the hashcode of the string, modulo the capacity of the HashTable.
     */
    public int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}
class SolutionHashTable extends HashTable {

    /**
     * Constructs a new HashTable.
     * Do NOT change this method.
     */
    public SolutionHashTable(int capacity) {
        super(capacity);
    }

    /**
     * Remove the entry associated with this key from the hash table.
     *
     * Returns false if the key is null.
     *
     * @param key
     *     String representing the key of the entry to remove.
     * @return true iff the entry has been successfully removed, else false.
     */
    public boolean remove(String key) {
        // TODO
        if(key == null)return false;
        int ind = hash(key);
        for(int i=0;i<capacity;i++){
            int index = (ind+i)%capacity;
            if(table[index]==null)return false;
            if(key.equals(table[index].getKey())){
                setDefunct(index);
                return true;
            }
        }
        return false;
    }
}
