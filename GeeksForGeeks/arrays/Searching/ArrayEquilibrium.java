package Searching;

/**
 * ArrayEquilibrium
 */
public class ArrayEquilibrium {

  public static void main(String[] args) { 
    int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
    int arr_size = arr.length;
    System.out.println("First equilibrium index is " + equilibrium(arr, arr_size));
  }

  public static int equilibrium(int[] arr, int n) {
    int leftSum = 0;
    int sum = 0;
    for(int i = 0; i < n; i++) {
      sum += arr[i];
    }

    for(int i = 0; i < n; i++) {
      sum -= arr[i];
      if(leftSum == sum) {
        return i;
      }
      leftSum += arr[i];
    }
    return -1;
  }
}