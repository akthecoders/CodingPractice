package Sorting;

import java.util.Arrays;
import java.util.Collections;

/**
 * MinDearrangementsinAP
 */
public class MinDearrangementsinAP {

  public static void main(String[] args) {
    int arr[] = {5, 9, 21, 17, 13};
    System.out.println(getMinDearrangements(arr));
  }

  public static int getMinDearrangements(int[] arr) {
    int count1 = 0;
    int count2 = 0;
    int copyArry[] = new int[arr.length];
    for(int i = 0; i < arr.length; i++) {
      copyArry[i] = arr[i];
    }

    Arrays.sort(arr);
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] != copyArry[i]) {
        count1++;
      }
    }
    Collections.reverse(Arrays.asList(arr));
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] != copyArry[i]) {
        count2++;
      }
    }
    return count1 < count2 ? count1 : count2;
  }
}
