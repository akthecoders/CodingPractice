import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//Two City Scheduling
public class P1029 {
    private class IntervalComparator implements Comparator<int[]> {
        public int compare(int A[], int B[]) {
            return Math.abs(B[0] - B[1]) - Math.abs(A[0] - A[1]);
        }
    }

    public int twoCitySchedCost(int[][] costs) {
        Collections.sort(Arrays.asList(costs), new IntervalComparator());
        int sum = 0;
        int countA = 0;
        int countB = 0;
        int n = costs.length / 2;
        for (int i = 0; i < costs.length; i++) {
            if (countA < n && countB < n) {
                if (costs[i][0] < costs[i][1]) {
                    countA++;
                    sum += costs[i][0];
                } else {
                    countB++;
                    sum += costs[i][1];
                }
            } else if (countA < n) {
                countA++;
                sum += costs[i][0];
            } else if (countB < n) {
                countB++;
                sum += costs[i][1];
            }
        }
        return sum;
    }
}