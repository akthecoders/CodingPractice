package Searching;

import java.util.Arrays;

/**
 * Find4Pair
 */
public class Find4Pair {

  public static void main(String[] args) {
    int A[] = {1, 4, 45, 6, 10, 12}; 
    int n = A.length; 
    int X = 21; 
    find4Numbers(A, n, X); 
  }

  public static void find4Numbers(int[] arr, int n, int X) {
    int l, r;
    Arrays.sort(arr);
    for(int i = 0; i < n - 3; i++ ) {
      for(int j = i + 1; j < n-2; j++) {
        l = j + 1;
        r = n - 1;
        while(l < r) {
          if(arr[i] + arr[j] + arr[l] + arr[r] == X) {
            System.out.println(arr[i] + ", " + arr[j] + ", " + arr[l] + ", " + arr[r]);
            l++;
            r--;
          }
          else if(arr[i] + arr[j] + arr[l] + arr[r] < X) {
            l++;
          }
          else {
            r--;
          }
        }
      }
    }  
  }
}