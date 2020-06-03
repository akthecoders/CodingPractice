import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Diagonal Traverse II
public class P1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int total = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                if (!map.containsKey(i + j)) {
                    map.put(i + j, new ArrayList<>());
                }
                map.get(i + j).add(nums.get(i).get(j));
                total++;
            }
        }
        int result[] = new int[total];
        int ind = 0;
        for (int i = 0; i < map.size(); i++) {
            for (int j = map.get(i).size() - 1; j >= 0; j--) {
                result[ind++] = map.get(i).get(j);
            }
        }
        return result;
    }
}