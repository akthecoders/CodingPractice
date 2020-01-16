package RangeQueries;

import java.util.Arrays;

/**
 * CountArrayElement
 */
public class CountArrayElement {

    public static void main(String[] args) {
        int arr[] = { 1, 4, 4, 9, 10, 3 }; 
        int n = arr.length; 
      
        // Preprocess array 
        Arrays.sort(arr); 
      
        // Answer queries 
        int i = 1, j = 4; 
        System.out.println( countInRange(arr, n, i, j)); ; 
      
        i = 9; 
        j = 12; 
        System.out.println( countInRange(arr, n, i, j)); 
    }

    public static int countInRange(int[] arr, int n, int x, int y) {
        int count = 0;
        count = upperIndex(arr, n, y) - lowerIndex(arr, n, x) + 1;
        return count;
    }

    public static int upperIndex(int[] arr, int n, int y) {
        int l = 0; int h = n - 1;
        while(l <= h) {
            int mid = (l + h) / 2;
            if(arr[mid] <= y) {
                l = mid + 1;
            }
            else {
                h = mid - 1;
            }
        }
        return h;
    }

    public static int lowerIndex(int[] arr, int n, int x) {
        int l = 0; int h = n - 1;
        while(l <= h) {
            int mid = (l + h) / 2;
            if(arr[mid] <= x) {
                l = mid + 1;
            }
            else {
                h = mid - 1;
            }
        }
        return l;
    }
}