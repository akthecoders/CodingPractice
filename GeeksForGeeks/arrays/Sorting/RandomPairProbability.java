package Sorting;

/**
 * RandomPairProbability
 */
public class RandomPairProbability {

  public static void main(String[] args) {
    int a[] = { 1, 2, 3 };
    int b[] = { 1, 3, 3 };

    int size1 = a.length;
    int size2 = b.length;

    System.out.println(probability(a, b, size1, size2));
  }

  public static double probability(int[] arr1, int[] arr2, int size1, int size2) {
    double result = 0.00;
    double max1 = findMax(arr1, size1);
    double max2 = findMax(arr2, size2);
    result = (double)(max1 * max2)/(size1 * size2);
    return result;
  }

  public static double findMax(int[] arr, int n) {
    int max = Integer.MIN_VALUE;
    int count = 0;
    for(int i = 0; i < n; i++) {
      if(max < arr[i]) {
        max = arr[i];
        count = 1;
      }
      else if(max == arr[i]) {
        count++;
      }
    }
    return count;
  }
}