package OrderStatistics;

/**
 * KMaxSumOfNonOverlappingSubArray
 */
public class KMaxSumOfNonOverlappingSubArray {

  public static void main(String[] args) {
    int arr1[] = { 4, 1, 1, -1, -3, -5, 6, 2, -6, -2 };
    int k1 = 3;
    int n1 = arr1.length;
    kmax(arr1, k1, n1);
  }

  public static void kmax(int[] arr, int k, int n) {
    for (int i = 0; i < k; i++) {
      int maxSoFar = Integer.MIN_VALUE;
      int maxHere = 0;
      int start = 0;
      int end = 0;
      int s = 0;
      for (int j = 0; j < n; j++) {
        maxHere += arr[j];
        if (maxSoFar < maxHere) {
          maxSoFar = maxHere;
          start = s;
          end = j;
        }
        if (maxHere < 0) {
          maxHere = 0;
          s = j + 1;
        }
      }
      System.out.println("Maximum non-overlapping sub-arraysum" + (i + 1) + ": " + maxSoFar + ", starting index: "
            + start + ", ending index: " + end + ".");
        for (int l = start; l <= end; l++)
          arr[l] = Integer.MIN_VALUE;
    }
    System.out.println();
  }
}