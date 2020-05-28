// Spiral Matrix II
public class P59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int ctr = 1;
        int f = n * n;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        while (ctr <= f) {
            for (int i = left; i <= right && ctr <= (f); i++) {
                res[top][i] = ctr;
                ctr++;
            }
            top++;
            for (int i = top; i <= bottom && ctr <= f; i++) {
                res[i][right] = ctr;
                ctr++;
            }
            right--;
            for (int i = right; i >= left && ctr <= f; i--) {
                res[bottom][i] = ctr;
                ctr++;
            }
            bottom--;
            for (int i = bottom; i >= top && ctr <= f; i--) {
                res[i][left] = ctr;
                ctr++;
            }
            left++;
        }
        return res;
    }
}