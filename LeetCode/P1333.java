import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//Filter Restaurants by Vegan-Friendly, Price and Distance
public class P1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        for (int[] restaurant : restaurants) {
            if (veganFriendly == 1) {
                if (restaurant[2] == 1 && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                    pQ.add(restaurant);
                }
            } else {
                if (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                    pQ.add(restaurant);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pQ.isEmpty()) {
            res.add(pQ.poll()[0]);
        }
        return res;
    }
}