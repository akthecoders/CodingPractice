//Capacity To Ship Packages Within D Days
public class P1011 {
    public int shipWithinDays(int[] weights, int D) {
        int min = 0, max, sum = 0;
        for (int w : weights) {
            sum += w;
            min = Math.max(w, min);
        }
        max = sum;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (possible(mid, weights) > D) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }

    private int possible(int capacity, int[] weights) {
        int sum = 0, days = 1;
        for (int w : weights) {
            sum += w;
            if (sum > capacity) {
                days++;
                sum = w;
            }
        }
        return days;
    }
}