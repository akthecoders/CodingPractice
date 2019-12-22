package trees;

/**
 * FindLargestSumNode
 */
class Nodesum {
  int sum;
  TreeNode<Integer> node;
  public Nodesum(TreeNode<Integer> node) {
    this.sum = 0;
    this.node = node;
  }
}

public class FindLargestSumNode {

  public static TreeNode<Integer> findLargestSumNode(TreeNode<Integer> root) {
    Nodesum result = helper(root);
    return result.node;
  }

  private static Nodesum helper(TreeNode<Integer> root) {
    Nodesum result = new Nodesum(root);
    int rootSum = root.data;
    
    for(int i = 0; i < root.children.size(); i++) {
      rootSum = root.children.get(i).data;
    }
    result.sum = rootSum;

    Nodesum newNode = null;
    for(int i = 0; i < root.children.size(); i++) {
      newNode = helper(root.children.get(i));
      if(newNode.sum > result.sum) {
        result = newNode;
      }
    }
    return result;
  }
}