// Sum of Left Leaves
public class P404 {
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
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, null);
        return sum;
    }

    public void helper(TreeNode root, TreeNode prev) {
        if (prev != null && root != null && root.left == null && root.right == null && prev.left == root) {
            sum += root.val;
            return;
        }
        if (root == null) {
            return;
        }
        helper(root.left, root);
        helper(root.right, root);
    }
}