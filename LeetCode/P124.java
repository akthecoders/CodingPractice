//Binary Tree Maximum Path Sum
public class P124 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int p = dfs(root);
        return max == 0 ? p : max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        if (leftMax > 0 && rightMax > 0) {
            max = Math.max(max, leftMax + root.val + rightMax);
        }
        int localMax = Math.max(Math.max(root.val, root.val + leftMax), root.val + rightMax);
        max = Math.max(localMax, max);
        return localMax;
    }
}