//Smallest Subtree with all the Deepest Nodes
public class P865 {
    int deepest = 0;
    TreeNode res = null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        helper(root, 0);
        return res;
    }

    public int helper(TreeNode root, int deep) {
        deepest = Math.max(deepest, deep);
        if (root == null)
            return deep;
        int left = helper(root.left, 1 + deep);
        int right = helper(root.right, 1 + deep);

        if (left == deepest && right == deepest) {
            res = root;
        }
        return Math.max(left, right);
    }
}