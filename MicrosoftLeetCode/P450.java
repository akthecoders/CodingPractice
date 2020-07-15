//Delete Node in a BST
public class P450 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (isLeaf(root)) {
                root = null;
            } else if (root.right != null) {
                TreeNode successor = successor(root);
                root.val = successor.val;
                root.right = deleteNode(root.right, root.val);
            } else {
                TreeNode predessor = predecessor(root);
                root.val = predessor.val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public TreeNode successor(TreeNode root) {
        root = root.right;
        while (root.left != null)
            root = root.left;
        return root;
    }

    public TreeNode predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null)
            root = root.right;
        return root;
    }
}