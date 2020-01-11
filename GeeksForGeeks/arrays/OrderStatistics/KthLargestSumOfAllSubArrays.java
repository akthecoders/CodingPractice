package OrderStatistics;

/**
 * KthLargestSumOfAllSubArrays
 */
public class KthLargestSumOfAllSubArrays {

  public static void main(String[] args) {
    int[] arr = {20, -5, -1};
    int k = 3;
    System.out.println("Kth Sum : " + getKthLargestSum(arr, k));
  }

  public static int getKthLargestSum(int[] arr, int k) {
    MaxPriorityQueue queue = new MaxPriorityQueue();
    for(int i = 0; i < arr.length; i++) {
      for(int j = i; j < arr.length; j++) {
        queue.insertElement(getSum(arr, i , j));
      }
    }
    for(int i = 0; i < k - 1; i++) {
      queue.removeElement();
    }
    return queue.getMax();
  }

  public static int getSum(int[] arr, int start, int end) {
    if(start == end) {
      return arr[start];
    }
    int sum = 0;
    for(int i = start; i <= end; i++) {
      sum += arr[i];
    }
    return sum;
  }
}