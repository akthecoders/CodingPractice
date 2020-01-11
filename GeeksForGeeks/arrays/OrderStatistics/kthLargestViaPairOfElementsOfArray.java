package OrderStatistics;

/**
 * kthLargestViaPairOfElementsOfArray
 */
public class kthLargestViaPairOfElementsOfArray {

  public static void main(String[] args) {
    int[] A = { 1, 4, 2, 3 }; 
    int[] B = { 2, 5, 1, 6 }; 
    int K = 4; 
    KMaxCombinations(A, B, K); 
  }

  public static void KMaxCombinations(int[] A, int[] B, int K) {
    MaxPriorityQueue queue = new MaxPriorityQueue();
    for(int i = 0; i < A.length; i++) {
      for(int j = 0; j < B.length; j++) {
        queue.insertElement(A[i] + B[j]);
      }
    }
    for(int i = 0 ; i < K; i++) {
      System.out.println(queue.getMax());
      queue.removeElement();
    }
  }
}