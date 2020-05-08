//  Path Sum
public class P112 {
    boolean ans = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        helper(root, sum);
        return ans;
    }

    public void helper(TreeNode root, int sum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            sum = sum - root.val;
            if (sum == 0)
                ans = true;
            return;
        }

        helper(root.left, sum - root.val);
        helper(root.right, sum - root.val);
    }
}