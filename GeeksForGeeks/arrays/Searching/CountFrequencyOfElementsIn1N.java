package Searching;

/**
 * CountFrequencyOfElementsIn1N
 */
public class CountFrequencyOfElementsIn1N {

  public static void main(String[] args) {
    int arr[] = {2, 3, 3, 2, 5}; 
    findCounts(arr, arr.length); 
  }

  public static void findCounts(int[] arr, int n) {
    int i = 0;
    while(i < n) {
      if(arr[i] <= 0) {i++; continue;}
      int elementIndex = arr[i] - 1;
      if(arr[elementIndex] > 0) {
        arr[i] = arr[elementIndex];
        arr[elementIndex] = -1;
      }
      else {
        arr[elementIndex]--;
        arr[i++] = 0;
      }
    }

    System.out.println("Below are counts of all elements"); 
    for (int j = 0; j < n; j++) 
      System.out.println(j+1 + "->" + Math.abs(arr[j])); 
  }
}