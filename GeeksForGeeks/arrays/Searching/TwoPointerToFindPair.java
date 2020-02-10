package Searching;

/**
 * TwoPointerToFindPair
 */
public class TwoPointerToFindPair {

  public static void main(String[] args) {
    int arry[] = { 10, 20, 30, 40, 50};
    int n = arry.length;
    int x = 30;
    printPair(arry, n, x);
  }

  public static void printPair(int[] arr, int n, int x) {
    int i = 0;
    int j = n - 1;
    while(i < j) {
      if((arr[i] + arr[j]) == x) {
        System.out.println("Pair Exists");
        return;
      }
      else if((arr[i] + arr[j]) < x) {
        i++;
      }
      else {
        j--;
      }
    }
    System.out.println("No Pair exists");
  }
}