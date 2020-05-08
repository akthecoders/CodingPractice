//Path Sum III
public class P437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return helper(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int helper(TreeNode root, int sum, int currVal) {
        if (root == null)
            return 0;
        currVal += root.val;

        int result = (sum == currVal) ? 1 : 0;
        return result + helper(root.left, sum, currVal) + helper(root.right, sum, currVal);
    }
}