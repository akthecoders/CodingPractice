package Sorting;

import java.util.HashMap;

/**
 * CountPairsWithDiffK
 */
public class CountPairsWithDiffK {

  public static void main(String[] args) {
    int arr[] = { 1, 5, 3, 4, 2 };
    int n = arr.length;
    int k = 3;
    System.out.println("Count of pairs with given diff is " + countPairsWithDiffK(arr, n, k));
  }

  public static int countPairsWithDiffK(int[] arr, int n, int k) {
    int count = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < n; i++) {
      if(map.containsKey(arr[i])) {
        map.put(arr[i], map.get(arr[i]) + 1 );
      }
      else {
        map.put(arr[i], 1);
      }
    }
    for(int i = 0; i < n; i++) {
      if(map.containsKey(arr[i] + k)) {
        count++;
      }
    }
      
    return count;
  }
}