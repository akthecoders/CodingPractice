package OrderStatistics;

/**
 * FindMaxElementInArrayIncreaseDecrease
 */
public class FindMaxElementInArrayIncreaseDecrease {

  public static void main(String[] args) {
    int arr[] = { 1, 3, 50, 10, 9, 7, 6 };
    int n = arr.length;
    System.out.println("The maximum element is " + findMaximum(arr, 0, n - 1));
  }

  public static int findMaximum(int[] arr, int start, int end) {
    if(start == end) {
      return arr[start];
    }
    if((end == start + 1) && arr[start] >= arr[end]) {
      return arr[start];
    }
    
    if((end == start + 1) && arr[end] > arr[start]) {
      return arr[end];
    }

    int mid = (start + end) / 2;

    if((arr[mid] > arr[mid + 1]) && (arr[mid] > arr[mid - 1])) {
      return arr[mid];
    }
    if(arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) {
      return findMaximum(arr, start, mid - 1);
    }
    else {
      return findMaximum(arr, mid + 1, end);
    }
  }
}