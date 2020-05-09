//The K Weakest Rows in a Matrix
public class P1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] sol = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                sol[i] += mat[i][j];
            }
        }

        int indexer = 0;
        int result[] = new int[k];
        while (k > 0) {
            int minIndex = 0;
            for (int i = 0; i < sol.length; i++) {
                if (sol[i] < sol[minIndex]) {
                    minIndex = i;
                }
            }

            result[indexer++] = minIndex;
            sol[minIndex] = Integer.MAX_VALUE;
            k--;
        }
        return result;
    }
}