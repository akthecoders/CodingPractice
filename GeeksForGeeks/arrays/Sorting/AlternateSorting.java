package Sorting;

import java.util.Arrays;

/**
 * AlternateSorting
 */
public class AlternateSorting {

  public static void main(String[] args) {
    int arr[] = {7, 1, 2, 3, 4, 5, 6};
    sortAlternate(arr);
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

  public static void sortAlternate(int[] arr) {
    Arrays.sort(arr);
    int temp[] = new int[arr.length];
    int j = arr.length - 1;
    int i = 0;
    for(int k = 0; k < arr.length; k++) {
      temp[k++] = arr[j--];
      if(i < arr.length && k < arr.length)
      temp[k] = arr[i++];
    }
    int count = 0;
    for (int k : temp) {
      arr[count++] = k;
    }
  }
}