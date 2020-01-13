package OrderStatistics;

/**
 * MaxSumPathInTwoArrays
 */
public class MaxSumPathInTwoArrays {

  public static void main(String[] args) {
    int ar1[] = { 2, 3, 7, 10, 12, 15, 30, 34 };
    int ar2[] = { 1, 5, 7, 8, 10, 15, 16, 19 };
    int m = ar1.length;
    int n = ar2.length;
    System.out.println("Maximum sum path is :" + maxPathSum(ar1, ar2, m, n));
  }

  public static int maxPathSum(int[] arr1, int[] arr2, int m, int n) {
    int result = 0;
    int i = 0;
    int j = 0;
    int sum1 = 0;
    int sum2 = 0;

    while (i < m && j < n) {
      if (arr1[i] < arr2[j]) {
        sum1 += arr1[i++];
      } else if (arr1[i] > arr2[j]) {
        sum2 += arr2[j++];
      } else {
        result += max(sum1, sum2);
        sum1 = 0;
        sum2 = 0;
        while (i < m && j < n && arr1[i] == arr2[j]) {
          result += arr1[i++];
          j++;
        }
      }
    }
    while (i < m)
      sum1 += arr1[i++];

    while (j < n)
      sum2 += arr2[j++];

    result += max(sum1, sum2);
    return result;
  }

  public static int max(int x, int y) {
    return (x > y) ? x : y;
  }
}