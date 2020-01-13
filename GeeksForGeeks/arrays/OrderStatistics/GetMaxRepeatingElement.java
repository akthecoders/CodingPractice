package OrderStatistics;

/**
 * GetMaxRepeatingElement
 */
public class GetMaxRepeatingElement {

  public static void main(String[] args) {
    int arr[] = { 2, 3, 3, 5, 3, 4, 1, 7 };
    int n = arr.length;
    int k = 8;
    System.out.println("Maximum repeating element is: " + maxRepeating(arr, n, k));
  }

  public static int maxRepeating(int[] arr, int n, int k) {
    int result = 0;
    int index = 0;
    for(int i = 0; i < n; i++) {
      arr[arr[i] % k] += k;
    }
    for(int i = 0; i < n; i++) {
      if(arr[i] > result) {
        result = arr[i];
        index = i;
      }
    }
    return index;
  }
}