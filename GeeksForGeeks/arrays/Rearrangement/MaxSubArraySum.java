package Rearrangement;

/**
 * MaxSubArraySum
 */
public class MaxSubArraySum {

    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = arr.length;
        maxSum(arr, n);
    }

    public static void maxSum(int[] arr, int n) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndHere = 0;

        for(int i = 0; i < n; i++) {
            maxEndHere = maxEndHere + arr[i];
            if(maxSoFar < maxEndHere) {
                maxSoFar = maxEndHere;
            }
            if(maxEndHere < 0) {
                maxEndHere = 0;
            }

        }
        System.out.println(maxSoFar);
    }
}