package OrderStatistics;

/**
 * CountSmallerElementsOnRight
 */
public class CountSmallerElementsOnRight {

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 5 };
    int n = arr.length;
    countSmallerElementsOnRight(arr, n);
  }

  public static void countSmallerElementsOnRight(int[] arr, int n) {
    int small[] = new int[n];
    for (int i = 0; i < n; i++) {
      small[i] = 0;
      int smallNum = 0;
      for (int j = i; j < n; j++) {
        if (arr[j] < arr[i]) {
          smallNum++;
        }
      }
      small[i] = smallNum;
    }

    for (int i : small) {
      System.out.print(i + " ");
    }
  }
}