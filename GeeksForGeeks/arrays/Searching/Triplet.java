package Searching;

import java.util.HashSet;

/**
 * Triplet
 */
public class Triplet {

  public static void main(String[] args) {
    int A[] = { 1, 4, 45, 6, 10, 8 };
    int sum = 22;
    int arr_size = A.length;

    find3Numbers(A, arr_size, sum);
  }

  public static void find3Numbers(int[] arr, int n, int sum) {
    for(int i = 0; i < n - 2; i++) {
      HashSet<Integer> set = new HashSet<>();
      int currSum = sum - arr[i];
      for(int j = i + 1; j < n; j++) {
        if(set.contains(currSum - arr[j]) && currSum - arr[j] != (int)set.toArray()[set.size() - 1]) {
          System.out.println("Pair : " + arr[i] + " + " + arr[j] + " + " + (currSum - arr[j]));
        }
        set.add(arr[j]);
      }
    }
  }
}