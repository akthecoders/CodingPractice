import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Design HashMap
public class P706 {
    class Pair<U, V> {
        public U key;
        public V value;

        public Pair(U k, V v) {
            this.key = k;
            this.value = v;
        }
    }

    class Bucket {
        private List<Pair<Integer, Integer>> bucket;

        public Bucket() {
            this.bucket = new LinkedList<>();
        }

        public Integer get(Integer key) {
            for (Pair<Integer, Integer> pair : this.bucket) {
                if (pair.key.equals(key))
                    return pair.value;
            }
            return -1;
        }

        public void update(Integer key, Integer value) {
            boolean found = false;
            for (Pair<Integer, Integer> pair : this.bucket) {
                if (pair.key.equals(key)) {
                    pair.value = value;
                    found = true;
                }
            }
            if (!found) {
                this.bucket.add(new Pair<Integer, Integer>(key, value));
            }
        }

        public void remove(Integer key) {
            for (Pair<Integer, Integer> pair : this.bucket) {
                if (pair.key.equals(key)) {
                    this.bucket.remove(pair);
                    break;
                }
            }
        }
    }

    private int keySpace;
    private List<Bucket> hashTable;

    /** Initialize your data structure here. */
    public P706() {
        this.keySpace = 2069;
        this.hashTable = new ArrayList<>();
        for (int i = 0; i < this.keySpace; ++i) {
            this.hashTable.add(new Bucket());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = key % this.keySpace;
        this.hashTable.get(hashKey).update(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        int hashKey = key % this.keySpace;
        return this.hashTable.get(hashKey).get(key);
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        int hashKey = key % this.keySpace;
        this.hashTable.get(hashKey).remove(key);
    }
}