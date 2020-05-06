// Trim a Binary Search Tree
public class P669 {
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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        if (root.val < L) {
            return root.right;
        }
        if (root.val > R) {
            return root.left;
        }
        return root;
    }
}