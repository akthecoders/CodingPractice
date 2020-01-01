package Rotation;

/**
 * TurnImage90Degree
 */
public class TurnImage90Degree {

    public static void main(String[] args) {
        int m = 3;
        int n = 4;
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
    
        matrix = rotateBy90Degree(matrix, m , n);
        printMatrix(matrix);
    }

    private static int[][] rotateBy90Degree(int[][] matrix, int m, int n) {
        int[][] mat = new int[n][m];
        int nt = 0;
        int mt = 0;
        for(int j = 0; j < n; j++) {
            nt = 0;
            for(int i = m - 1; i >= 0; i--) {
                mat[mt][nt++] = matrix[i][j];
            }
            mt++;
        }
        return mat;
    }

    private static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}

