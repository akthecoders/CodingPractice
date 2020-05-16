//Image Smoother
public class P661 {
    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0)
            return M;
        int[][] result = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++)
            for (int j = 0; j < M[i].length; j++)
                result[i][j] = getValue(i, j, M);
        return result;
    }

    private int getValue(int i, int j, int[][] M) {
        int numerator = 0;
        int denominator = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                int newX = i + x;
                int newY = j + y;
                if (!isOutOfBounds(newX, newY, M)) {
                    denominator++;
                    numerator += M[newX][newY];
                }
            }
        }
        return (int) numerator / denominator;
    }

    private boolean isOutOfBounds(int x, int y, int[][] M) {
        return (x < 0 || x >= M.length || y < 0 || y >= M[x].length);
    }
}