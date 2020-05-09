//Distribute Coins in Binary Tree
public class P979 {
    int ans = 0;

    public int distributeCoins(TreeNode root) {
        helper(root);
        return ans;
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int l = helper(root.left);
        int r = helper(root.right);

        ans += Math.abs(l) + Math.abs(r);
        return root.val + l + r - 1;
    }
}