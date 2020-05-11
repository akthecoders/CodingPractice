//Add One Row to Tree
public class P623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        return helper(root, v, d - 1);
    }

    public TreeNode helper(TreeNode root, int v, int d) {
        if (root == null) {
            return null;
        }
        if (d == 1) {
            TreeNode left = new TreeNode(v);
            left.left = root.left;
            root.left = left;
            TreeNode right = new TreeNode(v);
            right.right = root.right;
            root.right = right;
            return root;
        }
        root.left = helper(root.left, v, d - 1);
        root.right = helper(root.right, v, d - 1);
        return root;
    }
}