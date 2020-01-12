package OrderStatistics;

/**
 * MaxJISum
 */
public class MaxJISum {

  public static void main(String[] args) {
    int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
    int n = arr.length;
    int maxDiff = maxIndexDiff(arr, n);
    System.out.println(maxDiff);
  }

  public static int maxIndexDiff(int[] arr, int n){
    int maxDiff = -1;
    int i,j;
    int RMax[] = new int[n];
    int LMin[] = new int[n];

    LMin[0] = arr[0];
    for(i = 1; i < n; i++) {
      LMin[i] = min(arr[i], LMin[i - 1]);
    }

    RMax[0] = arr[0];
    for(j = 1; j < n; j++) {
      RMax[j] = max(arr[j], RMax[j - 1]);
    }

    i = 0; j = 0; maxDiff = -1;
    while(i < n && j < n) {
      if(LMin[i] < RMax[j]) {
        maxDiff = max(maxDiff, j - i);
        j = j + 1;
      }
      else {
        i = i + 1;
      }
    }
    return maxDiff;
   }

   public static int max(int x, int y) {
     return x > y ? x : y;
   }

   public static int min(int x, int y) {
    return x < y ? x : y;
  }
}