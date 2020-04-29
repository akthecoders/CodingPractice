// Count Negative Numbers in a Sorted Matrix
public class P1351 {
    public int countNegatives(int[][] grid) {
        int res = 0;
        for (int r[] : grid) {
            for (int x : r) {
                if (x < 0) {
                    res++;
                }
            }
        }

        return res;
    }
}