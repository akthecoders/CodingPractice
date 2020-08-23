//Spiral Matrix II
public class P59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int i = 0, j = n - 1;
        int k = 0, l = n - 1;
        int d = 1;

        while (i <= j && k <= l) {
            for (int r = i; r <= j; r++) {
                result[k][r] = d;
                d++;
            }
            k++;

            for (int c = k; c <= l; c++) {
                result[c][j] = d;
                d++;
            }
            j--;

            if (i <= j && k <= l) {
                for (int r = j; r >= i; r--) {
                    result[l][r] = d;
                    d++;
                }
                l--;
            }

            if (i <= j && k <= l) {
                for (int c = l; c >= k; c--) {
                    result[c][i] = d;
                    d++;
                }
                i++;
            }
        }
        return result;
    }
}