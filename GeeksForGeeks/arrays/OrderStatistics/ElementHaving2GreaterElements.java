package OrderStatistics;

/**
 * ElementHaving2GreaterElements
 */
public class ElementHaving2GreaterElements {

  public static void main(String[] args) {
    int arr[] = { 2, -6, 3, 5, 1}; 
    int n = arr.length; 
    findElements(arr, n); 
  }

  public static void findElements(int[] arr, int n) {
    int first = Integer.MIN_VALUE;
    int second = Integer.MIN_VALUE;

    for(int i = 0; i < n; i++) {
      if(arr[i] > first) {
        second = first;
        first = arr[i];
      }
      else if(arr[i] > second) {
        second = arr[i];
      }
    }

    for (int i : arr) {
      if(i < second) {
        System.out.println(i + " ");
      }
    }
  }
}