// Univalued Binary Tree
public class P965 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        return helper(root, root.val);
    }

    public boolean helper(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        if (helper(root.left, val)) {
            if (helper(root.right, val)) {
                return true;
            }
            return false;
        }
        return false;
    }
}