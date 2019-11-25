package trees;

/**
 * FindNextLargeElement
 */
public class FindNextLargeElement {

  public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
    TreeNode<Integer> res = null;
    if(root.data > n) {
        res = root;
    }
    return findNextLargeElementWithExtraParam(root, n, res);
  } 



  public static TreeNode<Integer> findNextLargeElementWithExtraParam(TreeNode<Integer> root, int n, TreeNode<Integer> res) {
    if(root == null) {
      return root;
    }
    if(root.data > n) {
      if(res == null) {
        res = root;
      }
      else if(root.data < res.data) {
        res = root;
      }

      for(int i = 0; i < root.children.size(); i++) {
        TreeNode<Integer> temp = findNextLargeElementWithExtraParam(root.children.get(i), n, res);
        if(temp != null) {
            if(temp.data > n) {
                if(res != null) {
                    if(temp.data < res.data) {
                        res = temp;
                    }
                }
                else {
                    res = temp;
                }
            }
        }
      }
    }
    return res;
  }
}