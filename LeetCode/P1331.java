// Rank Transform of an Array
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] res = new int[arr.length];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < arr.length; ++i) {
            List<Integer> list = map.get(arr[i]);
            if (list == null) {
                list = new ArrayList<Integer>();
            }
            list.add(i);
            map.put(arr[i], list);
        }

        Arrays.parallelSort(arr);
        int index = 1;
        for (int i = 0; i < arr.length;) {
            List<Integer> list = map.get(arr[i]);
            if (list.size() == 1) {
                res[list.get(0)] = index;
            } else {
                for (int j : list) {
                    res[j] = index;
                }
            }
            index++;
            i += list.size();
        }

        return res;
    }
}