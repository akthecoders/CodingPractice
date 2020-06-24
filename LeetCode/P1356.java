import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//Sort Integers by The Number of 1 Bits
public class P1356 {
    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (int n : arr) {
            int num = n;
            int c = 0;
            while (n > 0) {
                c = c + (n & 1);
                n = n >> 1;
            }
            if (map.containsKey(c)) {
                List<Integer> l = (ArrayList<Integer>) map.get(c);
                l.add(num);
                map.put(c, l);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(num);
                map.put(c, l);
            }
        }
        int in = 0;
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            List<Integer> l = (ArrayList<Integer>) e.getValue();
            Collections.sort(l);
            for (int i : l) {
                arr[in] = i;
                in++;
            }
        }
        return arr;
    }
}