package OrderStatistics;

/**
 * MinProductOfKElements
 */
public class MinProductOfKElements {

  public static void main(String[] args) {
    int arr[] = { 198, 76, 544, 123, 154, 675 };
    int k = 2;
    int n = arr.length;
    System.out.print("Minimum product is " + minProduct(arr, n, k));
  }

  public static int minProduct(int[] arr, int n , int k) {
    int product = 1;
    MinPriorityQueue queue = new MinPriorityQueue();
    for (int i : arr) {
      queue.insertData(i);
    }
    for(int i = 0; i < k; i++) {
      product *= queue.getMin();
      queue.removeElement();
    }
    return product;
  }
}