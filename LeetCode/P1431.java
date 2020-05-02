import java.util.ArrayList;
import java.util.List;

// Kids With the Greatest Number of Candies
public class P1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies.length < 1)
            return null;
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (max < candies[i]) {
                max = candies[i];
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}