package Sorting;

import java.util.Arrays;

/**
 * MnAbsoluteDifference
 */
public class MnAbsoluteDifference {

  public static void main(String[] args) {
    int arr[] = { 5, 10, 1, 4, 8, 7 };
    int n = arr.length;

    System.out.println("Sum = " + sumOfMinAbsDifferences(arr, n));
  }

  public static int sumOfMinAbsDifferences(int[] arr, int n) {
    Arrays.sort(arr);
    int sum = 0;
    sum += Math.abs(arr[0] - arr[1]);
    sum += Math.abs(arr[n-1] - arr[n-2]);

    for(int i = 1; i < n - 1; i++) {
      sum += Math.min(Math.abs(arr[i] - arr[i-1]), Math.abs(arr[i] - arr[i + 1]));
    }
    return sum;
  }
}