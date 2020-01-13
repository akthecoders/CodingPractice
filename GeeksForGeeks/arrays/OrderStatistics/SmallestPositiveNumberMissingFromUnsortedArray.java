package OrderStatistics;

import java.util.Arrays;

/**
 * SmallestPositiveNumberMissingFromUnsortedArray
 */
public class SmallestPositiveNumberMissingFromUnsortedArray {

  public static void main(String[] args) {
    int A[] = { 0, 10, 2, -10, -20 };
    System.out.println(solution(A));
  }

  public static int solution(int[] arr) {
    int m = Arrays.stream(arr).max().getAsInt();
    if (m < 1) {
      return 1;
    }
    if (arr.length == 1) {
      if (arr[0] == 1) {
        return 2;
      } else {
        return 1;
      }
    }
    int i = 0;
    int[] tAry = new int[m];
    for (i = 0; i < arr.length; i++) {
      if (arr[i] > 0) {
        if (tAry[arr[i] - 1] != 1) {
          tAry[arr[i] - 1] = 1;
        }
      }
    }
    for (i = 0; i < tAry.length; i++) {
      if (tAry[i] == 0) {
        return i + 1;
      }
    }
    return i + 2;
  }
}