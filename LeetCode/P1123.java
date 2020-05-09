//Lowest Common Ancestor of Deepest Leaves
public class P1123 {
    int height = 0;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null)
            return null;
        height = getHeight(root);
        return helper(root, 1);
    }

    public TreeNode helper(TreeNode root, int currLevel) {
        if (root == null)
            return null;
        if (currLevel == height)
            return root;
        TreeNode left = helper(root.left, 1 + currLevel);
        TreeNode right = helper(root.right, 1 + currLevel);

        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        if (right != null)
            return right;
        return null;
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}