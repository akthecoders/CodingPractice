//Maximum Binary Tree II
public class P998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || root.val < val) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}