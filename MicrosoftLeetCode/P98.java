//Validate Binary Search Tree
public class P98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isValidBST(TreeNode root) {
        return inorder(root, null, null);
    }

    public boolean inorder(TreeNode root, Integer lower, Integer upper) {
        if (root == null)
            return true;
        int val = root.val;
        if (lower != null && val <= lower)
            return false;
        if (upper != null && val >= upper)
            return false;

        if (!inorder(root.left, lower, root.val))
            return false;
        if (!inorder(root.right, root.val, upper))
            return false;

        return true;
    }
}