package Searching;

/**
 * Count1sInBinaryArray
 */
public class Count1sInBinaryArray {

  public static void main(String[] args) {
    int arr[] = { 1, 1, 1, 1, 0, 0, 0 };
    int n = arr.length;
    System.out.println("Count of 1's in given array is " + countOnes(arr, 0, n - 1));
  }

  public static int countOnes(int[] arr, int start, int end) {
    if(end < start) {
      return 0;
    }
    int mid = (start + end) / 2;
    if((arr[mid] == 1 && ((mid + 1) == end || (arr[mid + 1]) == 0))) {
      return mid + 1;
    }
    else if((arr[mid - 1]) == 1 && arr[mid] == 0) {
      return mid;
    }

    if(arr[mid] == 0) {
      return countOnes(arr, start, mid - 1);      
    }
    else {
      return countOnes(arr, mid + 1, end);
    }
  }
}