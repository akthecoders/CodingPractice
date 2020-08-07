//Symmetric Tree
public class P101 {
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return traverse(root, root);
    }

    public boolean traverse(TreeNode original, TreeNode mirror) {
        if (original == null && mirror == null)
            return true;
        if (original == null)
            return false;
        if (mirror == null)
            return false;

        if (original.val != mirror.val) {
            return false;
        }

        return traverse(original.left, mirror.right) && traverse(original.right, mirror.left);
    }
}