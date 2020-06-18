import java.util.HashMap;
import java.util.Map;

//Rabbits in Forest
public class P781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : answers) {

            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int sum = 0;
        for (Integer k : map.keySet()) {
            if (k == 0) {
                sum += map.get(k);
            } else {
                if (map.get(k) % (k + 1) == 0) {
                    sum += (map.get(k) / (k + 1)) * (k + 1);
                } else {
                    sum += (map.get(k) / (k + 1)) * (k + 1) + (k + 1);
                }
            }

        }
        return sum;

    }
}