package Rotation;

/**
 * RotateMatrix90Degree
 */
public class RotateMatrix90Degree {

    public static void main(String args[]) {
        int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int N = 4;
        rotate90Clockwise(arr, N);
        printMatrix(arr, N);
    }

    public static void rotate90Clockwise(int[][] input, int N) {
        for(int i = 0; i < N / 2; i++) {
            for(int j = i; j < N - i - 1; j++) {
                int temp = input[i][j]; 
                input[i][j] = input[N - 1 - j][i]; 
                input[N - 1 - j][i] = input[N - 1 - i][N - 1 - j]; 
                input[N - 1 - i][N - 1 - j] = input[j][N - 1 - i]; 
                input[j][N - 1 - i] = temp; 
            }
         }
    }

    public static void printMatrix(int arr[][], int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}