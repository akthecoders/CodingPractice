package OrderStatistics;

/**
 * ClosetPair
 */
public class ClosetPair {

  public static void main(String[] args) {
    int ar1[] = { 1, 4, 5, 7 };
    int ar2[] = { 10, 20, 30, 40 };
    int m = ar1.length;
    int n = ar2.length;
    int x = 38;
    printClosest(ar1, ar2, m, n, x);
  }

  public static void printClosest(int[] arr1, int[] arr2, int m, int n, int x) {
    int diff = Integer.MAX_VALUE;
    int res_l = 0, res_r = 0;
    int l = 0, r = n - 1;
    while (l < m && r >= 0) {
      if (Math.abs(arr1[l] + arr2[r] - x) < diff) {
        res_l = l;
        res_r = r;
        diff = Math.abs(arr1[l] + arr2[res_r] - x);
      }

      if (arr1[l] + arr2[r] > x) {
        r--;
      } else {
        l++;
      }
    }
    System.out.print("The closest pair is [" + arr1[res_l] + ", " + arr2[res_r] + "]");
  }
}