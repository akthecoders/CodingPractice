package trees;

/**
 * ReplaceNodeWithDepth
 */
public class ReplaceNodeWithDepth {
  
  public static void replaceNodeWithDepth(TreeNode<Integer> root) {
    executor(root, 0);
  }

  private static void executor(TreeNode<Integer> root, int level) {
    if(root == null) {
      return;
    }
    root.data = level;
    for(int i = 0; i < root.children.size(); i++) {
      executor(root.children.get(i), level + 1);
    }
  }
}