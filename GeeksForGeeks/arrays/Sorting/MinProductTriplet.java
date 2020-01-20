package Sorting;

import java.util.Arrays;

/**
 * MinProductTriplet
 */
public class MinProductTriplet {

    public static void main(String[] args) {
        long arr[] = { 1, 3, 3, 4 }; 
        int n = arr.length; 
          
        System.out.print(noOfTriples(arr, n)); 
    }

    public static long noOfTriples(long arr[], int n) {
        Arrays.sort(arr);
        long count = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == arr[2]) {
                count++;
            } 
        }
        if(arr[0] == arr[2]) {
            return (count - 2) * (count - 1 ) * (count) / 6;
        }
        else if(arr[1] == arr[2]) {
            return (count - 1) * (count) / 2;
        }
        return count;
    }
}