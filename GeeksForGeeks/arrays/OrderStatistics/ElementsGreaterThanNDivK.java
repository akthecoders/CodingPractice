package OrderStatistics;

/**
 * ElementsGreaterThanNDivK
 */
public class ElementsGreaterThanNDivK {

  public static void main(String[] args) {
    int arr[] = { 4, 5, 6, 7, 8, 4, 4 };
    int k = 4;
    moreThanK(arr, k);
  }

  public static void moreThanK(int[] arr, int k) {
    if (k < 2)
      return;
    Pair[] counted = new Pair[k - 1];
    for (int i = 0; i < k - 1; i++) {
      counted[i] = new Pair();
      counted[i].count = 0;
    }
    int j;
    for (int i = 0; i < arr.length; i++) {
      for (j = 0; j < k - 1; j++) {
        if (counted[j].element == arr[i]) {
          counted[j].count++;
          break;
        }
      }
      if (j == k - 1) {
        int l;
        for (l = 0; l < k - 1; l++) {
          if (counted[l].count == 0) {
            counted[l].element = arr[i];
            counted[l].count++;
            break;
          }
        }
        if (l == k - 1) {
          for (l = 0; l < k - 1; l++) {
            counted[l].count--;
          }
        }
      }
    }
    for (int i = 0; i < k - 1; i++) {
      int ac = 0;
      for (j = 0; j < arr.length; j++) {
        if (arr[j] == counted[i].element) {
          ac++;
        }
      }
      if (ac > arr.length / k) {
        System.out.println("Num : " + counted[i].element + " Count : " + ac);
      }
    }
  }
}

class Pair {
  int element;
  int count;
}