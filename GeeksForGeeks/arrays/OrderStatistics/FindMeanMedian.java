package OrderStatistics;

import java.util.Arrays;

/**
 * FindMeanMedian
 */
public class FindMeanMedian {

  public static void main(String[] args) {
    int a[] = { 1, 3, 4, 2, 7, 5, 8, 6 };
    int n = a.length;
    System.out.println("Mean = " + findMean(a, n));
    System.out.println("Median = " + findMedian(a, n));
  }

  public static double findMean(int[] arr, int n) {
    double res = 0;
    for (int i : arr) {
      res += i;
    }
    return (double)(res/n);
  }

  public static double findMedian(int[] arr, int n) {
    Arrays.sort(arr);
    if (n % 2 != 0) 
    return (double)arr[n / 2]; 
  
    return (double)(arr[(n - 1) / 2] + arr[n / 2]) / 2.0; 
  }
}