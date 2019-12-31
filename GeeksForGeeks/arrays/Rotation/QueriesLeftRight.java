package Rotation;

/**
 * QueriesLeftRight
 */
public class QueriesLeftRight {

    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int queries[][] = { { 1, 3 }, { 3, 0, 2 }, { 2, 1 }, { 3, 1, 4 } };
        int n = 5;

        processQueries(queries, arr, n);
    }

    private static void processQueries(int[][] queries, int[] arr, int n) {
        int rotate = 0;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for(int i = 1; i <=n; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }

        for(int i = 0; i < queries.length; i++) {
            if(queries[i][0] == 1) { rotate = rightRotate(rotate, queries[i][1]);}
            if(queries[i][0] == 2) { rotate = leftRotate(rotate, queries[i][1]);}
            if(queries[i][0] == 3) { printArray(rotate, arr, n, queries[i][1], queries[i][2], preSum);}
        }
    }

    private static void printArray(int rotate, int[] arr, int n, int l, int r, int[] preSum) {
        l = (l + rotate + n) % n;
        r = (r + rotate + n) % n;
        if(l <= r) {
            System.out.println(preSum[r + 1] - preSum[l]);
        }
        else {
            System.out.println(preSum[n] + preSum[r + 1] - preSum[l]);
        }
    }

    private static int rightRotate(int n, int times) {
        return n - times;
    }

    private static int leftRotate(int n, int times) {
        return n + times;
    }
}