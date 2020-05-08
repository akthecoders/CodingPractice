//Balanced Binary Tree
public class P110 {
    boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        helper(root);
        return ans;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = helper(root.left);
        int R = helper(root.right);
        if (Math.abs(L - R) > 1) {
            ans = false;
        }
        return 1 + Math.max(L, R);
    }
}