import java.util.ArrayList;
import java.util.List;

//Design HashMap
public class P706 {
    List<int[]>[] keys;
    int size = 1000;

    /** Initialize your data structure here. */
    @SuppressWarnings("unchecked")
    public P706() {
        keys = new List[size];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        List<int[]> list = keys[getHash(key)];
        if (list == null) {
            list = new ArrayList<>();
            keys[getHash(key)] = list;
        }

        for (int[] pair : list) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }

        list.add(new int[] { key, value });
    }

    int getHash(int key) {
        return key % size;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        List<int[]> list = keys[getHash(key)];
        if (list == null)
            return -1;
        for (int[] pair : list) {
            if (pair[0] == key)
                return pair[1];
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        List<int[]> list = keys[getHash(key)];
        if (list == null)
            return;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] == key) {
                list.remove(i);
                return;
            }
        }
    }
}