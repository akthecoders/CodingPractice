//Maximize Distance to Closest Person
public class P849 {
    public int maxDistToClosest(int[] seats) {
        int first = -1;
        int second = 0;
        int max = 0;
        while (first < seats.length && second < seats.length) {
            if (seats[second] != 1) {
                second++;
            } else if (seats[second] == 1) {
                if (first == -1 && second > 0) {
                    max = Math.max(max, second);
                    first = second;
                } else if (first == -1 && second == 0) {
                    first = 0;
                } else if (first != -1) {
                    int pivot = first + (second - first) / 2;
                    int dist = Math.min(Math.abs(first - pivot), Math.abs(pivot - second));
                    max = Math.max(max, dist);
                    first = second;
                }
                second++;
            }
        }
        if (second >= seats.length && first < seats.length) {
            int dist = seats.length - first - 1;
            max = Math.max(max, dist);
        }
        return max;
    }
}