// Binary Tree Maximum Path Sum
public class P124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);
        return sum;
    }

    public int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(solve(root.left), 0);
        int rightSum = Math.max(solve(root.right), 0);

        int pathCost = root.val + leftSum + rightSum;
        sum = Math.max(pathCost, sum);
        return root.val + Math.max(leftSum, rightSum);
    }
}