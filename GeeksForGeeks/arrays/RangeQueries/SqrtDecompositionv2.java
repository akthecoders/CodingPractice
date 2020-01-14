package RangeQueries;

/**
 * SqrtDecompositionv2
 */
public class SqrtDecompositionv2 {

  public static void main(String[] args) {
    int a[] = {1, 1, 2, 1, 3, 4, 5, 2, 8}; 
    int q[][] = {{0, 4}, {1, 3}, {2, 4}}; 
    sqrtDecompositionv2(a, q);
  }
  public static void sqrtDecompositionv2(int[] arr, int [][] query) {
    int blockSize = (int) Math.sqrt(arr.length);
    int[] block = new int[blockSize];
    for(int i = 0; i < arr.length; i++) {
      int blkIndex = 0;
      if(i % blockSize == 0) {
        blkIndex++;
      }
      block[blkIndex] += arr[i];
    }
    for(int i = 0; i < query.length; i++) {
      System.out.println("Sum of [" + query[i][0] + ", " + query[i][1] + "] - " + query(arr, query[i], block, blockSize));
    }
  }

  public static int query(int[] arr, int[] query, int[] block, int blockSize) {
    int L = query[0];
    int R = query[1];
    int sum = 0;
    while( (L < R) && (L % blockSize != 0) && (L != 0)) {
      sum += arr[L++];
    }
    while( (L+blockSize <= R)) {
      sum += block[L/blockSize];
      L += blockSize;
    }
    while(L <= R) {
      sum += arr[L++];
    }
    return sum;
  }
}