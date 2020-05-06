// Maximum Depth of Binary Tree
public class P104 {
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root);
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(helper(root.left), helper(root.right));
    }
}