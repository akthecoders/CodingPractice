package RangeQueries;

/**
 * FenwickTree
 */
public class FenwickTree {

  public static void main(String[] args) {
    int input[] = {1,2,3,4,5,6,7};
    int binaryIndexedTree[] = createFenWickTree(input);
    System.out.println(getSum(binaryIndexedTree, 4));
  }

  public static int[] createFenWickTree(int[] input) {
    int binaryIndexedTree[] = new int[input.length + 1];
    for(int i = 1; i < input.length; i++) {
      updateBinaryIndexedTree(binaryIndexedTree, input[i - 1], i);
    }
    return binaryIndexedTree;
  }

  public static void updateBinaryIndexedTree(int[] binaryIndexedTree, int data, int index) {
    while(index < binaryIndexedTree.length) {
      binaryIndexedTree[index] += data;
      index = getNext(index);
    }
  }

  public static int getNext(int index) {
    return index + (index & -index);
  }

  public static int getSum(int[] binaryIndexedTree, int index) {
    index = index + 1;
    int sum = 0;
    while(index > 0) {
      sum += binaryIndexedTree[index];
      index = getParent(index);
    }
    return sum;
  }

  public static int getParent(int index){
    return index - (index & -index);
  }
}