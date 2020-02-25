package Searching;
import java.util.Arrays;

/**
 * MaxDiff
 */
public class MaxDiff {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 }; 
        int n = arr.length; 
        int m = 4; 
        System.out.print(find_difference(arr, n, m)); 
    }

    public static int find_difference(int[] arr, int n, int m) {
        Arrays.sort(arr);
        int min = 0 ;
        int max = 0;

        for(int i = 0, j = n - 1; i < m;i++, j--) {
            min += arr[i];
            max += arr[j];
        }
        return max - min;
    }
}