import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * P380
 * Insert Delete GetRandom O(1)
 */
public class P380 {

    List<Integer> list;
    Map<Integer, Integer> map;
    Random rand;

    public P380() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        list.add(val);
        map.put(val, list.size() - 1);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        Integer pos = map.remove(val);

        if (pos != null)
            list.set(pos, null);

        return pos != null;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int random = rand.nextInt(list.size());

        while (list.get(random) == null) {
            random = rand.nextInt(list.size());
        }
        return list.get(random);
    }
}