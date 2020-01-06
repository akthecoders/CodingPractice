package Rearrangement;

import java.util.Arrays;

/**
 * SegregateZeroOne
 */
public class SegregateZeroOne {

    public static void main(String[] args) {
        int arr[] = new int[] { 0, 1, 0, 1, 1, 1 };
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        segregate0and1(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    public static void segregate0and1(int arr[], int n) {
        int start = 0, end = n - 1;
        while (end >= start) {
            while(arr[start] == 0 && start < end) {
                start++;
            }
            while(arr[end] == 0 && start < end) {
                end++;
            }

            if(start < end) {
                arr[start] = 0;
                arr[end] = 1;
                start++;
                end--;
            }
        }
    }
}