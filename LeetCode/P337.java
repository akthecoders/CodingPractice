// House Robber III
public class P337 {
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        return helper(root);
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int firstVal = root.val;
        if (left != null) {
            firstVal += helper(left.left);
            firstVal += helper(left.right);
        }
        if (right != null) {
            firstVal += helper(right.left);
            firstVal += helper(right.right);
        }

        int secondVal = helper(left) + helper(right);
        return Math.max(firstVal, secondVal);
    }
}