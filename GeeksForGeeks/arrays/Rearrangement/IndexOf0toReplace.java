package Rearrangement;

/**
 * IndexOf0toReplace
 */
public class IndexOf0toReplace {

    public static void main(String[] args) {
        int arr[] = { 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1 };
        int n = arr.length;
        System.out.println("Index of 0 to be replaced is " + maxOnesIndex(arr, n));
    }

    public static int maxOnesIndex(int[] arr, int n) {
        int maxCount = 0;
        int prevZero = -1;
        int prevPrevZero = -1;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                if (i - prevPrevZero > maxCount) {
                    maxCount = i - prevPrevZero;
                    maxIndex = prevZero;
                }

                prevPrevZero = prevZero;
                prevZero = i;
            }
        }
        if (n - prevPrevZero > maxCount) {
            maxIndex = prevZero;
        }
        return maxIndex;
    }
}