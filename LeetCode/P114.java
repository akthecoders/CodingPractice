// Flatten Binary Tree to Linked List
public class P114 {
    TreeNode prev;

    public void flatten(TreeNode root) {
        helper(root);
    }

    public void helper(TreeNode root) {
        if (root == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (prev != null) {
            prev.right = root;
            prev.left = null;
        }
        prev = root;
        helper(left);
        helper(right);
    }
}