// Cells with Odd Values in a Matrix

public class P1252 {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] ret = new int[n][m];

        for (int[] p : indices) {
            incRow(ret, p[0]);
            incCol(ret, p[1]);
        }

        int res = 0;
        for (int[] p : ret) {
            for (int x : p) {
                if (x % 2 == 1) {
                    res++;
                }
            }
        }

        return res;
    }

    public void incCol(int[][] indices, int p) {
        for (int i = 0; i < indices.length; i++) {
            indices[i][p]++;
        }
    }

    public void incRow(int[][] indices, int p) {
        for (int i = 0; i < indices[p].length; i++) {
            indices[p][i]++;
        }
    }
}