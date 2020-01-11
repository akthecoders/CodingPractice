package OrderStatistics;

/**
 * KSmallestPair
 */
public class KSmallestPair {

  public static void main(String[] args) {
    int arr1[] = { 1, 3, 11 };
    int n1 = arr1.length;

    int arr2[] = { 2, 4, 8 };
    int n2 = arr2.length;

    int k = 4;
    kSmallestPair(arr1, n1, arr2, n2, k);
  }

  static void kSmallestPair(int arr1[], int n1, int arr2[], int n2, int k) {
    if (k > n1 * n2) {
      System.out.print("k pairs don't exist");
      return;
    }

    int index2[] = new int[n1];
    while (k > 0) {
      int minSum = Integer.MAX_VALUE;
      int minIndex = 0;

      for (int i = 0; i < n1; i++) {
        if (index2[i] < n2 && arr1[i] + arr2[index2[i]] < minSum) {
          minIndex = i;
          minSum = arr1[i] + arr2[index2[i]];
        }
      }
      System.out.print("(" + arr1[minIndex] + ", " + arr2[index2[minIndex]] + ") ");

      index2[minIndex]++;
      k--;
    }
  }
}