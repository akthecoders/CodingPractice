//Toeplitz Matrix
public class P766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int nRows = matrix.length;
        int nCol = matrix[0].length;

        for (int i = 1; i < nRows; i++) {
            for (int j = 1; j < nCol; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
            }
        }

        return true;
    }
}