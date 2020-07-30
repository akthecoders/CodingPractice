import java.util.ArrayDeque;

//Inorder Successor in BST
public class P285 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            p = p.right;
            while (p.left != null)
                p = p.left;
            return p;
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int inOrder = Integer.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (inOrder == p.val)
                return root;
            inOrder = root.val;

            root = root.right;
        }

        return null;
    }
}