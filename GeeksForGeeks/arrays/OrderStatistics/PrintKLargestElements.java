package OrderStatistics;

/**
 * PrintKLargestElements
 */
public class PrintKLargestElements {

  public static void main(String[] args) {
    int arr[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 100};
    int k = 4;
    printKLargestElements(arr, k);  
  }

  public static void printKLargestElements(int[] arr, int k) {
    MaxPriorityQueue queue = new MaxPriorityQueue();
    for (int i : arr) {
      queue.insertElement(i);
    }
    for(int i = 0; i < k; i++) {
      System.out.println(queue.getMax());
      queue.removeElement();
    }
  }
}