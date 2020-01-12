package OrderStatistics;

import java.util.Arrays;

/**
 * MaxDiffBetweenGroupOfKElementsAndRestArray
 */
public class MaxDiffBetweenGroupOfKElementsAndRestArray {

    public static void main(String[] args) {
        int arr[] = {1, 7, 4, 8, -1, 5, 2, 1}; 
        int n = arr.length; 
        int k = 3; 
          
        System.out.println("Maximum Difference = " + maxDiff(arr, n, k)); 
    }

    public static long maxDiff(int[] arr, int n, int k){
        Arrays.sort(arr);
        long arraySum = arraySum(arr, n);
        long diff1 = Math.abs(arraySum - 2 *arraySum(arr, k));
        int end = arr.length - 1; 
        int start = 0; 
        while (start < end) 
        { 
            int temp = arr[start];  
            arr[start] = arr[end]; 
            arr[end] = temp; 
            start++; 
            end--; 
        } 
        long diff2 = Math.abs(arraySum - 2 *arraySum(arr, k));
        return Math.max(diff1, diff2);   
    }

    public static long arraySum(int arr[], int n) 
    { 
        long sum = 0; 
        for (int i = 0; i < n; i++) 
            sum = sum + arr[i]; 
              
        return sum; 
    } 
}