package Rearrangement;

import java.util.Arrays;

/**
 * MergeKSortedArray
 */
public class MergeKSortedArray {

    public static void main(String[] args) {
        int[][] arr= {{2, 6, 12, 34}, 
                {1, 9, 20, 1000}, 
                {23, 34, 90, 2000}}; 
  
        System.out.println("Merged array is :"); 
  
        mergeKSortedArrays(arr,arr.length, arr[0].length); 
    }

    public static void mergeKSortedArrays(int[][] arr, int m, int n) {
        int tAry[] = new int[m*n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                tAry[count++] = arr[i][j];
            }
        }
        Arrays.sort(tAry);
        for (int i : tAry) {
            System.out.print(i + " ");
        }
    }
}