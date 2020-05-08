// Minimum Depth of Binary Tree
public class P111 {
    int minLevel = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        helper(root, 1);
        return minLevel;
    }

    public void helper(TreeNode root, int level) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (level < minLevel) {
                minLevel = level;
            }
            return;
        }
        helper(root.left, 1 + level);
        helper(root.right, 1 + level);
    }
}