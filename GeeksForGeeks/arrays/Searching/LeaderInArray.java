package Searching;

/**
 * LeaderInArray
 */
public class LeaderInArray {

  public static void main(String[] args) {
    int arr[] = new int[] { 16, 17, 4, 3, 5, 2 };
    int n = arr.length;
    printLeaders(arr, n);
  }

  public static void printLeaders(int[] arr, int n) {
    int max = arr[n-1];
    System.out.print(max + " ");
    for(int i = n - 2; i >= 0; i--) {
      if(max < arr[i]) {
        max = arr[i];
        System.out.print(max + " ");
      }
    }
  }
}