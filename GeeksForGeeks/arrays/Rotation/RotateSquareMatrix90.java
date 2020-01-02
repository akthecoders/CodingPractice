package Rotation;

/**
 * RotateSquareMatrix90
 */
public class RotateSquareMatrix90 {

    public static void main(String[] args) {
        int N = 4;
        int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        rotateMatrix(N, mat);
        displayMatrix(N, mat);
    }

    private static void rotateMatrix(int N, int[][] mat) {
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][N - 1 - i];
                mat[j][N - 1 - i] = mat[N - 1 - i][N - 1 - j];
                mat[N - 1 - i][N - 1 - j] = mat[N - 1 - j][i];
                mat[N - 1 - j][i] = temp;
            }
        }
    }

    private static void displayMatrix(int N, int mat[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }
}