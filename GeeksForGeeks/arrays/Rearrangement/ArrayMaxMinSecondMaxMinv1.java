package Rearrangement;

import java.util.Arrays;

/**
 * ArrayMaxMinSecondMaxMinv1
 */
public class ArrayMaxMinSecondMaxMinv1 {

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6 };

        System.out.println("Original Array ");
        System.out.println(Arrays.toString(arr));

        rearrange(arr, arr.length);

        System.out.println("Modified Array ");
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(int[] arr, int n) {
        int tempArry[] = new int[n];
        int counter = 0;
        for(int i = 0, j = n - 1; i < n /2 || j > n / 2; i++, j--) {
            
            if(counter < n) {
                tempArry[counter++] = arr[j];
            }
            if(counter < n) {
                tempArry[counter++] = arr[i];
            }
            
        }

        for(int i = 0 ;i < n ;i++) {
            arr[i] = tempArry[i];
        }
    }
}