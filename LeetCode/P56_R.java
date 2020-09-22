import java.util.Arrays;
import java.util.LinkedList;

// Merge Intervals
public class P56_R {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (intervals == null || n == 0)
            return intervals;

        // Sorting the intervals based on the start time.
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
        });

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }

            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
