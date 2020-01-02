package Rotation;

/**
 * RotateMatrixRingAntiClockWiseByK
 */
public class RotateMatrixRingAntiClockWiseByK {

    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int M = 4;
        int N = 4;
        int K = 3;
        spiralRotate(mat, M, N, K);
        printMatrix(mat, M, N);
    }

    private static void spiralRotate(int[][] mat, int M, int N, int K) {
        int RS = 0;
        int CS = 0;
        int RE = M - 1;
        int CE = N - 1;
        int traversed = 0;
        int [] tempArr = new int[M * N];
        int tCount = 0;
        while(traversed++ <= M*N) {
            int start = tCount;
            for(int i = CS; i <= CE; i++) {
                tempArr[tCount++] = mat[RS][i];
            }
            RS++;
            for(int i = RS; i <= RE; i++) {
                tempArr[tCount++] = mat[i][CE];
            }
            CE--;
            for(int i = CE; i >= CS; i--) {
                tempArr[tCount++] = mat[RE][i];
            }
            RE--;
            for(int i = RE; i >= RS; i--) {
                tempArr[tCount++] = mat[i][CS];
            }
            CS++;
            int end = tCount - 1;
            if((end - start) > K) {
                reverse(tempArr, start, start + K);
                reverse(tempArr, start + K, end);
                reverse(tempArr, start, end);
            }
        }
        fillSprial(mat, M, N, tempArr);
    }

    private static void fillSprial(int[][]mat , int M, int N, int[] tempArr) {
        int RS = 0;
        int CS = 0;
        int RE = M - 1;
        int CE = N - 1;
        int traversed = 0;
        int tCount = 0;
        while(traversed++ <= M*N) {
            for(int i = CS; i <= CE; i++) {
                mat[RS][i] = tempArr[tCount++];
            }
            RS++;
            for(int i = RS; i <= RE; i++) {
                mat[i][CE] = tempArr[tCount++];
            }
            CE--;
            for(int i = CE; i >= CS; i--) {
                mat[RE][i] = tempArr[tCount++];
            }
            RE--;
            for(int i = RE; i >= RS; i--) {
                mat[i][CS] = tempArr[tCount++];
            }
            CS++;
        }
    }

    private static void reverse(int arr[], int start, int end) {
        while(end > start) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
    private static void printMatrix(int[][] mat, int M, int N) {
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}