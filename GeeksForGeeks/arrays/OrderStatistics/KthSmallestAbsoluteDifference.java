package OrderStatistics;

import java.util.Arrays;

/**
 * KthSmallestAbsoluteDifference.
 */
public class KthSmallestAbsoluteDifference {

  public static void main(String[] args) {
    int k = 3;
    int a[] = { 1, 2, 3, 4 };
    int n = a.length;
    System.out.println(kthDiff(a, n, k));
  }

  public static int kthDiff(int[] arr, int n, int k) {
    Arrays.sort(arr);
    int minDiff = arr[1] - arr[0];
    for (int i = 2; i < n; i++) {
      if (minDiff > arr[i] - arr[i - 1]) {
        minDiff = arr[i] - arr[i - 1];
      }
    }
    int maxDiff = arr[n - 1] - arr[0];

    while (minDiff < maxDiff) {
      int mid = (minDiff + maxDiff) / 2;
      if (countPairs(arr, n, mid) < k) {
        minDiff = mid + 1;
      } else {
        maxDiff = mid;
      }
    }
    return minDiff;
  }

  public static int countPairs(int[] arr, int n, int mid) {
    int res = 0;
    for (int i = 0; i < n; i++) {
      res += Math.max(arr.length + i, Math.max(arr.length + n, arr[i] + mid)) - (arr.length + i + 1);
    }
    return res;
  }
}