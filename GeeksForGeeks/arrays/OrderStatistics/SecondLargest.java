package OrderStatistics;

/**
 * SecondLargest
 */
public class SecondLargest {

  public static void main(String[] args) {
    int arr[] = { 12, 35, 1, 10, 34, 1 };
    int n = arr.length;
    print2largest(arr, n);
  }

  public static void print2largest(int[] arr, int n) {
    int l = Integer.MIN_VALUE;
    int ll = Integer.MIN_VALUE;

    for(int i = 0; i < n; i++) {
      if(arr[i] > l) {
        ll = l;
        l = arr[i];
      }
      else if(arr[i] > ll) {
        ll = arr[i];
      }
    }
    System.out.println(ll);
  }
}