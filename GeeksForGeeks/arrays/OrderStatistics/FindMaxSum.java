package OrderStatistics;

/**
 * FindMaxSum
 */
public class FindMaxSum {

  public static void main(String[] args) {
    int arr[] = new int[] { 5, 5, 10, 100, 10, 5 };
    System.out.println(findMaxSum(arr, arr.length));
  }

  public static int findMaxSum(int[] arr, int n){
    int include  = arr[0];
    int exclude = 0;
    int newExclude;
    for(int i = 0; i < n; i++) {
      newExclude = include > exclude ? include : exclude;
      include = exclude + arr[i];
      exclude = newExclude;
    }
    return include > exclude ? include : exclude;
  }
}