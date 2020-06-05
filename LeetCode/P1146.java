import java.util.HashMap;
import java.util.Map;

//Snapshot Array
public class P1146 {
    Map<Integer, Map<Integer, Integer>> map;
    int snaps = 0;

    public P1146(int length) {
        map = new HashMap<>();
        map.put(snaps, new HashMap<>());
    }

    public void set(int index, int val) {
        map.get(snaps).put(index, val);
    }

    public int snap() {
        snaps++;
        map.put(snaps, new HashMap<>());
        return snaps - 1;
    }

    public int get(int index, int snap_id) {
        if (snap_id < 0)
            return 0;
        Map<Integer, Integer> curr = map.get(snap_id);

        if (curr.containsKey(index)) {
            return curr.get(index);
        }

        return get(index, snap_id - 1);
    }
}