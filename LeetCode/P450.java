//Delete Node in a BST
public class P450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null || root.right == null) {
                if (root.right == null)
                    return root.left;
                if (root.left == null)
                    return root.right;
            } else {
                root.val = findMin(root.right).val;
                root.right = deleteNode(root.right, root.val);
            }
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}