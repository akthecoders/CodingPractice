package OrderStatistics;

/**
 * MaxDifference
 */
public class MaxDifference {

  public static void main(String[] args) {
    int arr[] = { 1, 2, 90, 10, 110 };
    int size = arr.length;
    System.out.println("MaximumDifference is " + maxDiff(arr, size));
  }

  public static int maxDiff(int[] arr, int n) {
    int minElement = arr[0];
    int maxDiff = arr[1] - arr[0];
    for(int i = 1; i < n; i++) {
      if(arr[i] - minElement > maxDiff) {
        maxDiff = arr[i] - minElement;
      }
      if(arr[i] < minElement) {
        minElement = arr[i];
      }
    }
    return maxDiff;
  }
}