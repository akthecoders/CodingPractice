//Find Elements in a Contaminated Binary Tree
public class P1216 {
    TreeNode gRoot;

    public P1216(TreeNode root) {
        if(root == null) return;
        helper(root, 0);
        gRoot = root;
    }

    public void helper(TreeNode root, int val) {
        if (root == null)
            return;
        root.val = val;
        helper(root.left, (2 * val) + 1);
        helper(root.right, (2 * val) + 2);
    }

    public boolean find(int target) {
        return finder(gRoot, target);
    }

    public boolean finder(TreeNode root, int target) {
        if (root == null)
            return false;
        if (root.val == target)
            return true;

        return finder(root.left, target) || finder(root.right, target);
    }
}