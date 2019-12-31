package Rotation;

/**
 * RotateMatrix180
 */
public class RotateMatrix180 {

    public static void main(String args[]) {
        int[][] mat = { { 1, 2, 3 }, 
                        { 4, 5, 6 }, 
                        { 7, 8, 9 } }; 
  
        rotateMatrix(mat);
        printMatrix(mat); 
    }

    private static void rotateMatrix(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
        transpose(matrix);
        reverse(matrix);
    }

    private static void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { 
            for (int j = i; j < matrix.length; j++) { 
                int t = matrix[i][j]; 
                matrix[i][j] = matrix[j][i]; 
                matrix[j][i] = t; 
            } 
        } 
    }

    private static void reverse(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0, k = matrix.length - 1; j < k; j++, k--) { 
                int t = matrix[j][i]; 
                matrix[j][i] = matrix[k][i]; 
                matrix[k][i] = t; 
            } 
        }
    }

    private static void printMatrix(int[][] matrix) {
        for( int i = 0; i < matrix.length; i++) {
            for( int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}