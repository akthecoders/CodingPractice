package Searching;

import java.util.HashSet;

/**
 * TripletWithSumZero
 */
public class TripletWithSumZero {

  public static void main(String[] args) {
    int A[] = { 1, 0, -1, 2, -2, 5 };
    int arr_size = A.length;
    find3Numbers(A, arr_size);
  }

  public static void find3Numbers(int[] arr, int n) {
    for(int i = 0; i < n - 2; i++) {
      HashSet<Integer> set = new HashSet<>();
      for(int j = i + 1; j < n; j++) {
        int x = -(arr[i] + arr[j]);
        if(set.contains(x)) {
          System.out.println("Triplet : " + arr[i] + ", " + arr[j] + ", " + x );
        }
        set.add(arr[j]);
      }
    }
  }
}