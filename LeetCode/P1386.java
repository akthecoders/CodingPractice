import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//Cinema Seat Allocation
public class P1386 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        int fourFamilies = 2 * n;
        int m = reservedSeats.length;
        for (int i = 0; i < m; i++) {
            int row = reservedSeats[i][0];
            int col = reservedSeats[i][1];
            if (!map.containsKey(row)) {
                map.put(row, new HashSet<Integer>());
            }
            map.get(row).add(col);
        }

        for (Map.Entry<Integer, HashSet<Integer>> itr : map.entrySet()) {
            HashSet<Integer> set = itr.getValue();
            int decremented = 0;
            if (set.contains(2) || set.contains(3) || set.contains(4) || set.contains(5)) {
                decremented++;
                fourFamilies--;
            }

            if (set.contains(6) || set.contains(7) || set.contains(8) || set.contains(9)) {
                decremented++;
                fourFamilies--;
            }

            if (!set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7)) {
                if (decremented == 2)
                    fourFamilies++;
            }
        }
        return fourFamilies;
    }
}