package OrderStatistics;

/**
 * FindLargestelement
 */
public class FindLargestelement {

  public static void main(String[] args) {
    int[] arr = {10, 20, 4};
    System.out.println(getLargestElement(arr));
  }

  public static int getLargestElement(int[] arr) {
    int max = arr[0];
    for(int i = arr.length - 1; i >= 0 ; i--) {
      if(max < arr[i]) {
        max = arr[i];
      }
    }
    return max;
  }
}