//Rotate Image
// Revised
public class P48 {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length == 1)
            return;
        transpose(matrix);
        for (int[] arr : matrix)
            reverse(arr);
    }

    public void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}