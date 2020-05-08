// Insert into a Binary Search Tree
public class P701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        TreeNode insertNode = new TreeNode(val);

        TreeNode curr = root;
        TreeNode parent = null;
        while (curr != null) {
            parent = curr;
            if (val > curr.val) {
                curr = curr.right;
            } else
                curr = curr.left;
        }

        if (val > parent.val) {
            parent.right = insertNode;
        } else
            parent.left = insertNode;
        return root;
    }
}