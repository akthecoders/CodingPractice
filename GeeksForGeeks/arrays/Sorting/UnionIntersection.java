package Sorting;

/**
 * UnionIntersection
 */
public class UnionIntersection {

  public static void main(String[] args) {
    int arr1[] = {1, 2, 4, 5, 6};
    int arr2[] = {2, 3, 5, 7};
    printUnion(arr1, arr2);
    System.out.println();
    printIntersection(arr1, arr2);
  }
  public static void printUnion(int[] arr1, int[] arr2) {
    int p1 = 0;
    int p2 = 0;
    while(p1 < arr1.length && p2 < arr2.length) {
      if(arr1[p1] < arr2[p2]) {
        System.out.print(arr1[p1++] + " ");
      }
      else if (arr1[p1] > arr2[p2]) {
        System.out.print(arr2[p2++] + " ");
      }
      else {
        System.out.print(arr1[p1] + " ");
        p1++;
        p2++;
      }
    }
  }

  public static void printIntersection(int[] arr1, int[] arr2) {
    int p1 = 0;
    int p2 = 0;
    while(p1 < arr1.length && p2 < arr2.length) {
      if(arr1[p1] < arr2[p2]) {
        p1++;
      }
      else if (arr1[p1] > arr2[p2]) {
        p2++;
      }
      else {
        System.out.print(arr1[p1] + " ");
        p1++;
        p2++;
      }
    }
  }
}