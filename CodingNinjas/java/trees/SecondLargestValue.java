package trees;

/**
 * SecondLargestValue
 */
class L2Node {
  TreeNode<Integer> largest = null;
  TreeNode<Integer> secondLargest = null;
}

public class SecondLargestValue {
  public static TreeNode<Integer> getSecondLargestNode(TreeNode<Integer> root) {
    L2Node result = helper(root);
    return result.secondLargest;
  }

  private static L2Node helper(TreeNode<Integer> root) {
    L2Node result = new L2Node();
    result.largest = root;

    for(int i = 0; i < root.children.size(); i++) {
      L2Node tNode = helper(root.children.get(i));
      if(result.largest == null) {
        result = tNode;
      } 
      else {
        if(result.largest.data < tNode.largest.data) {
            if(tNode.secondLargest != null && result.largest.data < tNode.secondLargest.data) {
              result.secondLargest = tNode.secondLargest;
            }
            else {
              result.secondLargest = result.largest;
            }
            result.largest = tNode.largest;
        }
        else {
          if(result.secondLargest == null) {
            if(tNode.largest.data != result.largest.data) { 
              result.secondLargest = tNode.largest;
            }
          }
          else if(result.secondLargest.data < tNode.largest.data) {
            result.secondLargest = tNode.largest;
          }
        }
      }
    }
    return result;
  }
}