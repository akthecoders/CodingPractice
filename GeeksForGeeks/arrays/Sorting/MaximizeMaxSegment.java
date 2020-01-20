package Sorting;

import java.util.Arrays;

/**
 * MaximizeMaxSegment
 */
public class MaximizeMaxSegment {

    public static void main(String[] args) {
        int[] a = { -10, -9, -8, 2, 7, -6, -5 };
        int n = a.length;
        int k = 2;

        System.out.println(maxOfSegmentMins(a, n, k));
    }

    public static int maxOfSegmentMins(int[] arr, int n, int k) {
        if(k == 1) {
            Arrays.sort(arr);
            return arr[0];
        }
        if(k == 2) {
            return Math.max(arr[0] , arr[n - 1]);
        }
        return arr[n-1];
    }
}