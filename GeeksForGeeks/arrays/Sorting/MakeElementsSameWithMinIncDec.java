package Sorting;

import java.util.Arrays;

/**
 * MakeElementsSameWithMinIncDec
 */
public class MakeElementsSameWithMinIncDec {

    public static void main(String[] args) {
        int a[] = {3, 1, 1}; 
        int b[] = {1, 2, 2}; 
        int n = a.length; 
        System.out.println(MinOperation(a, b, n));
    }

    public static int MinOperation(int[] arr, int[] arr2, int n) {
        Arrays.sort(arr);
        Arrays.sort(arr2);
        int result = 0;
        for(int i = 0; i < n; i++) {
            result += Math.abs(arr[i] - arr2[i]);
        }
        return result;
    }
}