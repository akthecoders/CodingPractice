package Rotation;

/**
 * MatrixRotation
 */
public class MatrixRotation {

    public static void main(String args[]) {

        int matrix[][] = { { 12, 23, 34 }, { 45, 56, 67 }, { 78, 89, 91 } };
        int rotate = 2;
        int N = 3;
        rotateMatrix(matrix, rotate, N);
        printMatrix(matrix, N);
    }

    private static void rotateMatrix(int[][] matrix, int rotate, int N) {
        for(int i = 0; i < N; i++) {
            reverse(matrix[i], 0, N - 1);
            reverse(matrix[i], 0, rotate - 1);
            reverse(matrix[i], rotate, N - 1);
        }
    }

    
    private static void reverse(int[] input, int start, int end) {
        while(end > start) {
            int temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }

    private static void printMatrix(int[][] matrix, int N) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}