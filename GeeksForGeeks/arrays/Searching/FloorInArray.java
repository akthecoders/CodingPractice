package Searching;

/**
 * FloorInArray
 */
public class FloorInArray {

  public static void main(String[] args) {
    int arr[] = {1, 2, 4, 6, 10, 12, 14}; 
    int n = arr.length; 
    int x = 7; 
    int index = floorSearch(arr, 0, n-1, x);if(index==-1)System.out.println("Floor of "+x+" doesn't exist in array");else System.out.println("floor of "+x+" is "+arr[index]); 
  }

  public static int floorSearch(int[] arr, int low, int high , int x) {
    if (low > high) 
      return -1; 
    int mid;
    if(x >= arr[high]) {
      return high;
    }
    
    mid = (low + high) / 2;
    if(arr[mid] == x) {
      return mid;
    }
    if(mid > 0 && arr[mid - 1] <= x && x < arr[mid]) {
      return mid - 1;
    }
    if(arr[mid] > x) {
      return floorSearch(arr, low, mid - 1, x);
    }
    return floorSearch(arr, mid + 1, high, x);
    
  }
}