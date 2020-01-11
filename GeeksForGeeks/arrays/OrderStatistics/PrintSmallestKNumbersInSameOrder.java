package OrderStatistics;

/**
 * PrintSmallestKNumbersInSameOrder
 */
public class PrintSmallestKNumbersInSameOrder {
  public static void main(String[] args) {
    int[] arr = { 1, 5, 8, 9, 6, 7, 3, 4, 2, 0 }; 
        int n = 10; 
        int k = 5; 
        printSmall(arr, n, k); 
  }

  public static void printSmall(int[] arr, int n, int k) {
    for(int i = k; i < n; ++i) {
      int max_var = arr[k-1];
      int pos = k - 1;
      for(int j = k - 2; j >= 0; j--) {
        if(max_var < arr[j] ) {
          pos = j;
          max_var = arr[j];
        }
      }

      if(max_var > arr[i]) {
        int j = pos;
        while(j < k - 1) {
          arr[j] = arr[j + 1];
          j++;
        }
        arr[k-1] = arr[i];
      }
    }
    for (int i = 0; i < k; i++) 
    System.out.print(arr[i] + " ");

  }
}