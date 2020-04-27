// Longest Univalue Path

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class P687 {
    
    int diameter = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, root.val);
        return diameter;
    }

    public int helper(TreeNode root, int prev) {
        if (root == null) {
            return 0;
        }

        int lP = helper(root.left, root.val);
        int rP = helper(root.right, root.val);

        diameter = Math.max(diameter, lP + rP);
        if (root.val != prev)
            return 0;
        return Math.max(lP, rP) + 1;
    }
}