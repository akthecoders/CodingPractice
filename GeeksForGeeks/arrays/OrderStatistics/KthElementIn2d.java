package OrderStatistics;

/**
 * KthElementIn2d
 */
public class KthElementIn2d {

  public static void main(String[] args) {
    int[][] arr = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 25, 29, 37, 48 }, { 32, 33, 39, 50 }, };
    System.out.println(kthSmallestElement(arr, 4, 7));
  }

  private static int kthSmallestElement(int[][] arr, int n, int k) {
      MinPriorityQueue queue = new MinPriorityQueue();
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
          queue.insertData(arr[i][j]);
        }
      }
      for(int i = 0; i < k - 1; i++) {
        queue.removeElement();
      }
      return queue.getMin();
  }

  
}